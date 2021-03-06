package kr.or.dgit.it_3st_3team.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.utils.MyBatisSqlSessionFactory;

public class SoftwareService {
	private static final SoftwareService instance = new SoftwareService();
	private static final Log log = LogFactory.getLog(SoftwareService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.SoftwareDao.";

	public static SoftwareService getInstance() {
		return instance;
	}

	private SoftwareService() {
	}

	public Software selectSoftwareByNo(Software software) {
		log.debug("selectSoftwareByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectSoftwareByNo", software);
		}
	}
	
	public Software findSoftwareByName(Software software) {
		log.debug("findSoftwareByName()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectSoftwareByName", software);
		}
	}

	public List<Software> selectSoftwareBySearch(Map<String, String> map) {
		log.debug(" selectSoftwareBySearch()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSoftwareBySearch", map);
		}
	}

	public List<Software> findSoftwareByOrder(Software software) {
		log.debug(" findSoftwareByOrder()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSoftwareByOrder", software);
		}
	}


	public List<Software> selectSoftwareByAll() {
		log.debug("selectSoftwareByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSoftwareByAll");
		}
	}

	public List<Software> findSoftwareAllByType(Map<String, String> map) {
		log.debug("findSoftwareAllByType()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSoftwareAllByType", map);
		}
	}

	public int insertSoftware(Software software) {
		log.debug("insertSoftware()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertSoftware", software);
			sqlSession.commit();
		}
		return res;
	}

	public int deleteSoftware(Software swNo) {
		log.debug("deleteSoftware()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.delete(namespace + "deleteSoftware", swNo);
			sqlSession.commit();
		}
		return res;
	}

	public int updateSoftware(Software software) {
		log.debug("updateSoftware()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "updateSoftware", software);
			sqlSession.commit();
		}
		return res;
	}

	public int deleteSoftwareColumn(Software software) {
		log.debug("deleteSoftwareColumn()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "deleteSoftwareColumn", software);
			sqlSession.commit();
		}
		return res;
	}

}
