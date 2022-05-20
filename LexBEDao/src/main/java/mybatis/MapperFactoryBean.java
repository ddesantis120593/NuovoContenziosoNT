package mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Classe di utilit� dao my batis, permette di creare un
 * mapper dalla sqlSession custom chiamato sqlSessionTemplate che inserisce un handler
 * all'invocazione del metodo di my batis.
 */
public class MapperFactoryBean {

	private SqlSessionFactory sqlSessionFactory;

	private boolean addToConfig = true;

	/**
	 * Costruttore con parametro sqlSessionFactory
	 * @param sqlSessionFactory
	 * @throws Exception
	 */
	public MapperFactoryBean(SqlSessionFactory sqlSessionFactory) throws Exception {
		if(sqlSessionFactory==null) throw new Exception("Property 'sqlSessionFactory' is required");
		this.sqlSessionFactory = sqlSessionFactory; 
	}
	/**
	 * Aggiunge il mapper nella configurazione
	 * se gia non esiste
	 * @param mapperInterface
	 */
	public void addToConfig(Class<?> mapperInterface){
		synchronized(getConfiguration()){
			if (this.addToConfig && !getConfiguration().hasMapper(mapperInterface)) {
				getConfiguration().addMapper(mapperInterface);
			}
		}
	}

	/**
	 * Ritorna l'istanza del mapper collegata al session template
	 * @param <T> Interfaccia del mapper
	 * @param mapperInterface
	 * @return Istanza del mapper
	 * @throws Exception
	 */
	public <T> T getMapper(Class<T> mapperInterface) throws Exception {
		if(sqlSessionFactory==null) throw new Exception("Property 'sqlSessionFactory' is required");
		if(mapperInterface==null) throw new Exception("Property 'mapperInterface' is required");
		addToConfig(mapperInterface);
        try {
        	ThreadContext threadContext = ThreadContext.get();
        	SqlSession sqlSession = threadContext.getSqlSession();
        	if(sqlSession==null) throw new Exception("Property 'sqlSession' of 'ThreadContext' is required");
            T mapper = getConfiguration().getMapper(mapperInterface,sqlSession);
            return mapper; 
        } catch (Exception e) {
			throw new Exception("Exception in getMapper",e);
        }
	}

	/**
	 * Flag che specifica se inserire il mapper nella configurazione
	 * @param addToConfig
	 */
	public void setAddToConfig(boolean addToConfig) {
		this.addToConfig = addToConfig;
	}
    
	/**
	 * Metodo get sqlSessionFactory
	 * @return {@link SqlSessionFactory}
	 */
    public SqlSessionFactory getSqlSessionFactory() {
        return this.sqlSessionFactory;
    }
 
    /**
     * Ritorna l'oggetto configuration dal sqlSessionFactory
     * @return {@link Configuration}
     */
    public Configuration getConfiguration() {
        return this.sqlSessionFactory.getConfiguration();
    }
}