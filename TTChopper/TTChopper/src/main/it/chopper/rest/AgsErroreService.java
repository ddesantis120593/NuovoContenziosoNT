package it.chopper.rest;


import org.apache.ibatis.session.SqlSession;

import mybatis.AgsErrore;
import mybatis.AgsErroreMapper;

public class AgsErroreService {

	public AgsErrore getAgsErrori(SqlSession sqlSession) {
       //SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
    	AgsErroreMapper agsErroreMapper = sqlSession.getMapper(AgsErroreMapper.class);
        return agsErroreMapper.getAgsErrori();
	}
}
