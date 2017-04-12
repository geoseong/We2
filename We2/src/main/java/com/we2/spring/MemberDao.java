
package com.we2.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
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
	// 제네릭을 통해 Member만을 사용한다고 하고 정의!!

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} // MemberDao에 DataSource를 주입함!!

	private RowMapper<Member> memRowMapper=new RowMapper<Member>(){@Override public Member mapRow(ResultSet rs,int rowNum)throws SQLException{Member member=new Member(rs.getString("userId"),rs.getString("NAME"),rs.getString("PWD"),rs.getString("pwd_confirm"),rs.getString("EMAIL"),rs.getString("PHONE"),rs.getString("GENDER"),rs.getDate("REGDATE"));member.setUserId(rs.getString("USERID"));return member;}};

	public Member selectByUserid(String userId) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID = ?", memRowMapper, userId);
		
		return results.isEmpty() ? null : results.get(0);
	}

	// 사용자를 mysqlDB에 집어넣는 메소드
	public void insert(final Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

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
	public void update(String name,String userId,String pwd,String pwd_confirm,String phone,String email,String gender,String RegDate) {
		jdbcTemplate.update(
				"UPDATE member SET name=?, pwd=?, pwd_confirm=?, email=?, phone=?, gender=?, regDate = ? WHERE userId=?",
				name, pwd, pwd_confirm,email, phone, gender, RegDate, userId);
	}

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

	public List<Member> selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where email like '%" + email + "%'",
				memRowMapper);

		return results.isEmpty() ? null : results;
	}

	// 사용자 ID값을 확인하는 메소드
	public int confirmID(String userId) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where USERID=?", memRowMapper, userId);
		return results.isEmpty() ? -1 : 1;
	}

	public static MemberDao getInstance() {
		return null;
	}

	public List<PjtJoinVO> selectAll(String userId) {
		// pjtcode | userId | isLeader | pjtCode | pjtName | pjtClassify |
		// startDate | endDate
		List<PjtJoinVO> results = jdbcTemplate.query(
				"select * from pjtmanager mgr, pjtmake make where mgr.pjtcode = make.pjtcode and mgr.userId = ?",
				new RowMapper<PjtJoinVO>() {
					@Override
					public PjtJoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						PjtJoinVO pjtJoinVO = new PjtJoinVO(rs.getString("pjtcode"), rs.getString("userId"),
								rs.getString("isLeader"), rs.getString("pjtCode"), rs.getString("pjtName"),
								rs.getString("pjtClassify"), rs.getString("startDate"), rs.getString("endDate"));
						return pjtJoinVO;
					}
				}, userId);
		return results.isEmpty() ? null : results;
	}

	public int remainDate(int pjtCode) {
		String sql = "select to_days(endDate) - to_days(curDate()) remaindate from pjtmake where pjtcode=?";
		int searchDate = jdbcTemplate.queryForObject(sql, new Object[] { pjtCode }, Integer.class);
		return searchDate;
	}
	
	public int selectDate(int pjtCode) {
		String sql = "select to_days(endDate) - to_days(startDate) from pjtmake where pjtcode=?";
		int searchDate = jdbcTemplate.queryForObject(sql, new Object[] { pjtCode }, Integer.class);
		return searchDate;
	}

	public void delete(AuthInfo authInfo) {
		jdbcTemplate.update("delete from member where userId=?", authInfo.getUserId());
	}

	public String findid(String name, String email){
		
		List<String> results = jdbcTemplate.query("select userId from member where name=? and email=?", 
			new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String userId=rs.getString("userId");
				return userId;
				}
			}
			,
			name 
			,email);
		return results.isEmpty() ? null : results.get(0).toString();
	}
	
	/** 자기가 개설한(방장인) 프로젝트 목록들 보기 */
	public List<PjtMakeVO> selectproject(String userId) {
		List<PjtMakeVO> results = jdbcTemplate.query(
				"select make.pjtcode, make.pjtname, make.pjtclassify, make.startdate, make.enddate"
				+ " from pjtmanager mgr, pjtmake make "
				+ "where mgr.isLeader='Y' and userId = ? and mgr.pjtcode = make.pjtcode",
				new RowMapper<PjtMakeVO>() {
					@Override
					public PjtMakeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						PjtMakeVO pjtVO = new PjtMakeVO(
								rs.getInt("pjtCode"), 
								rs.getString("pjtName"), 
								rs.getString("pjtClassify"), 
								rs.getString("startDate"), 
								rs.getString("endDate"));
						return pjtVO;
					}
				}, userId);
		return results.isEmpty() ? null : results;
	}
	
	/** 자기가 방장인 프로젝트에 속해있는 사람 보기 */
	public List<String> selectmembers_mypjt(int pjtCode) {
		List<String> results = jdbcTemplate.query(
				"select mgr.userid from pjtmanager mgr, pjtmake make where mgr.pjtcode = make.pjtcode and mgr.pjtcode = ?",
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getString("userid");
					}
				}, pjtCode);
		return results.isEmpty() ? null : results;
	}
	
	/** 탈퇴자인 방장이 해당 프로젝트 팀원에게 권한 인계*/
	public void updateownerpjt(int pjtCode, String members, String originalowner){
		jdbcTemplate.update("update pjtManager set isLeader='Y' where pjtCode=? and userId=?", pjtCode, members);
		jdbcTemplate.update("update pjtManager set isLeader='N' where pjtCode=? and userId=?", pjtCode, originalowner);
	}
	
	/** pjtCode제약조건으로 pjtname 출력시키기 */
	public String selectpjtname(int pjtCode) {
		String result = jdbcTemplate.queryForObject(
				"select pjtName from pjtMake where pjtCode=?",
				String.class,
				pjtCode);
		return result.isEmpty() ? null : result;
	}
	
	/** 더이상 탈퇴자가 방장인 프로젝트가 있나 확인 */
	public List<HashMap<String, String>> confirmpjtowner(String originalowner) {
		List<HashMap<String, String>> results = jdbcTemplate.query(
				"select * from pjtManager where userId=? and isLeader='Y'",
				new RowMapper<HashMap<String, String>>() {
					@Override
					public HashMap<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
						HashMap<String, String> columns = new HashMap<String, String>();
						columns.put("pjtCode", rs.getString("pjtCode"));
						columns.put("userId", rs.getString("userId"));
						columns.put("isLeader", rs.getString("isLeader"));
						return columns;
					}
				}, originalowner);
		return results.isEmpty() ? null : results;
	}
}
