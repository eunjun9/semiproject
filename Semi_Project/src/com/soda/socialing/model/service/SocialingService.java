package com.soda.socialing.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.soda.socialing.model.dao.SocialingDao;
import com.soda.socialing.model.vo.Socialing;

public class SocialingService {
	
	private SocialingDao socialingDao = new SocialingDao();

	public List<Socialing> selectList() {
		Connection conn = getConnection();
		
		List<Socialing> socialingList = socialingDao.selectList(conn);
		
		close(conn);
		
		return socialingList;
	}

}
