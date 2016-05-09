package com.we2.community.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.we2.community.board.dto.BoardVO;

public class BoardDAO {
	private BoardDAO(){		
	}
	
	/* �̱��� ���� */
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// c Read u d - CRUD : Create Read Update Delete = SQL
	// �Խ��� ���뺸�� ����
	// ItemNum : �Խù� ��ȣ , add : �������� ���� ��ȸ�� 1�� �߰��ϳ� 0�� �߰��ϳ� �����ϴ� int.
	public BoardVO seeAllItemsforcontent(String BoardDB, int ItemNum) {
		// �ֱ� ����� ��ǰ ���� ����ϱ�
		String sql="select * from "+BoardDB+" where itemNum=?";
		BoardVO pVo = new BoardVO();
			//List<BoardVO> list=new ArrayList<BoardVO>();		// <-- List�� �������̽�(������ü), ArrayList�� ����Ŭ����(������ü)
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ItemNum);
			rs=pstmt.executeQuery();
			while(rs.next()){				
				pVo.setItemNum(rs.getInt("itemNum"));
				pVo.setItemTitle(rs.getString("itemTitle"));
				pVo.setUserId(rs.getString("userId"));
				pVo.setItemDate(rs.getDate("itemDate"));
				pVo.setItemClick(rs.getInt("itemClick"));
				pVo.setItemPath(rs.getString("itemPath"));
				pVo.setItemContent(rs.getString("itemContent"));
				//list.add(pVo);
			} // end while
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		} //end try-catch-finally
		return pVo;
	} //end selectAllProducts()
	
	// c Read u d - CRUD : Create Read Update Delete = SQL 
	// �Խ��� ����Ʈ �Ѹ����.
	public List<BoardVO> seeAllItems(String BoardDB, int startRcdNo, int endpage) {
		// �ֱ� ����� ��ǰ ���� ����ϱ�
		String sql="select rownum, sub3.* from (select rownum as sub2rnum, sub2.* from (select rownum , sub1.* from (select * from "+ BoardDB+" order by ItemNum desc) sub1) sub2) sub3 where sub3.sub2rnum>=? and sub3.sub2rnum<?";
		List<BoardVO> list = new ArrayList<BoardVO>();	// <-- List�� �������̽�(������ü), ArrayList�� ����Ŭ����(������ü)
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRcdNo);
			pstmt.setInt(2, endpage);
			rs=pstmt.executeQuery();
				System.out.println("startRcdNo : "+startRcdNo + " / endpage : "+endpage);
				
			while(rs.next()){
				BoardVO pVo = new BoardVO();
				pVo.setItemNum(rs.getInt("itemNum"));
				pVo.setItemTitle(rs.getString("itemTitle"));
				pVo.setUserId(rs.getString("userId"));
				pVo.setItemDate(rs.getDate("itemDate"));
				pVo.setItemClick(rs.getInt("itemClick"));
				pVo.setItemPath(rs.getString("itemPath"));
				pVo.setItemContent(rs.getString("itemContent"));
				list.add(pVo);		// <-- Bean (ProductVO)���� List�� ��.				
			} // end while
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		} //end try-catch-finally
		return list;
	} //end selectAllProducts()
	
	public int InsertItem(String BoardDB, BoardVO pVo){
		String sql="insert into "+ BoardDB +" values("+BoardDB+"_no.nextval, ?, ?, sysdate, ?, ?, ?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		System.out.println("BoardDB - " + BoardDB);
		System.out.println("insert into "+ BoardDB +" values("+BoardDB+"_no.nextval, ?, ?, sysdate, ?, ?, ?)");
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getItemTitle());
			pstmt.setString(2, pVo.getUserId());
			pstmt.setInt(3, pVo.getItemClick());
			pstmt.setString(4, pVo.getItemPath());
			pstmt.setString(5, pVo.getItemContent());
			
			result=pstmt.executeUpdate();	// INSERT, DELETE, UPDATE�� ����

			conn.commit();	//commit�ؾ� DB������ refresh�� �ȴ�. Eclipse�� ����Ŭ�ܼ� ����(?) ��...
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	} //end insertProduct(ProductVO pVo)
	
	public void updateItem(BoardVO pVo) {
		String sql="update product set ItemNum=?, ItemTitle=?, userId=?, ItemDate=?, ItemClick=?, ItemPath=?, ItemContent=? where ItemNum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pVo.getItemNum());
			pstmt.setString(2, pVo.getItemTitle());
			pstmt.setString(3, pVo.getUserId());
			pstmt.setDate(4, (Date) pVo.getItemDate());
			pstmt.setInt(5, pVo.getItemClick());
			pstmt.setString(6, pVo.getItemPath());
			pstmt.setString(7, pVo.getItemContent());
			pstmt.executeUpdate();	// INSERT, DELETE, UPDATE�� ����
			
			conn.commit();	//commit�ؾ� DB������ refresh�� �ȴ�. Eclipse�� ����Ŭ�ܼ� ����(?) ��...
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	} //end updateProduct(ProductVO pVo)
	
	public int countRecords(String BoardDB){
		String sql="select count(*) from "+BoardDB;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int cntrcd=0;
		
		System.out.println("select count(*) from "+BoardDB);
				
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();	// ������ ����
			
			while(rs.next()){
				cntrcd=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return cntrcd;
	} //end countRecords
	
	public int addcounter(String BoardDB, BoardVO bVo){
		String sql="update "+BoardDB+" set ItemClick=? where ItemNum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int added=0;
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bVo.getItemClick()+1);
			pstmt.setInt(2, bVo.getItemNum());
			added=pstmt.executeUpdate(); // ������ ����

			conn.commit();	//commit�ؾ� DB������ refresh�� �ȴ�. Eclipse�� ����Ŭ�ܼ� ����(?) ��...
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return added;
	}
	
	public int updateItem(String BoardDB, int ItemNum, String ItemTitle, String ItemPath, String ItemContent){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update "+BoardDB+" set ItemTitle=?, ItemPath=?, ItemContent=? where ItemNum=?";
		int result=0;
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ItemTitle);
			pstmt.setString(2, ItemPath);
			pstmt.setString(3, ItemContent);
			pstmt.setInt(4, ItemNum);
			result=pstmt.executeUpdate();
			
			conn.commit();	//commit�ؾ� DB������ refresh�� �ȴ�. Eclipse�� ����Ŭ�ܼ� ����(?) ��...
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int deleteItem(String BoardDB, int ItemNum){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from "+BoardDB+" where ItemNum=?";
		int result=0;
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ItemNum);
			result=pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	// SearchServlet���� �� ���ڵ� ������ ����
	public int countsearchedRecords(String BoardDB, String find, String findword){
		String sql="select count(*) from "+BoardDB + " where "+find+"=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int cntrcd=0;
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			//pstmt.setString(1, find);
			pstmt.setString(1, findword);
			rs=pstmt.executeQuery();	// ������ ����
			
			while(rs.next()){
				cntrcd=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return cntrcd;
	}
	
	// SearchServlet���� ����¡��� ������ select ����
	public List<BoardVO> searchItem(String BoardDB, String find, String findword, int startRcdNo, int endpage){
		// �ֱ� ����� ��ǰ ���� ����ϱ�
			String sql="select rownum, sub3.* from (select rownum as sub2rnum, sub2.* from (select rownum , sub1.* from (select rownum as arnum, a.* from "+BoardDB+" a where "+find+" like '%"+findword+"%' order by ItemNum desc) sub1) sub2) sub3 where sub3.sub2rnum>=? and sub3.sub2rnum<?";
			List<BoardVO> list = new ArrayList<BoardVO>();	// <-- List�� �������̽�(������ü), ArrayList�� ����Ŭ����(������ü)
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			
			try{
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, startRcdNo);
				pstmt.setInt(2, endpage);
				rs=pstmt.executeQuery();
					System.out.println("startRcdNo : "+startRcdNo + " / endpage : "+endpage);
					
				while(rs.next()){
					BoardVO pVo = new BoardVO();
					pVo.setItemNum(rs.getInt("itemNum"));
					pVo.setItemTitle(rs.getString("itemTitle"));
					pVo.setUserId(rs.getString("userId"));
					pVo.setItemDate(rs.getDate("itemDate"));
					pVo.setItemClick(rs.getInt("itemClick"));
					pVo.setItemPath(rs.getString("itemPath"));
					pVo.setItemContent(rs.getString("itemContent"));
					list.add(pVo);		// <-- Bean (ProductVO)���� List�� ��.				
				} // end while
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt, rs);
			} //end try-catch-finally
			return list;
	}
}