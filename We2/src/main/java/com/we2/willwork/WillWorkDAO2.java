package com.we2.willwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.we2.pjtMake.PjtMakeVO;

public class WillWorkDAO2 {
   
   private static JdbcTemplate jdbcTemplate;
   
   public WillWorkDAO2(DataSource dataSource){
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   public WillWorkDAO2(){
   }
   
   //할 일 부분, 사람 수를 구하는 쿼리문
	public int selectPeople(int pjtCode) {
		String sql = "select count(*) from willwork where pjtcode=?";
		int people = jdbcTemplate.queryForObject(sql, new Object[] {pjtCode}, Integer.class);
		return people;
	}

   public List<WillWorkVO> selectAll(int pjtCode){
      List<WillWorkVO> results = jdbcTemplate.query("select * from willwork where pjtCode=?", 
            new RowMapper<WillWorkVO>(){
            @Override
            public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
                  rs.getInt("pjtCode"),
                  rs.getString("doWork"),
                  rs.getString("doneWork"),
                  rs.getString("stateWork"),
                  rs.getString("name"));
            return willWorkVO; 
            }
         },pjtCode);
      return results;
   }

   public List<WillWorkVO> selectOne(String name, int pjtcode){
      List<WillWorkVO> results = jdbcTemplate.query(
            "select * from willwork where name=? and pjtcode=?"
            , 
            new RowMapper<WillWorkVO>(){ 
            @Override
            public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
                  rs.getInt("pjtCode"),
                  rs.getString("doWork"),
                  rs.getString("doneWork"),
                  rs.getString("stateWork"),
                  rs.getString("name"));
            return willWorkVO; 
            }
         }, name, pjtcode);
      
      return results;
   }
   
   public void insertDoWork(final String name, final String isEmpty, final String doWork, final int pjtcode){
	   String query=null;
	   if(isEmpty.trim().equals("")){	// doWork컬럼이 비어있으면 앞에 ' ,'을 붙이지 않는다.
		   query = "update willwork set dowork = CONCAT(dowork, '', ?) where name=? and pjtcode=?";
	   }else{
		   query = "update willwork set dowork = CONCAT(dowork, ', ', ?) where name=? and pjtcode=?";
	   }
	   final String sql = query;
           jdbcTemplate.update(new PreparedStatementCreator() {
               @Override
               public PreparedStatement createPreparedStatement(Connection con) 
                       throws SQLException {
                   PreparedStatement pstmt = con.prepareStatement(
                		   sql
                      );
                   pstmt.setString(1, doWork);
                   pstmt.setString(2, name);
                   pstmt.setInt(3, pjtcode);
                   return pstmt;
               } //end createPreparedStatement()
           });
   }
   
   public void updateDoneWork(final String name, final String doneWork) throws ParseException{
       // String dowork = dowork + ", " + "doWork" ; 
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) 
                    throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(
                "update willwork set doneWork = CONCAT(donework, ' ', ?) where name=?"
                  );
                pstmt.setString(1, doneWork);
                pstmt.setString(2, name);
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
                PreparedStatement pstmt = con.prepareStatement(
                "update willwork set dowork=? where name=?"
                 );
                pstmt.setString(1, doWork);
                pstmt.setString(2, name);
                return pstmt;
            } //end createPreparedStatement()
        });
   }
   
   public void adduserWillwork(final String userId, final int pjtCode, final String username) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) 
                    throws SQLException {
                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                PreparedStatement pstmt = con.prepareStatement(
                  "insert into willwork values(?, ?, '', '', '', ?)");
                // 인덱스 파라미터 값 설정
                pstmt.setString(1, userId);
                pstmt.setInt(2,  pjtCode);
                pstmt.setString(3, username);
                
                // 생성한 PreparedStatement 객체 리턴
                return pstmt;
            } //end createPreparedStatement()
        });
	}
}