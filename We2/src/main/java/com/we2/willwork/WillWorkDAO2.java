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

   public List<WillWorkVO> selectAll(int pjtCode){
      List<WillWorkVO> results = jdbcTemplate.query("select * from willwork where pjtCode=?", 
            new RowMapper<WillWorkVO>(){ //���� �������� �ڹ� ��ü�� ��ȯ�ϴ� RowMapper �������̽�
            @Override
            public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
                  rs.getInt("pjtCode"),
                  rs.getString("doWork"),
                  rs.getString("doneWork"),
                  rs.getString("stateWork"),
                  rs.getString("name"));
            return willWorkVO; //WillWorkVO�� DB���� ��ȸ�� ������ ����
            }
         },pjtCode);
      //results�� ��ȯ
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
            new RowMapper<WillWorkVO>(){ //���� �������� �ڹ� ��ü�� ��ȯ�ϴ� RowMapper �������̽�
            @Override
            public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
                  rs.getInt("pjtCode"),
                  rs.getString("doWork"),
                  rs.getString("doneWork"),
                  rs.getString("stateWork"),
                  rs.getString("name"));
            return willWorkVO; //WillWorkVO�� DB���� ��ȸ�� ������ ����
            }
         });
      
      //results�� ��ȯ
      return results;
   }*/
   
   public List<WillWorkVO> selectOne(String name, int pjtcode){
      List<WillWorkVO> results = jdbcTemplate.query(
            "select * from willwork where name=? and pjtcode=?"
            , 
            new RowMapper<WillWorkVO>(){ //���� �������� �ڹ� ��ü�� ��ȯ�ϴ� RowMapper �������̽�
            @Override
            public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
                  rs.getInt("pjtCode"),
                  rs.getString("doWork"),
                  rs.getString("doneWork"),
                  rs.getString("stateWork"),
                  rs.getString("name"));
            return willWorkVO; //WillWorkVO�� DB���� ��ȸ�� ������ ����
            }
         }, name, pjtcode);
      
      //results�� ��ȯ
      return results;
   }
   
   public void insertDoWork(final String name, final String doWork, final int pjtcode) throws ParseException{
          // String dowork = dowork + ", " + "doWork" ; 
           jdbcTemplate.update(new PreparedStatementCreator() {
               @Override
               public PreparedStatement createPreparedStatement(Connection con) 
                       throws SQLException {
                   // �Ķ���ͷ� ���޹��� Connection�� �̿��ؼ� PreparedStatement ����
                   PreparedStatement pstmt = con.prepareStatement(
                   "update willwork set dowork = CONCAT(dowork, ', ', ?) where name=? and pjtcode=?"
                      );
                   // �ε��� �Ķ���� �� ����
                   pstmt.setString(1, doWork);
                   pstmt.setString(2, name);
                   pstmt.setInt(3, pjtcode);
                   // ������ PreparedStatement ��ü ����
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
                // �Ķ���ͷ� ���޹��� Connection�� �̿��ؼ� PreparedStatement ����
                PreparedStatement pstmt = con.prepareStatement(
                "update willwork set doneWork = CONCAT(donework, ' ', ?) where name=?"
                  );
                // �ε��� �Ķ���� �� ����
                pstmt.setString(1, doneWork);
                pstmt.setString(2, name);
                // ������ PreparedStatement ��ü ����
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
                // �Ķ���ͷ� ���޹��� Connection�� �̿��ؼ� PreparedStatement ����
                PreparedStatement pstmt = con.prepareStatement(
                "update willwork set dowork=? where name=?"
                 );
                // �ε��� �Ķ���� �� ����
                pstmt.setString(1, doWork);
                pstmt.setString(2, name);
                // ������ PreparedStatement ��ü ����
                return pstmt;
            } //end createPreparedStatement()
        });
}
}