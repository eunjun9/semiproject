package com.soda.mypage.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public int insertProfile(Connection conn, Profile profile) {
		PreparedStatement pstmt = null;
	      int result = 0;
	      String sql = profileQuery.getProperty("insertProfile");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, profile.getUserId());
	         pstmt.setString(2, profile.getIntroduction());
	         pstmt.setString(3, profile.getSns());
	         pstmt.setString(4, profile.getInterest());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
	}
	
	
	public int insertFile(Connection conn, ProfileFile file) {
	       PreparedStatement pstmt = null;
           int result = 0;
           String sql = profileQuery.getProperty("insertFile");
           
           try {
              pstmt = conn.prepareStatement(sql);
              
              pstmt.setString(1,  file.getRoute());
              pstmt.setString(2,  file.getUserId());
              pstmt.setString(3,  file.getOriginName());
              pstmt.setString(4,  file.getChangeName());
              
              result = pstmt.executeUpdate();
              
           } catch (SQLException e) {
              e.printStackTrace();
           } finally {
              close(pstmt);
           }
           
           return result;
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

	
	public int modifyFile(Connection conn, ProfileFile file) {
		PreparedStatement pstmt = null;
        int result = 0;
        String sql = profileQuery.getProperty("modifyFile");
        
        try {
           pstmt = conn.prepareStatement(sql);
           
           pstmt.setString(1,  file.getRoute());
           pstmt.setString(2,  file.getOriginName());
           pstmt.setString(3,  file.getChangeName());
           pstmt.setString(4,  file.getUserId());
           
           result = pstmt.executeUpdate();
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           close(pstmt);
        }
        
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
	        	 profile.setIntroduction(rset.getString("introduction"));
	        	 profile.setSns(rset.getString("sns"));
	        	 profile.setInterest(rset.getString("interest"));
	         }
	         
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
//	     System.out.println(profile);
	      return profile;
	}

	public List<ProfileFile> selectProfileFile(Connection conn, String userId) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      List<ProfileFile> profileFile = new ArrayList<>();
	      String sql = profileQuery.getProperty("selectProfileFile");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset.next()) {
	        	 ProfileFile file = new ProfileFile();
	        	 file.setFileNo(rset.getInt("FILE_NO"));
	        	 file.setRoute(rset.getString("route"));
	        	 file.setUserId(rset.getString("USER_ID"));
	        	 file.setOriginName(rset.getString("ORIGIN_NAME"));
	        	 file.setChangeName(rset.getString("CHANGE_NAME"));
	        	 file.setStatus(rset.getString("STATUS"));
	        	 profileFile.add(file);
	        	 
	        	 
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	         
	      }
	      return profileFile;
	}

	
	public Profile selectOthers(Connection conn, String userId) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      Profile profile = null;
	      String sql = profileQuery.getProperty("selectOthers");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset.next()) {
	        	 profile = new Profile();
	        	 profile.setUserId(rset.getString("user_id"));
	        	 profile.setUserName(rset.getString("user_name"));
	        	 profile.setUserGrade(rset.getString("user_grade"));
	        	 profile.setIntroduction(rset.getString("introduction"));
	        	 profile.setSns(rset.getString("sns"));
	        	 profile.setInterest(rset.getString("interest"));
	         }
	         
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
//	     System.out.println(profile);
	      return profile;
	}

	
	
	/* nnum 값으로 다른 사람 아이디 조회*/
	public Profile selectOthers(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      Profile profile = null;
	      String sql = profileQuery.getProperty("selectOthersnNum");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, nNum);
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset.next()) {
	        	 profile = new Profile();
	        	 profile.setUserId(rset.getString("user_id"));
	        	 profile.setIntroduction(rset.getString("introduction"));
	        	 profile.setSns(rset.getString("sns"));
	        	 profile.setInterest(rset.getString("interest"));
	         }
	         
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
//	     System.out.println(profile);
	      return profile;
	}

	/* nnum 값으로 다른 사람 아이디 조회*/
	public List<ProfileFile> selectProfileFile(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      List<ProfileFile> profileFile = new ArrayList<>();
	      String sql = profileQuery.getProperty("selectProfileFilenNum");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, nNum);
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset.next()) {
	        	 ProfileFile file = new ProfileFile();
	        	 file.setFileNo(rset.getInt("FILE_NO"));
	        	 file.setRoute(rset.getString("route"));
	        	 file.setUserId(rset.getString("USER_ID"));
	        	 file.setOriginName(rset.getString("ORIGIN_NAME"));
	        	 file.setChangeName(rset.getString("CHANGE_NAME"));
	        	 file.setStatus(rset.getString("STATUS"));
	        	 profileFile.add(file);
	        	 
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	         
	      }
	      return profileFile;
	}

	


	}

