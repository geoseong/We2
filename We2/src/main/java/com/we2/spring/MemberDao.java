
package com.we2.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.RequestParam;

//import com.sun.jmx.snmp.Timestamp;
import com.we2.pjtMake.PjtMakeVO;
import com.we2.spring.Member;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	//�젣�꽕由��쓣 �넻�빐 Member留뚯쓣 �궗�슜�븳�떎怨� �븯怨� �젙�쓽!!
	private RowMapper<Member> memRowMapper = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(rs.getString("userId"), rs.getString("NAME"), 
					rs.getString("PWD"), rs.getString("pwd_confirm"), rs.getString("EMAIL"),
					rs.getString("PHONE"), rs.getString("GENDER"), rs.getDate("REGDATE"));
			member.setUserId(rs.getString("USERID"));
			return member;
		}
	};
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} //MemberDao�뿉 DataSource瑜� 二쇱엯�븿!!
	
	public Member selectByUserid(String userId) {
		System.out.println("MemberDAO userId �씤�옄諛쏆� :::::::::::::::::::::::"+userId);
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID = ?", memRowMapper, userId);
		System.out.println("MemberDAO] results.isempty? - "+results.isEmpty());
		System.out.println("MemberDAO] userid - " + results.get(0).getUserId());
		System.out.println("MemberDAO] pwd - " + results.get(0).getPwd());
		return results.isEmpty() ? null : results.get(0);
	}

	
// �궗�슜�옄瑜� mysqlDB�뿉 吏묒뼱�꽔�뒗 硫붿냼�뱶
	public void insert(final Member member){
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
				
				PreparedStatement pstmt = con.prepareStatement
				
				("insert into MEMBER(NAME ,USERID, PWD, PWD_confirm, PHONE, EMAIL, GENDER, REGDATE) values (?,?,?,?,?,?,?,curdate())");
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getUserId());
				pstmt.setString(3, member.getPwd());
				pstmt.setString(4, member.getPwd_confirm());
				pstmt.setString(5, member.getPhone());
				pstmt.setString(6, member.getEmail());
				pstmt.setString(7, member.getGender());
			return pstmt;
			}

		});
	}
	
	// �궗�슜�옄 �젙蹂대�� �닔�젙�븯�뒗 硫붿냼�뱶
	public void update(Member member) { 
		  jdbcTemplate.update(
				  "UPDATE member SET name='?',pwd='?',pwd_confirm='?', email='?' ,phone='?', gender='?', regDate='?' WHERE userId='?';"
				  ,
		member.getName(),		  
		member.getPwd(), 
		member.getPwd_confirm(), 
		member.getEmail(), 
		member.getPhone(), 
		member.getGender(),
		member.getRegDate(),
		member.getUserId()
		);
	}  
	  		  
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER",
				memRowMapper);
		return results;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}

	public List<Member> selectByRegdate(Date from, Date to) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where REGDATE between ? and ? "+
				"order by REGDATE desc",
				memRowMapper,
				from, to);
		return results;
	}
	
	public Member selectById(Long id) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where ID = ?",
				memRowMapper,
				id);

		return results.isEmpty() ? null : results.get(0);
	}
	
	// email濡� �쉶�썝議고쉶
	public List<Member> selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where email like '%"+email+"%'",
				memRowMapper);

		return results.isEmpty() ? null : results;
	}
	
	// �궗�슜�옄 ID媛믪쓣 �솗�씤�븯�뒗 硫붿냼�뱶
	public int confirmID(String userId) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID=?", memRowMapper, userId);
		return results.isEmpty() ? -1 : 1;
		}

	public static MemberDao getInstance() {
		return null;
	}
	
	public List<PjtJoinVO> selectAll(String userId){
		// pjtcode | userId | isLeader | pjtCode | pjtName     | pjtClassify | startDate  | endDate
	      List<PjtJoinVO> results = 
            jdbcTemplate.query( //mysql DB�뿰�룞�쓣 �쐞�빐 �옉�꽦
        		"select * from pjtmanager mgr, pjtmake make where mgr.pjtcode = make.pjtcode and mgr.userId = ?"
        		, //�봽濡쒖젥�듃 �뀒�씠釉붿뿉�꽌  pjtmanager mgr, pjtmake make瑜� �꽑�깮�븯怨� 議곌굔臾몄쑝濡� mgr.pjtcode = make.pjtcode mgr.userId�씤寃껊쭔�쓣 異쒕젰�븿!! 
        		new RowMapper<PjtJoinVO>(){
			      @Override
			      public PjtJoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			    	  PjtJoinVO pjtJoinVO = new PjtJoinVO(
			        		 rs.getString("pjtcode"),
			        		 rs.getString("userId"),
			        		 rs.getString("isLeader"),
			        		 rs.getString("pjtCode"),
			        		 rs.getString("pjtName"),
			               rs.getString("pjtClassify"),
			               rs.getString("startDate"),
			               rs.getString("endDate"));
			         return pjtJoinVO;
			      }
        		}
	           , userId);
	      System.out.println("selectAll()::results.isEmpty()::::::"+results.isEmpty());
	      return results.isEmpty()?null:results;
	   }
	
	
	public int selectDate(int pjtCode){
	      String sql = 
	      "select (endDate-startDate) from pjtMake where pjtCode=?";
	      int searchDate = jdbcTemplate.queryForObject(sql, new Object[] {pjtCode}, Integer.class);
	      return searchDate;
	      }
	
	public void delete(Member member) { 
		  System.out.println(jdbcTemplate.update("delete from member where userId=?;",member.getUserId()));;
		  
	}
}
