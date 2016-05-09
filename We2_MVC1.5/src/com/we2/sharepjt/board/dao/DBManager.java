package com.we2.sharepjt.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

/* 계속 안되는 이유가 여기있었음. 이상한거 import 했었음*/
import javax.sql.DataSource;



public class DBManager {
	public static Connection getConnection() {
		Connection conn=null;
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");			

			// jdbc/myoracle이란 이름을 객체를 찾아서 DataSource가 받는다.
			DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");			
			
			// ds가 생성되었으므로 Connection을 구합니다.
			conn=ds.getConnection();			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn; 
	} //end getConnection()
	
	// SQL의 SELECT를 수행한 후 리소스 해제를 위한 메소드 - Statement
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try{
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} //end close(Connection conn, Statement stmt, ResultSet rs)
	

	
	// SQL의 INSERT, UPDATE, DELETE작업 수행한 후 리소스 해제를 위한 메소드 - Statement
	public static void close(Connection conn, Statement stmt){
		try{
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// SQL의 INSERT, UPDATE, DELETE작업 수행한 후 리소스 해제를 위한 메소드 - PreparedStatement
		public static void close(Connection conn, PreparedStatement pstmt){
			try{
				pstmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
