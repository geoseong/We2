package com.we2.pjtMake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.we2.project.dto.PjtMakeVO;
import com.we2.project.dto.WillWorkVO;

import util.DBManager;

public class PjtMakeDAO {
  
	
	private static PjtMakeDAO instance = new PjtMakeDAO();
	
	public static PjtMakeDAO getInstance(){
		return instance;
	}
	
	public void insertPjtMake(PjtMakeVO pVo){
		String sql = " insert into pjtMake values(pjtMake_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getPjtName());
			pstmt.setString(2, pVo.getPjtClassify());
			pstmt.setString(3, pVo.getStartDate());
			pstmt.setString(4, pVo.getEndDate());
			pstmt.setString(5, pVo.getUserId());
			System.out.println(sql);
			pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<PjtMakeVO> selectAll(){
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from pjtMake";
		List<PjtMakeVO> list = new ArrayList<PjtMakeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PjtMakeVO pVo = new PjtMakeVO();
				
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setPjtName(rs.getString("pjtName"));
				pVo.setPjtClassify(rs.getString("pjtClassify"));
				pVo.setStartDate(rs.getString("startDate"));
				pVo.setEndDate(rs.getString("endDate"));
				pVo.setUserId(rs.getString("userId"));
				list.add(pVo);
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 회원이 속해있는 프로젝트이름 뿌리기
	public List<PjtMakeVO> selectUserpjts(String userid){
		String sql="select * from pjtmake where userid=?";
		List<PjtMakeVO> list = new ArrayList<PjtMakeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PjtMakeVO pVo = new PjtMakeVO();
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setPjtName(rs.getString("pjtName"));
				pVo.setPjtClassify(rs.getString("pjtClassify"));
				pVo.setEndDate(rs.getString("endDate"));
				pVo.setStartDate(rs.getString("startDate"));
				pVo.setUserId(rs.getString("userId"));
				list.add(pVo);
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public PjtMakeVO selectuserpjt(String pjtcode){
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from pjtMake where pjtcode=?";
		PjtMakeVO pVo = new PjtMakeVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pjtcode);
			rs = pstmt.executeQuery();
			while(rs.next()){	
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setPjtName(rs.getString("pjtName"));
				pVo.setPjtClassify(rs.getString("pjtClassify"));
				pVo.setStartDate(rs.getString("startDate"));
				pVo.setEndDate(rs.getString("endDate"));
				pVo.setUserId(rs.getString("userId"));
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}
	
	public void insertWillworkmake(String userid, String name){
		String sql = "insert into willwork values(?, willwork_seq.nextval, null, null,null, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
}
