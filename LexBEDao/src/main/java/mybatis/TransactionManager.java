package mybatis;

import java.lang.reflect.Method;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import io.github.sjmyuan.jlogger.JLogger;








public class TransactionManager {
	protected static Logger logger =  Logger.getLogger(TransactionManager.class);
	/**
	 * se non specificata l'annotation TransactionAttributeType.NOT_SUPPORTED
	 * sul metodo del l'interfaccia del service,
	 * apre una SqlSession prima dell'invocazione del metodo del service e la salva   
	 * nel {@link ThreadContext} gestito con ThreadLocal Storage
	 * @param method {@link Method} metodo che verr� invocato
	 * @param sqlSessionFactory {@link SqlSessionFactory}
	 */
	public static void manageOpenSqlSession(Method method, SqlSessionFactory sqlSessionFactory,boolean autoCommit) {
		logger.trace("manageOpenSqlSession start");
		ThreadContext threadContext = ThreadContext.get();
		logger.trace("Check SqlSession already Open");
		if(threadContext.getSqlSession()== null) {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			logger.trace("Open SqlSession success.");
			long randomLong = ((long)(Math.random() * 100000));
			logger.trace("Store SqlSession in ThreadContext");
            threadContext.setTransactionId(randomLong);
            threadContext.setUserId(String.valueOf(randomLong));
            threadContext.setAutoCommit(autoCommit);
            threadContext.setSqlSession(sqlSession);
            threadContext.setMethod(method);
            logger.trace("Store SqlSession in ThreadContext success");
		} else {
			logger.trace("SqlSession already open");
		}
        logger.trace(threadContext);
		logger.trace("manageOpenSqlSession end");
	}
	
	/**
	 * Gestione delle operazione e dei controlli per eseguire la rollback
	 */
	public static void manageRollbackSession(Method method) {
		if(checkSameMethod(method)){
			logger.trace("manageRoolbackSession start");
			ThreadContext threadContext = ThreadContext.get();
			if(threadContext.getSqlSession()!=null && !threadContext.isAutoCommit())
				threadContext.getSqlSession().rollback(true);
			logger.trace("manageRoolbackSession end");
		}
	}
	/**
	 * Gestione delle operazione e dei controlli per eseguire la commit 
	 */
	public static void manageCommitSession(Method method) {
		if(checkSameMethod(method)){
			logger.trace("manageCommitSession start");
			ThreadContext threadContext = ThreadContext.get();
			if(threadContext.getSqlSession()!=null && !threadContext.isAutoCommit()){
				threadContext.getSqlSession().commit(true);
			}
			logger.trace("manageCommitSession end");
		}
	}

	/**
	 * Gestione delle operazioni e dei controlli per la chiusura del SqlSession 
	 */
	public static void manageCloseSqlSession(Method method) {
		if(checkSameMethod(method)){
			logger.trace("manageCloseSqlSession start");
			ThreadContext threadContext = ThreadContext.get();
			logger.trace(threadContext);
			if(threadContext.getSqlSession() != null){
				logger.trace("Close SqlSession");
				threadContext.getSqlSession().close();
				logger.trace("Close SqlSession success.");
			}
			logger.trace("manageCloseSqlSession end");
		}
	}
	/**
	 * Ripulisce la variabile d'istanza SqlSession e il ThreadContext
	 */
	public static void manageCleanSqlSession(Method method) {
		if(checkSameMethod(method)){
			logger.trace("manageCleanSqlSession start");
			ThreadContext threadContext = ThreadContext.get();
			//fondamentale perchè senò open session non apre un'altra sqlSession generando eccezzione quando si lancia la query
			threadContext.setSqlSession(null);
			logger.trace(threadContext); 
			ThreadContext.remove();
			logger.trace("manageCleanSqlSession end");
		}
	}
	/**
	 * Controllo del nome del metodo per gestire transazioni distribuite tra pi�
	 * metodi
	 * @param methodInvoke
	 */
	public static boolean checkSameMethod(Method methodInvoke){
		logger.trace("checkSameMethod start");
		Method methodTc= ThreadContext.get().getMethod(); 
		if(methodTc == null)
			return true;
		boolean result = methodInvoke.getDeclaringClass().isAssignableFrom(methodTc.getDeclaringClass()) && methodInvoke.getName().equals(methodTc.getName());
		logger.trace("checkSameMethod end " +result);
		return result;
	}
}
