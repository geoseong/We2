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

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	//제네릭을 통해 Member만을 사용한다고 하고 정의!!
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
	} //MemberDao에 DataSource를 주입함!!
	
	public Member selectByUserid(String userId) {
		System.out.println("MemberDAO userId 인자받은 :::::::::::::::::::::::"+userId);
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID = ?", memRowMapper, userId);
		System.out.println("MemberDAO] results.isempty? - "+results.isEmpty());
		System.out.println("MemberDAO] userid - " + results.get(0).getUserId());
		System.out.println("MemberDAO] pwd - " + results.get(0).getPwd());
		return results.isEmpty() ? null : results.get(0);
	}

	
// 사용자를 mysqlDB에 집어넣는 메소드
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
	
	// 사용자 정보를 수정하는 메소드
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
	// 사용자 ID값을 확인하는 메소드
	public int confirmID(String userId) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID=?", memRowMapper, userId);
		return results.isEmpty() ? -1 : 1;
		}

	public static MemberDao getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	}
