package com.we2.willwork;

import java.sql.*;
import java.text.ParseException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.we2.pjtMake.PjtMakeVO;

public class WillWorkDAO2 {
	
	private static JdbcTemplate jdbcTemplate;
	
	public WillWorkDAO2(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public WillWorkDAO2(){
	}

	public List<WillWorkVO> selectAll(){
		List<WillWorkVO> results = jdbcTemplate.query("select * from willwork", 
				new RowMapper<WillWorkVO>(){ //쿼리 실행결과를 자바 객체로 변환하는 RowMapper 인터페이스
				@Override
				public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
						rs.getInt("pjtCode"),
						rs.getString("doWork"),
						rs.getString("doneWork"),
						rs.getString("stateWork"),
						rs.getString("name"));
				return willWorkVO; //WillWorkVO에 DB에서 조회한 내용을 저장
				}
			});
		//results를 반환
		return results;
	}
	
	/*public void deleteFromHostContacts(int hostId)
	{
	    String DELETE = " DELETE FROM host_contacts WHERE host_id=?";
	    getSimpleJdbcTemplate().update(DELETE, hostId);
	}*/
	
	/*public void Delete(String complete){
		String delete = "delete from willwork where doWork=?"; 
		jdbcTemplate.update(delete, complete);
	}*/
	
	/*public int Pjtcount(int pjtCode){
		List<WillWorkVO> results = jdbcTemplate.query("select count(userid) from willwork where pjtcode='"+pjtCode+"'", 
				new RowMapper<WillWorkVO>(){ //쿼리 실행결과를 자바 객체로 변환하는 RowMapper 인터페이스
				@Override
				public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
						rs.getInt("pjtCode"),
						rs.getString("doWork"),
						rs.getString("doneWork"),
						rs.getString("stateWork"),
						rs.getString("name"));
				return willWorkVO; //WillWorkVO에 DB에서 조회한 내용을 저장
				}
			});
		
		//results를 반환
		return results;
	}*/
	
	public List<WillWorkVO> selectOne(String name){
		List<WillWorkVO> results = jdbcTemplate.query("select * from willwork where name='"+ name +"'", 
				new RowMapper<WillWorkVO>(){ //쿼리 실행결과를 자바 객체로 변환하는 RowMapper 인터페이스
				@Override
				public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
						rs.getInt("pjtCode"),
						rs.getString("doWork"),
						rs.getString("doneWork"),
						rs.getString("stateWork"),
						rs.getString("name"));
				return willWorkVO; //WillWorkVO에 DB에서 조회한 내용을 저장
				}
			});
		
		//results를 반환
		return results;
	}
	
	public void insertDoWork(final String name, final String doWork) throws ParseException{
		 	// String dowork = dowork + ", " + "doWork" ; 
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con) 
	                    throws SQLException {
	                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
	                PreparedStatement pstmt = con.prepareStatement(
	                "update willwork set dowork = CONCAT(dowork, ', ', ?) where name=?"
                      );
	                // 인덱스 파라미터 값 설정
	                pstmt.setString(1, doWork);
	                pstmt.setString(2, name);
	                // 생성한 PreparedStatement 객체 리턴
	                return pstmt;
	            } //end createPreparedStatement()
	        });
	}
	
	public void insertDoneWork(final String name, final String doneWork) throws ParseException{
	 	// String dowork = dowork + ", " + "doWork" ; 
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) 
                    throws SQLException {
                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                PreparedStatement pstmt = con.prepareStatement(
                "update willwork set doneWork = CONCAT(donework, ' ', ?) where name=?"
                  );
                // 인덱스 파라미터 값 설정
                pstmt.setString(1, doneWork);
                pstmt.setString(2, name);
                // 생성한 PreparedStatement 객체 리턴
                return pstmt;
            } //end createPreparedStatement()
        });
}
	
	public void updateWillWork(final String name, final String doWork) throws ParseException{
	 	// String dowork = dowork + ", " + "doWork" ; 
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) 
                    throws SQLException {
                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                PreparedStatement pstmt = con.prepareStatement(
                "update willwork set dowork=? where name=?"
                 );
                // 인덱스 파라미터 값 설정
                pstmt.setString(1, doWork);
                pstmt.setString(2, name);
                // 생성한 PreparedStatement 객체 리턴
                return pstmt;
            } //end createPreparedStatement()
        });
}
}
