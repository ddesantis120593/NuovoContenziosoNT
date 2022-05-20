package it.chopper.rest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Causa;
import mybatis.CausaMapper;

public class CausaService {

	public List<Causa> getCause(SqlSession sqlSession) {
	    	CausaMapper causaMapper = sqlSession.getMapper(CausaMapper.class);
			return causaMapper.getCausa();
		}
}
