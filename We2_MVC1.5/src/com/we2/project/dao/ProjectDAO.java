package com.we2.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.we2.project.dto.ProjectVO;

public class ProjectDAO {
	private ProjectDAO(){		
	} //end ProjectDAO
	
	private static ProjectDAO instance = new ProjectDAO();
	
	public static ProjectDAO getInstance() {
		return instance;
	} //end ProjectDAO getInstance()
	
	public Connection getConnection() throws Exception {
		Connection conn=null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds= (DataSource) envContext.lookup("jdbc/myoracle");
		conn=ds.getConnection();
		return conn;
	} //end Connection getConnection
	
	public void insertMember(String filename){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into pjts values(?, ?)";
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			pstmt.setString(2, "admin");
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	} //end insertMember
	
	// c Read u d - CRUD : Create Read Update Delete = SQL
	public List<ProjectVO> selectAllProducts() {
		// 최근 등록한 프로젝트 먼저 출력하기
		String sql="select * from pjts";
		List<ProjectVO> list=new ArrayList<ProjectVO>();		// <-- List는 인터페이스(상위객체), ArrayList는 구현클래스(하위객체)
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ProjectVO pVo = null;
			while(rs.next()){
				pVo = new ProjectVO();
				pVo.setPjtname(rs.getString("pjtname"));
				pVo.setUserid(rs.getString("userid"));					
				list.add(pVo);		// <-- Bean (ProjectVO)에서 List로 들어감.
				System.out.println(rs.getString("pjtname"));
			} // end while
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		} //end try-catch-finally
		return list;
	} //end selectAllProducts()
	
	
	public int checkName(String filename){
		String getres=null;
		int result=0;	//-1 : 실패, 1 : 성공
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select pjtname from pjts where pjtname=?";
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			rs=pstmt.executeQuery();
			
			while(rs.next()){				
				getres=rs.getString("pjtname");
			}			
			
			if(getres==null){
				result=1; 		//성공
				System.out.println("성공");
			}else{
				result=-1;		//실패
				System.out.println("실패");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( rs != null ) rs.close();
				if( pstmt !=null ) pstmt.close();
				if( conn !=null ) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	} //end  checkName(String filename)
	
	
	public void removePjt(String rmv) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from pjts where pjtname=?";
		String commit="commit";
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, rmv);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt=conn.prepareStatement(commit);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( pstmt !=null ) pstmt.close();
				if( conn !=null ) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		} //end try-catch-finally
	} //end removePjt(String rmv)
}
