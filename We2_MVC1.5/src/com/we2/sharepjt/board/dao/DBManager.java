package com.we2.sharepjt.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

/* ��� �ȵǴ� ������ �����־���. �̻��Ѱ� import �߾���*/
import javax.sql.DataSource;



public class DBManager {
	public static Connection getConnection() {
		Connection conn=null;
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");			

			// jdbc/myoracle�̶� �̸��� ��ü�� ã�Ƽ� DataSource�� �޴´�.
			DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");			
			
			// ds�� �����Ǿ����Ƿ� Connection�� ���մϴ�.
			conn=ds.getConnection();			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn; 
	} //end getConnection()
	
	// SQL�� SELECT�� ������ �� ���ҽ� ������ ���� �޼ҵ� - Statement
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try{
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} //end close(Connection conn, Statement stmt, ResultSet rs)
	

	
	// SQL�� INSERT, UPDATE, DELETE�۾� ������ �� ���ҽ� ������ ���� �޼ҵ� - Statement
	public static void close(Connection conn, Statement stmt){
		try{
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// SQL�� INSERT, UPDATE, DELETE�۾� ������ �� ���ҽ� ������ ���� �޼ҵ� - PreparedStatement
		public static void close(Connection conn, PreparedStatement pstmt){
			try{
				pstmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
