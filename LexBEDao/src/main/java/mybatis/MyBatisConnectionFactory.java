package mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class MyBatisConnectionFactory {

	private SqlSessionFactory sqlSessionFactory;
	public static final String RESOURCE = "mybatis-config.xml";
	private static HashMap<String, MyBatisConnectionFactory> mapInstance = new HashMap<String, MyBatisConnectionFactory>(0);
	final static Logger logger = Logger.getLogger(MyBatisConnectionFactory.class);
	
	private MyBatisConnectionFactory(String environment) throws Exception {
		try {
			Reader reader = Resources.getResourceAsReader(RESOURCE);
			if (sqlSessionFactory == null) {
//				if(ConfigCache.getConfigProperties()== null)
//					throw new FileNotFoundException("Il riferimento al file di configurazione è null. Controllare le variabili di configurazione configFilePath , configFile nel web.xml o ejb-jar.xml");
//				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,environment,ConfigCache.getConfigProperties());
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,environment);
				//inserire di seguito l'interfaccie dei mapper
				//sqlSessionFactory.getConfiguration().addMapper(HrAllOrganizationUnitsMapper.class);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			logger.error(fileNotFoundException);
		} catch (IOException iOException) {
			logger.error(iOException);
		} catch (Exception exception) {
			logger.error(exception);
			System.out.println(exception);
		}
	}
	
	private MyBatisConnectionFactory() throws Exception {
		new MyBatisConnectionFactory(Environment.ORACLE.name());
	}
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public static MyBatisConnectionFactory getInstance() throws Exception {
		return getInstance(Environment.ORACLE.name());
	}
	public static MyBatisConnectionFactory getInstance(String environment) throws Exception{
		synchronized (mapInstance) {
			if (mapInstance.get(environment)==null) {
				mapInstance.put(environment, new MyBatisConnectionFactory(environment));
			}
		}
		return mapInstance.get(environment);
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
}
