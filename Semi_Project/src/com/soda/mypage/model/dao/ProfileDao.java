package com.soda.mypage.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.soda.magazine.model.dao.MagazineDao;
import com.soda.magazine.model.vo.Magazine;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;

public class ProfileDao {

	// xml 읽어오기
	private Properties profileQuery;
	
	public ProfileDao() { 
		profileQuery = new Properties();
		// 작성한 쿼리문(xml) 경로 읽어오기
		String fileName = MagazineDao.class.getResource("/com/sql/mypage/profile-query.xml").getPath();
		try {
			// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
			profileQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int modifyProfile(Connection conn, Profile profile) {
		 PreparedStatement pstmt = null;
	      int result = 0;
	      String sql = profileQuery.getProperty("modifyProfile");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, profile.getIntroduction());
	         pstmt.setString(2, profile.getSns());
	         pstmt.setString(3, profile.getInterest());
	         pstmt.setString(4, profile.getUserId());
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
//	      System.out.println(result);
	      
	      return result;
	   }


	public Profile selectProfile(Connection conn, String userId) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      Profile profile = null;
	      String sql = profileQuery.getProperty("selectProfile");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset.next()) {
	        	 profile = new Profile();
	        	 profile.setUserId(rset.getString("user_id"));
	        	 profile.setProfile(rset.getString("profile"));
	        	 profile.setIntroduction(rset.getString("introduction"));
	        	 profile.setFeedStatus(rset.getString("feed_status"));
	        	 profile.setSocialing(rset.getString("socialing"));
	        	 profile.setSns(rset.getString("sns"));
	        	 profile.setInterest(rset.getString("interest"));
	        	 profile.setLikeSocialing(rset.getString("like_socialing"));
	         }
	         
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      return profile;
	}


	public int insertFile(Connection conn, ProfileFile photo, Profile profile) {
		   PreparedStatement pstmt = null;
           int result = 0;
           String sql = profileQuery.getProperty("insertFile");
           
           try {
              pstmt = conn.prepareStatement(sql);
              
              
//              System.out.println(photo.getRoute());
//              System.out.println(profile.getUserId());
//              System.out.println(photo.getOriginName());
//              System.out.println(photo.getChangeName());
              
              pstmt.setString(1,  photo.getRoute());
              pstmt.setString(2, profile.getUserId());
              pstmt.setString(2,  photo.getOriginName());
              pstmt.setString(3,  photo.getChangeName());
              
              result = pstmt.executeUpdate();
              
//              System.out.println(result);
//              System.out.println(pstmt);
              
           } catch (SQLException e) {
              e.printStackTrace();
           } finally {
              close(pstmt);
           }
           
           return result;
        }

	}

