package mybatis;

import java.lang.reflect.Method;

import org.apache.ibatis.session.SqlSession;
/**
 * Gestione	TLS (Thread Local Storage)
 * Classe che viene salvata  nella mappa local del thread corrente
 * @author f.vona
 */
public class ThreadContext {
	/**
	 * Id gerarato randomicamente
	 * all'apertura della connessione
	 */
	private String userId;
	/**
	 * Id gerarato randomicamente
	 * all'apertura della connessione
	 */
	private Long transactionId;
	/**
	 * Variabile utilizzata per eseguire chiamate ai mapper mybatis 
	 */
	private SqlSession sqlSession;
	/**
	 * Gestisce se attivare o no la transazione per lo statement
	 */
	private boolean autoCommit;
	/**
	 * Utilizzata per distribuire la stessa transazione a piu service
	 */
	private Method method;

	public boolean isAutoCommit() {
		return autoCommit;
	}
	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}
	private static ThreadLocal<ThreadContext> threadLocal = new ThreadLocal<ThreadContext>(){
		@Override
		protected ThreadContext initialValue() {
			return new ThreadContext();
		}
	};
	public static ThreadContext get() {
		return threadLocal.get();
	}
	public static void remove() {
		threadLocal.remove();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public String toString() {
		return "ThreadContext [userId=" + userId + ", transactionId="
				+ transactionId + ", sqlSession=" + sqlSession
				+ ", autoCommit=" + autoCommit + ", method=" + method + "]";
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
}