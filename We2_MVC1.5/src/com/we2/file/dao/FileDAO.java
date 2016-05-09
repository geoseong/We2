package com.we2.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBManager;
import com.we2.file.dto.FileVO;


	public class FileDAO {
		private FileDAO() {
		}

		private static FileDAO instance = new FileDAO();

		public static FileDAO getInstance() {
			return instance;
		}

		
		
	// 최신순으로 정렬하기	
		public List<FileVO> selectAllFiles() {	
			String sql = "select * from fileshare order by fcode desc";
			List<FileVO> list = new ArrayList<FileVO>();
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();		
				while (rs.next()) { // 이동은 (행 단위)
					FileVO fVo = new FileVO();
					fVo.setFcode(rs.getInt("fcode"));
					fVo.setFname(rs.getString("fname"));
					fVo.setFileurl(rs.getString("fileurl"));
					fVo.setFdate(rs.getString("fdate"));				
				/*	System.out.println("fcode는 "+rs.getInt("fcode"));
					System.out.println("fcode는 "+rs.getString("fname"));
					System.out.println("fcode는 "+rs.getString("fileurl"));*/
					list.add(fVo);
				}// while문 끝
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;		
		}

/*	//검색기능
		
		public List<FileVO> searchFile (String rlocation, String rlocationdetail){
							
			String sql= "select * from fileshare where rlocation=? and rlocationdetail=?";
			List<FileVO> list = new ArrayList<FileVO>();
			FileVO fVo = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, rlocation);
					pstmt.setString(2, rlocationdetail);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						fVo = new FileVO();
						fVo.setRcode(rs.getInt("rcode"));
						fVo.setRname(rs.getString("rname"));
						fVo.setRlocation(rs.getString("rlocation"));
						fVo.setRlocationdetail(rs.getString("rlocationdetail"));
						fVo.setRmember(rs.getInt("rmember"));
						fVo.setRcontent(rs.getString("rcontent"));
						fVo.setRpictureurl(rs.getString("rpictureurl"));
						list.add(fVo);
					}
					
				}catch (Exception e) {
				e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
			return list;
		}	
		*/
		
		
		// 파일 등록
		public void insertFile(FileVO fVo) {
			String sql = "insert into fileshare values(file_seq.nextval, ?, ?, to_char(sysdate,'mm-dd/HH:MM:SS'))";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, fVo.getFname());
				pstmt.setString(2, fVo.getFileurl());
				System.out.println("fVo.getFname : " + fVo.getFname());
				System.out.println("fVo.getFileurl : " + fVo.getFileurl());
				pstmt.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		

		//fcode 번호로 상품 정보 불러오기
		public FileVO selectFileByCode(String fcode) {
			String sql = "select * from fileshare where fcode=?";
				
			FileVO fVo = null;
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, fcode);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						fVo = new FileVO();
						fVo.setFcode(rs.getInt("fcode"));
						fVo.setFname(rs.getString("fname"));
						fVo.setFileurl(rs.getString("fileurl"));
						fVo.setFdate(rs.getString("fdate"));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fVo;
		}
		
		//fcode 번호로 상품 url 불러오기
		public FileVO selectFileurlByCode(String fcode) {
			String sql = "select  fileurl where fcode=?";
				
			FileVO fVo = null;
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, fcode);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						fVo = new FileVO();
						fVo.setFcode(rs.getInt("fcode"));
						fVo.setFname(rs.getString("fname"));
						fVo.setFileurl(rs.getString("fileurl"));
					
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fVo;
		}

		public void updateFile(FileVO fVo) {
			String sql = "update fileshare set fname=?, fileurl=?, fdate=to_char(sysdate,'mm-dd/HH:MM:SS') where fcode=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, fVo.getFname());
				pstmt.setString(2, fVo.getFileurl());				
				pstmt.setInt(3, fVo.getFcode());
				pstmt.executeUpdate();// 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//파일 삭제

		public void deleteFile(String fcode) {
			String sql = "delete fileshare where fcode=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, fcode);
				pstmt.executeUpdate();// 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	
		
	
	
	}

	
	
