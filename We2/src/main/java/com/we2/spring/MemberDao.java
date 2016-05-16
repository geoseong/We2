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

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	private RowMapper<Member> memRowMapper = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(rs.getString("NAME"), rs.getString("PWD"), rs.getString("EMAIL"),
					rs.getString("PHONE"), rs.getString("GENDER"), rs.getDate("REGDATE"));

			member.setUserId(rs.getString("USERID"));
			return member;
		}
	};

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByUserid(String userid) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID = ?", memRowMapper, userid);
		System.out.println();
		return results.isEmpty() ? null : results.get(0);
	}

		/*public void insert(final Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into MEMBER values (?, ?, ?, ?, ? ,? , curdate())";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,  member.getUserId());
				pstmt.setString(2,  member.getName());
				pstmt.setString(3,  member.getPwd());
				pstmt.setString(4, 	member.getEmail());
				pstmt.setString(5, 	member.getPhone());
				pstmt.setString(6, 	member.getGender());
				
				return pstmt;
			}
		}
		}*/

	/*
	 * public void update(Member member) { jdbcTemplate.update(
	 * "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
	 * member.getName(), member.getPassword(), member.getEmail()); }
	 */

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER", memRowMapper);
		return results;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}

	public List<Member> selectByRegdate(Date from, Date to) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where REGDATE between ? and ? " + "order by REGDATE desc", memRowMapper, from,
				to);
		return results;
	}

	public Member selectById(Long id) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where ID = ?", memRowMapper, id);

		return results.isEmpty() ? null : results.get(0);
	}

	public static Member selectByEmail(String email) {
		return null;
	}

	public void update(Member member) {

	}

	public int confirmID(String userid) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID=?", memRowMapper, userid);
		return results.isEmpty() ? -1 : 1;
	}
}
