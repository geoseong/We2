package com.saeyan.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import com.saeyan.dto.ScheduleVO;

public class ScheduleDAO {

	private ScheduleDAO(){
		
	}

	private static ScheduleDAO instance = new ScheduleDAO();

	public static ScheduleDAO getInstance() {
		return instance;
	}
	
	
// 理쒓렐 �벑濡앺븳 �긽�뭹 癒쇱� 異쒕젰�븯湲�
	
/*	public List<ScheduleVO> selectAllSchedules() {
		String sql = "select * from calendarmemo order by calendarmemo_num desc";
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // �씠�룞�� �뻾(濡쒖슦) �떒�쐞濡�
				ScheduleVO sVo = new ScheduleVO();
				sVo.setCalendarmemo_num(rs.getInt("calendarmemo_num"));
				sVo.setCalendarmemo_year(rs.getInt("calendarmemo_year"));
				sVo.setCalendarmemo_month(rs.getInt("calendarmemo_month"));
				sVo.setCalendarmemo_day(rs.getInt("calendarmemo_day"));
				sVo.setCalendarmemo_contents(rs.getString("calendarmemo_contents"));
				sVo.setCalendarmemo_id(rs.getString("calendarmemo_id"));
				sVo.setCalendarmemo_passwd(rs.getString("calendarmemo_passwd"));
				list.add(sVo);
			}// while臾� �걹
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}// selectAllProducts() {
*/
	
	
	
//�씪�젙 �벑濡�
	
	public void insertSchedule(ScheduleVO sVo) {
		String sql = "INSERT INTO calendarmemo(calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day,calendarmemo_contents, pjtcode) VALUES(schedule_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sVo.getCalendarmemo_year());
			pstmt.setInt(2, sVo.getCalendarmemo_month());
			pstmt.setInt(3, sVo.getCalendarmemo_day());
			pstmt.setString(4, sVo.getCalendarmemo_contents());
			pstmt.setString(5, sVo.getPjtCode());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	
	public ScheduleVO selectScheduleByCalendarmemo_num(String calendarmemo_num) {
		String sql = "select * from calendarmemo where calendarmemo_num=?";
		System.out.println("calendarmemo_num: 1"+calendarmemo_num);
		ScheduleVO sVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				System.out.println(conn.toString());
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, calendarmemo_num);
				System.out.println(pstmt.toString());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sVo = new ScheduleVO();
					sVo.setCalendarmemo_num(rs.getInt("calendarmemo_num"));
					sVo.setCalendarmemo_year(rs.getInt("calendarmemo_year"));
					sVo.setCalendarmemo_month(rs.getInt("calendarmemo_month"));
					sVo.setCalendarmemo_day(rs.getInt("calendarmemo_day"));
					sVo.setCalendarmemo_contents(rs.getString("calendarmemo_contents"));
					/*sVo.setCalendarmemo_id(rs.getString("calendarmemo_id"));
					sVo.setCalendarmemo_passwd(rs.getString("calendarmemo_passwd"));*/
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sVo.toString());
		return sVo;
	}


	//�씪�젙 �닔�젙
	
	public void updateSchedule(ScheduleVO sVo){
		String sql="update calendarmemo set  calendarmemo_year=?, calendarmemo_month=?, calendarmemo_day=?, calendarmemo_contents=? where calendarmemo_num=? ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
	
			pstmt.setInt(1, sVo.getCalendarmemo_year());
			pstmt.setInt(2, sVo.getCalendarmemo_month());
			pstmt.setInt(3, sVo.getCalendarmemo_day());
			pstmt.setString(4, sVo.getCalendarmemo_contents());
			pstmt.setInt(5, sVo.getCalendarmemo_num());
			/*pstmt.setString(5, sVo.getCalendarmemo_id());
			pstmt.setString(6, sVo.getCalendarmemo_passwd());*/
			pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBManager.close(conn, pstmt);
	}
	}
	
	

	public void deleteSchedule(String calendarmemo_num) {
		String sql = "delete calendarmemo where calendarmemo_num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, calendarmemo_num);
			pstmt.executeUpdate();// 荑쇰━臾� �떎�뻾
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
