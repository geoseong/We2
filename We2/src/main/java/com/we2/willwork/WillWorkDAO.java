package com.we2.willwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class WillWorkDAO {
  	
	private static WillWorkDAO instance = new WillWorkDAO();
	
	public static WillWorkDAO getInstance(){
		return instance;
	}
	
	public void insertWillWork(WillWorkVO pVo){
		String sql = " insert into willwork values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getDoWork());
			pstmt.executeQuery();//실행
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<WillWorkVO> selectAll(){
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from willwork";
		List<WillWorkVO> list = new ArrayList<WillWorkVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				WillWorkVO pVo = new WillWorkVO();
				pVo.setUserId(rs.getString("userId"));
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setDoWork(rs.getString("doWork"));
				pVo.setDoneWork(rs.getString("doneWork"));
				pVo.setStateWork(rs.getString("stateWork"));
				pVo.setName(rs.getString("name"));
				System.out.println(sql);
				list.add(pVo);
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<WillWorkVO> selectpjtusers(int pjtcode){
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from willwork where pjtcode=?";
		List<WillWorkVO> list = new ArrayList<WillWorkVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pjtcode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				WillWorkVO pVo = new WillWorkVO();
				pVo.setUserId(rs.getString("userId"));
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setDoWork(rs.getString("doWork"));
				pVo.setDoneWork(rs.getString("doneWork"));
				pVo.setStateWork(rs.getString("stateWork"));
				pVo.setName(rs.getString("name"));
				//System.out.println(sql);
				list.add(pVo);
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 사용자 머릿수계산
	public int Pjtcount(int pjtcode){
		String sql="select count(userid) from willwork where pjtcode=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int counts=0;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pjtcode);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				counts=rs.getInt("count(userid)");
			} //end while
			System.out.println("머릿수 : " + counts);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return counts;
	}
			
	// 사용자 리스트를 배열로 받기
	public String[] Pjtlists(int pjtcode){
		String[] users=new String[5];
		String sql="select userid from willwork where pjtcode=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pjtcode);
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()){
				users[i]=rs.getString("userid");
				System.out.println("user"+i+" -- " + users[i]);
				i++;
			} //end while

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return users;
	}
	
	// 해야 할 일 리스트로 뽑기
	public List<WillWorkVO> doworklist(String userid){
		String sql="select dowork, donework, name from willwork where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List<WillWorkVO> list = new ArrayList<WillWorkVO>();
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				WillWorkVO pVo = new WillWorkVO();				
				pVo.setDoWork(rs.getString("doWork"));
				pVo.setDoneWork(rs.getString("doneWork"));
				pVo.setName(rs.getString("name"));
				//System.out.println(sql);
				list.add(pVo);
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//유저네임 리스트로 뽑기
	public String userName(String userid){
		String sql="select name from willwork where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String list = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list=rs.getString("name");
			}// while문 끝
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	public void inputWork(String doWork, String userName){
			
		String sql = "update willwork set dowork = dowork || ', ' || ? where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doWork);
		pstmt.setString(2, userName);
		pstmt.executeUpdate();//실행
		System.out.println(sql);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	
	// 할 일 추가
	public void inputdoWork(String doWork, String name){
		
		String sql = "update willwork set dowork = ? where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doWork);
		pstmt.setString(2, name);
		pstmt.executeUpdate();//실행
		System.out.println(sql);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}		
	}
	
	// 완료한 일 추가
	public void inputdoneWork(String doWork, String name){
		
		String sql = "update willwork set donework = donework ||','|| ? where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doWork);
		pstmt.setString(2, name);
		pstmt.executeUpdate();//실행
		System.out.println(sql);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}		
	}
}
