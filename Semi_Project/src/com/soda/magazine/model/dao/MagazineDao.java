package com.soda.magazine.model.dao;

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

import com.soda.magazine.model.vo.MagazineFile;
import com.soda.lesson.model.vo.Attachment;
import com.soda.magazine.model.vo.Magazine;
import com.soda.magazine.model.vo.PageInfo;



public class MagazineDao {
	
	// xml 읽어오기
	private Properties magazineQuery;
	
	public MagazineDao() { 
		magazineQuery = new Properties();
		// 작성한 쿼리문(xml) 경로 읽어오기
		String fileName = MagazineDao.class.getResource("/com/sql/magazine/magazine-query.xml").getPath();
		try {
			// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
			magazineQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	// 게시물 개수 조회
//	public int getListCount(Connection conn) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String sql = magazineQuery.getProperty("getListCount");
//		int listCount = 0;
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				listCount = rset.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//			close(rset);
//		}
//		return listCount;
//	}


	// 게시물 리스트 조회
		public List<Magazine> selectList(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = magazineQuery.getProperty("selectList");
			List<Magazine> magazineList = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Magazine magazine = new Magazine();
					magazine.setnNum(rset.getInt("magazine_num"));
					magazine.setnTitle(rset.getNString("magazine_title"));
					magazine.setnStatus(rset.getString("magazine_status"));
					magazine.setnDate(rset.getDate("magazine_date"));
					magazine.setUserId(rset.getString("user_name"));
					magazine.setModifyDate(rset.getDate("modify_date"));
					
					List<MagazineFile> photoList = new ArrayList<>();
					MagazineFile photo = new MagazineFile();
					photo.setFileNum(rset.getInt("file_num"));
					photo.setOriginName(rset.getString("origin_name"));
					photo.setChangeName(rset.getString("change_name"));
					photo.setRoute(rset.getString("route"));
					photo.setFileLevel(rset.getInt("file_level"));
					photo.setStatus(rset.getString("status"));
					
					photoList.add(photo);
					
					magazine.setPhotoList(photoList);
					
					magazineList.add(magazine);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return magazineList;
		}


		
		public int insertMagazine(Connection conn, Magazine magazine) {
			 PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("insertMagazine");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, magazine.getnTitle());
		         pstmt.setString(2, magazine.getnContent());
		         pstmt.setString(3, magazine.getnType());
		         pstmt.setString(4, magazine.getUserId());
		         
		         result = pstmt.executeUpdate();
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      return result;
		   }
		
		
		public int insertFile(Connection conn, MagazineFile photoList) {
			   PreparedStatement pstmt = null;
	            int result = 0;
	            String sql = magazineQuery.getProperty("insertFile");
	            
	            try {
	               pstmt = conn.prepareStatement(sql);
	               
	               pstmt.setString(1,  photoList.getRoute());
	               pstmt.setString(2,  photoList.getOriginName());
	               pstmt.setInt(3, photoList.getFileLevel());
	               pstmt.setString(4,  photoList.getChangeName());
	               
	               result = pstmt.executeUpdate();
	               
//	               System.out.println(result);
//	               System.out.println(pstmt);
	               
	            } catch (SQLException e) {
	               e.printStackTrace();
	            } finally {
	               close(pstmt);
	            }
	            
	            return result;
	         }


		

		public List<MagazineFile> selectPhotoList(Connection conn, int nNum) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<MagazineFile> photoList = new ArrayList<>();
			String sql = magazineQuery.getProperty("selectPhotoList");
			
			try {
				pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				MagazineFile attachment = new MagazineFile();
				attachment.setFileNum(rset.getInt("file_num"));
				attachment.setOriginName(rset.getString("origin_name"));
				attachment.setChangeName(rset.getString("change_name"));
				attachment.setRoute(rset.getString("route"));
				attachment.setFileLevel(rset.getInt("file_level"));
				
				photoList.add(attachment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return photoList;
	}


		// 조회수 증가
		public int increaseCount(Connection conn, int nNum) {
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = magazineQuery.getProperty("increaseCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, nNum);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
		
		
		// 매거진 상세 페이지 조회
		public Magazine selectMagazine(Connection conn, int nNum) {
			  PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      Magazine magazine = null;
		      String sql = magazineQuery.getProperty("selectMagazine");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, nNum);
		         rset = pstmt.executeQuery();
		         
		         
		         if(rset.next()) {
		        	magazine = new Magazine();
		        	magazine.setnNum(rset.getInt("notice_num"));
		        	magazine.setnTitle(rset.getString("notice_title"));
		        	magazine.setnContent(rset.getString("notice_content"));
		        	magazine.setnDate(rset.getDate("notice_date"));
		        	magazine.setnStatus(rset.getString("notice_status"));
		        	magazine.setnType(rset.getString("notice_type"));
		        	magazine.setUserId(rset.getString("user_id"));
		        	magazine.setnDate(rset.getDate("modify_date"));
		        	magazine.setSelfNum(rset.getString("notice_self_num"));
		        	magazine.setnCount(rset.getInt("ncount"));
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(pstmt);
		      }
		      
		      
		      System.out.println(magazine);
		      return magazine;
		}

		
		// 매거진 메인 화면
		public List<Magazine> selectMagazineList(Connection conn) {
			   PreparedStatement pstmt = null;
		         ResultSet rset = null;
		         List<Magazine> magazineList = new ArrayList<>();
		         String sql = magazineQuery.getProperty("selectMagazineList");
		         
		            try {
		               pstmt = conn.prepareStatement(sql);
		               rset = pstmt.executeQuery();
		               
		               while(rset.next()) {   // next() : 다음 행
		                  Magazine magazine = new Magazine();
		                  magazine.setnNum(rset.getInt("notice_num"));
		                  magazine.setnType(rset.getString("notice_type"));
		                  magazine.setnTitle(rset.getString("notice_title"));
		                  magazine.setUserId(rset.getString("user_id"));
		                  magazine.setnCount(rset.getInt("ncount"));
		                  
		                  List<MagazineFile> photoList = new ArrayList<>();
		                  MagazineFile photo = new MagazineFile();
		                  photo.setRoute(rset.getString("route"));
		                  photo.setChangeName(rset.getString("change_name"));
		                  photoList.add(photo);
		                  magazine.setPhotoList(photoList);
		                  
		                  magazineList.add(magazine);
		               }
		               
		            } catch (SQLException e) {
		               e.printStackTrace();
		            } finally {
		               close(rset);
		               close(pstmt);
		            }
		            
		         
		         return magazineList;
		      }

		
		
		
		
		
		
		
		
		
		}


		
