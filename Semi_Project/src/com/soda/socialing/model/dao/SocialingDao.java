package com.soda.socialing.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;
import com.soda.socialing.model.vo.File;
import com.soda.socialing.model.vo.Socialing;

public class SocialingDao {
	
	private Properties socialingQuery = new Properties();
	
	public SocialingDao() {
		String fileName = SocialingDao.class.getResource("/com/sql/socialing/socialing-query.xml").getPath();
		
		try {
			socialingQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Socialing> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Socialing> socialingList = new ArrayList<>();
		String sql = socialingQuery.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Socialing socialing = new Socialing();
				socialing.setnNum(rset.getInt("notice_num"));
				socialing.setnTitle(rset.getString("notice_title"));
				socialing.setSplace(rset.getString("s_place"));
				socialing.setSdate(rset.getDate("s_date"));
				
				List<File> photoList = new ArrayList<>();
				File file = new File();
				file.setRoute(rset.getString("route"));
				file.setChangeName(rset.getString("change_name"));
				photoList.add(file);
				socialing.setPhotoList(photoList);
				
				socialingList.add(socialing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return socialingList;
	}
	
}
