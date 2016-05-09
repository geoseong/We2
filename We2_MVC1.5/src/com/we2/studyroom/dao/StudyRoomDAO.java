package com.we2.studyroom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBManager;

import com.we2.studyroom.dto.StudyRoomVO;


public class StudyRoomDAO {
	private StudyRoomDAO() {
	}

	private static StudyRoomDAO instance = new StudyRoomDAO();

	public static StudyRoomDAO getInstance() {
		return instance;
	}

	
	
	// ÏµúÏã†?àú?úºÎ°? ?†ï?†¨?ïòÍ∏?
	
	
	public List<StudyRoomVO> selectAllStudyRooms() {	
		String sql = "select * from roomshare order by rcode desc";
		List<StudyRoomVO> list = new ArrayList<StudyRoomVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // ?ù¥?èô?? (?ñâ ?ã®?úÑ)
				StudyRoomVO rVo = new StudyRoomVO();
				rVo.setRcode(rs.getInt("rcode"));
				rVo.setRname(rs.getString("rname"));
				rVo.setRlocation(rs.getString("rlocation"));
				rVo.setRlocationdetail(rs.getString("rlocationdetail"));
				rVo.setRmember(rs.getInt("rmember"));
				rVo.setRcontent(rs.getString("rcontent"));
				rVo.setRpictureurl(rs.getString("rpictureurl"));
				list.add(rVo);
			}// whileÎ¨? ?Åù
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	
	}

//Í≤??ÉâÍ∏∞Îä•
	
	public List<StudyRoomVO> searchStudyRoom (String rlocation, String rlocationdetail){
						
		String sql= "select * from roomshare where rlocation=? and rlocationdetail=?";
		List<StudyRoomVO> list = new ArrayList<StudyRoomVO>();
		StudyRoomVO rVo = null;
		
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
					rVo = new StudyRoomVO();
					rVo.setRcode(rs.getInt("rcode"));
					rVo.setRname(rs.getString("rname"));
					rVo.setRlocation(rs.getString("rlocation"));
					rVo.setRlocationdetail(rs.getString("rlocationdetail"));
					rVo.setRmember(rs.getInt("rmember"));
					rVo.setRcontent(rs.getString("rcontent"));
					rVo.setRpictureurl(rs.getString("rpictureurl"));
					list.add(rVo);
				}
				
			}catch (Exception e) {
			e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		return list;
	}	
	
	
	
	// ?úÑÏπ? ?ì±Î°?
	public void insertStudyRoom(StudyRoomVO rVo) {
		String sql = "insert into roomshare values(roomshare_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rVo.getRname());
			pstmt.setString(2, rVo.getRlocation());
			pstmt.setString(3, rVo.getRlocationdetail());
			pstmt.setInt(4, rVo.getRmember());
			pstmt.setString(5, rVo.getRcontent());
			pstmt.setString(6, rVo.getRpictureurl());
			pstmt.executeUpdate(); //
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	//rcode Î≤àÌò∏Î°? ?ÉÅ?íà ?†ïÎ≥? Î∂àÎü¨?ò§Í∏?
	public StudyRoomVO selectStudyRoomByCode(String rcode) {
		String sql = "select * from roomshare where rcode=?";
			
		StudyRoomVO rVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rcode);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					rVo = new StudyRoomVO();
					rVo.setRcode(rs.getInt("rcode"));
					rVo.setRname(rs.getString("rname"));
					rVo.setRlocation(rs.getString("rlocation"));
					rVo.setRlocationdetail(rs.getString("rlocationdetail"));
					rVo.setRmember(rs.getInt("rmember"));
					rVo.setRcontent(rs.getString("rcontent"));
					rVo.setRpictureurl(rs.getString("rpictureurl"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rVo;
	}

	public void updateStudyRoom(StudyRoomVO rVo) {
		String sql = "update roomshare set rname=?, rlocation=?, rlocationdetail=?, rmember=?, rcontent=?, rpictureurl=? where rcode=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rVo.getRname());
			pstmt.setString(2, rVo.getRlocation());
			pstmt.setString(3, rVo.getRlocationdetail());
			pstmt.setInt(4, rVo.getRmember());
			pstmt.setString(5, rVo.getRcontent());
			pstmt.setString(6, rVo.getRpictureurl());
			pstmt.setInt(7, rVo.getRcode());
			pstmt.executeUpdate();// 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//?úÑÏπ? ?Ç≠?†ú

	public void deleteStudyRoom(String rcode) {
		String sql = "delete roomshare where rcode=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcode);
			pstmt.executeUpdate();// 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
