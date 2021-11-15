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
import com.soda.magazine.model.vo.Reply;



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
					magazine.setnTitle(rset.getString("magazine_title"));
					magazine.setnStatus(rset.getString("magazine_status"));
					magazine.setnDate(rset.getTimestamp("magazine_date"));
					magazine.setUserId(rset.getString("user_name"));
					magazine.setModifyDate(rset.getTimestamp("modify_date"));
					
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


		
		public int insertUser(Connection conn, Magazine user) {
			 PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("insertUser");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, user.getnTitle());
		         pstmt.setString(2, user.getnContent());
		         pstmt.setString(3, user.getnType());
		         pstmt.setString(4, user.getUserId());
		         
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


//		// 조회수 증가
//		public int increaseCount(Connection conn, int nNum) {
//			PreparedStatement pstmt = null;
//			int result = 0;
//			String sql = magazineQuery.getProperty("increaseCount");
//			
//			try {
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setInt(1, nNum);
//				
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				close(pstmt);
//			}
//			return result;
//		}
		
		
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
		        	magazine.setnDate(rset.getTimestamp("notice_date"));
		        	magazine.setnStatus(rset.getString("notice_status"));
		        	magazine.setnType(rset.getString("notice_type"));
		        	magazine.setUserId(rset.getString("user_id"));
		        	magazine.setnDate(rset.getTimestamp("modify_date"));
		        	magazine.setSelfNum(rset.getString("notice_self_num"));
		        	magazine.setnCount(rset.getInt("ncount"));
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(pstmt);
		      }
		      
		      return magazine;
		}

		
		// 매거진 메인 화면
		public List<Magazine> selectUserList(Connection conn) {
			   PreparedStatement pstmt = null;
		         ResultSet rset = null;
		         List<Magazine> userList = new ArrayList<>();
		         String sql = magazineQuery.getProperty("selectUserList");
		         
		            try {
		               pstmt = conn.prepareStatement(sql);
		               rset = pstmt.executeQuery();
		               
		               while(rset.next()) {   // next() : 다음 행
		                  Magazine user = new Magazine();
		                  user.setnNum(rset.getInt("notice_num"));
		                  user.setnType(rset.getString("notice_type"));
		                  user.setnTitle(rset.getString("notice_title"));
		                  user.setUserId(rset.getString("user_id"));
		                  user.setnCount(rset.getInt("ncount"));
		                  
		                  List<MagazineFile> photoList = new ArrayList<>();
		                  MagazineFile photo = new MagazineFile();
		                  photo.setRoute(rset.getString("route"));
		                  photo.setChangeName(rset.getString("change_name"));
		                  photo.setFileLevel(rset.getInt("file_level"));
		                  photoList.add(photo);
		                  user.setPhotoList(photoList);
		                  
		                  userList.add(user);
		               }
		               
		            } catch (SQLException e) {
		               e.printStackTrace();
		            } finally {
		               close(rset);
		               close(pstmt);
		            }
		            
		         
		         return userList;
		      }


		public int insertAdmin(Connection conn, Magazine admin) {
			 PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("insertAdmin");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, admin.getnTitle());
		         pstmt.setString(2, admin.getnContent());
		         pstmt.setString(3, admin.getnType());
		         pstmt.setString(4, admin.getUserId());
		         
		         result = pstmt.executeUpdate();
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      return result;
		   }

		
		
		// 관리자 메인 페이지 조회
		public List<Magazine> selectAdminList(Connection conn) {
			PreparedStatement pstmt = null;
	         ResultSet rset = null;
	         List<Magazine> magazineAdminList = new ArrayList<>();
	         String sql = magazineQuery.getProperty("selectAdminList");
	         
	            try {
	               pstmt = conn.prepareStatement(sql);
	               rset = pstmt.executeQuery();
	               
	               while(rset.next()) {   // next() : 다음 행
	                  Magazine admin = new Magazine();
	                  admin.setnNum(rset.getInt("notice_num"));
	                  admin.setnType(rset.getString("notice_type"));
	                  admin.setnTitle(rset.getString("notice_title"));
	                  admin.setUserId(rset.getString("user_id"));
	                  admin.setnCount(rset.getInt("ncount"));
	                  
	                  List<MagazineFile> photoList = new ArrayList<>();
	                  MagazineFile photo = new MagazineFile();
	                  photo.setRoute(rset.getString("route"));
	                  photo.setChangeName(rset.getString("change_name"));
	                  photo.setFileLevel(rset.getInt("file_level"));
	                  photoList.add(photo);
	                  admin.setPhotoList(photoList);
	                  
	                  magazineAdminList.add(admin);
	               }
	               
	            } catch (SQLException e) {
	               e.printStackTrace();
	            } finally {
	               close(rset);
	               close(pstmt);
	            }
	            
	         
	         return magazineAdminList;
	      }


		public int deleteMagazine(Connection conn, int nNum) {
			PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("deleteMagazine");
		      
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


		public int deletePhoto(Connection conn, int nNum) {
			 PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("deletePhoto");      
		      
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


		public int updateMagazine(Connection conn, Magazine magazine) {
			 PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("updateMagazine");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         
		         pstmt.setString(1, magazine.getnType());
		         pstmt.setString(2, magazine.getnTitle());
		         pstmt.setString(3, magazine.getnContent());
		         pstmt.setInt(4, magazine.getnNum());
		         
		         result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      return result;
		   }



		public int updatePhoto(Connection conn, MagazineFile photo) {
			 PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("updatePhoto");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         
		         pstmt.setString(1, photo.getOriginName());
		         pstmt.setString(2, photo.getChangeName());
		         pstmt.setString(3, photo.getDeletedName());
		         
		         result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      return result;
		   }


		public int insertAddedPhoto(Connection conn, int getnNum, MagazineFile photo) {
			PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("insertAddedPhoto");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         
		            pstmt.setInt(1,  photo.getnNum());
		            pstmt.setString(2, photo.getRoute());
		            pstmt.setString(3,  photo.getOriginName());
		            pstmt.setInt(4, photo.getFileLevel());
		            pstmt.setString(5,  photo.getChangeName());
		            
		            result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      return result;
		   }


		public int insertReply(Connection conn, Reply reply) {
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = magazineQuery.getProperty("insertReply");
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reply.getrContent());
				pstmt.setInt(2, reply.getnNum());
				pstmt.setString(3, reply.getrWriter());
				
				
				result = pstmt.executeUpdate();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			
			return result;
		}


		public List<Reply> selectReplyList(Connection conn, int nNum) {

			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<Reply> replyList = new ArrayList<>();
			String sql = magazineQuery.getProperty("selectReplyList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,  nNum);
				
				rset = pstmt.executeQuery();
			
				
				
				while(rset.next()) {
					Reply reply = new Reply();
				
					reply.setrNum(rset.getInt("reply_num"));
					reply.setrContent(rset.getString("reply_content"));
					reply.setrDate(rset.getTimestamp("reply_date"));
					reply.setnNum(rset.getInt("notice_num"));
					reply.setrWriter(rset.getString("rwriter"));
					reply.setrStatus(rset.getString("reply_status"));
					reply.setrModifyDate(rset.getTimestamp("reply_modifydate"));
					
					replyList.add(reply);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return replyList;
		}


		public List<Magazine> selectUserselfList(Connection conn) {
			PreparedStatement pstmt = null;
	         ResultSet rset = null;
	         List<Magazine> userselfList = new ArrayList<>();
	         String sql = magazineQuery.getProperty("selectUserselfList");
	         
	            try {
	               pstmt = conn.prepareStatement(sql);
	               
	               rset = pstmt.executeQuery();
	               
	               while(rset.next()) {   // next() : 다음 행
	                  Magazine userself = new Magazine();
	                  userself.setnNum(rset.getInt("notice_num"));
	                  userself.setnType(rset.getString("notice_type"));
	                  userself.setnTitle(rset.getString("notice_title"));
	                  userself.setUserId(rset.getString("user_id"));
	                  
	                  List<MagazineFile> photoList = new ArrayList<>();
	                  MagazineFile photo = new MagazineFile();
	                  photo.setRoute(rset.getString("route"));
	                  photo.setChangeName(rset.getString("change_name"));
	                  photo.setFileLevel(rset.getInt("file_level"));
	                  photoList.add(photo);
	                  userself.setPhotoList(photoList);
	                  
	                  userselfList.add(userself);
	               }
	               
	            } catch (SQLException e) {
	               e.printStackTrace();
	            } finally {
	               close(rset);
	               close(pstmt);
	            }
	       
	        	 return userselfList;
	      }


		public List<Magazine> selectOthersList(Connection conn, String userId) {
			PreparedStatement pstmt = null;
	         ResultSet rset = null;
	         List<Magazine> othersList = new ArrayList<>();
	         String sql = magazineQuery.getProperty("selectOthersList");
	         
	            try {
	               pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,  userId);
	               rset = pstmt.executeQuery();
	               
	               while(rset.next()) {   // next() : 다음 행
	                  Magazine userself = new Magazine();
	                  userself.setnNum(rset.getInt("notice_num"));
	                  userself.setnType(rset.getString("notice_type"));
	                  userself.setnTitle(rset.getString("notice_title"));
	                  userself.setUserId(rset.getString("user_id"));
	                  
	                  List<MagazineFile> photoList = new ArrayList<>();
	                  MagazineFile photo = new MagazineFile();
	                  photo.setRoute(rset.getString("route"));
	                  photo.setChangeName(rset.getString("change_name"));
	                  photo.setFileLevel(rset.getInt("file_level"));
	                  photoList.add(photo);
	                  userself.setPhotoList(photoList);
	                  
	                  othersList.add(userself);
	               }
	               
	            } catch (SQLException e) {
	               e.printStackTrace();
	            } finally {
	               close(rset);
	               close(pstmt);
	            }
	       
	        	 return othersList;
		}



		

		public int deleteReply(Connection conn, int rNum) {
			PreparedStatement pstmt = null;
		      int result = 0;
		      String sql = magazineQuery.getProperty("deleteReply");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, rNum);
		         
		         result = pstmt.executeUpdate();   
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		            
		      return result;
		   }


		public int getListCount(Connection conn) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = magazineQuery.getProperty("getListCount");
			int listCount = 0;
			

			try {
				pstmt = conn.prepareStatement(sql);
				
				
				rset = pstmt.executeQuery();

				if(rset.next()) {
					listCount = rset.getInt(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return listCount;
		}



		
		
		
		
		
		
		
		}




		
