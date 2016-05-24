package com.we2.pjtMake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.we2.spring.Member;

public class PjtMakeDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
   /* // 방법 1. 생성자를 통한 DataSource를 > JdbcTemplate에 전달하여 JdbcTemplate 객체 생성.
    public PjtMakeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
    
 // 방법 2. setter를 통한 DataSource를 > JdbcTemplate 전달하여 JdbcTemplate 객체 생성.
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);    
    }
    
	public void insertPjtMake(final PjtMakeVO pVo) throws ParseException{
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 	
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con) 
	                    throws SQLException {
	                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
	                PreparedStatement pstmt = con.prepareStatement(
                        "insert into pjtMake(pjtName,pjtClassify,startDate,endDate) "
	                		+"values(?, ?, STR_TO_DATE(?,'%m/%d/%Y'), STR_TO_DATE(?,'%m/%d/%Y'))"
                       , new String[] {"pjtCode"});
	                // 인덱스 파라미터 값 설정
	                pstmt.setString(1, pVo.getPjtName());
	                pstmt.setString(2,  pVo.getPjtClassify());
	                pstmt.setString(3, pVo.getStartDate());
	                pstmt.setString(4, pVo.getEndDate());
	                
	                // 생성한 PreparedStatement 객체 리턴
	                return pstmt;
	            } //end createPreparedStatement()
	        }, keyHolder);
	        Number keyValue = keyHolder.getKey();
	        pVo.setPjtCode(keyValue.intValue());
	}
	
	public void inserPjtManager(final String userId, final int pjtCode) throws ParseException{
			
		jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(
							"insert into pjtManager(pjtCode,userId,isLeader) values(?, ?, 'Y')"
						);
					pstmt.setInt(1, pjtCode);
					pstmt.setString(2, userId);
					return pstmt;
				}
			});
	}
	
	//프로젝트 코드를 구하는 쿼리문
	public int selectCode() {
		String sql = "select pjtCode from pjtmake order by pjtcode desc limit 1";
		int pjtCode = jdbcTemplate.queryForObject(sql, Integer.class);
		return pjtCode;
	}
	
	//최근 등록한 프로젝트 먼저 출력하기
	public List<PjtMakeVO> selectAll(){
		List<PjtMakeVO> results = 
				jdbcTemplate.query("select * from pjtMake"
				,
				new RowMapper<PjtMakeVO>(){
					@Override
					public PjtMakeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						PjtMakeVO pjtMakeVO = new PjtMakeVO(
								rs.getInt("pjtCode"),
								rs.getString("pjtName"),
								rs.getString("pjtClassify"),
								rs.getString("startDate"),
								rs.getString("pjtClasendDateify"));
						return pjtMakeVO;
					}
				}
			);
		return results.isEmpty()?null:results;
	}
	
	//날짜 구하기 
	public int searchDate(){
		int pjtCode=20;
	String sql = 
			"select (endDate - startDate) from pjtmake where pjtcode=?";
	int count = jdbcTemplate.queryForObject(sql, new Object[] {pjtCode}, Integer.class);
	return count;
	}
	
	
	/** 프로젝트 정보 뿌리기위한 DAO*/
	public PjtMakeVO selectAllpjtInfo(int pjtCode){
			System.out.println("PjtMakeDAO ] pjtCode : "+pjtCode);
		List<PjtMakeVO> results = jdbcTemplate.query(
				"select * from pjtMake where pjtCode = ?"
				,
				new RowMapper<PjtMakeVO>() {
					@Override
					public PjtMakeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						PjtMakeVO pjtmake = new PjtMakeVO(
								rs.getInt("pjtCode"),
								rs.getString("pjtName"),
								rs.getString("pjtClassify"),
								rs.getString("startDate"),
								rs.getString("endDate")
						);
						return pjtmake;
					}
				}
				, pjtCode);
		System.out.println("PjtMakeDAO] results.isempty? - "+results.isEmpty());
		return results.isEmpty() ? null : results.get(0);
	}
	
	/** 해당 프로젝트의 조원들 선택하기*/
	public List<String> selectAllpjtMem(int pjtCode){
		System.out.println("PjtMakeDAO ] pjtCode : "+pjtCode);
		List<String> results = jdbcTemplate.query(
				"select mem.name pjtmembers from pjtmanager mgr, member mem where mgr.userId=mem.userId and mgr.pjtcode = ?"
				,
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						String pjtmembers=rs.getString("pjtmembers");
						return pjtmembers;
					}
				}
				, pjtCode);
		System.out.println("PjtMakeDAO] results.isempty? - "+results.isEmpty());
		return results.isEmpty() ? null : results;
	}
	
	/** 방장이 누군지 구하기 */
	public String selectLeader(int pjtCode){
		System.out.println("PjtMakeDAO ] pjtCode : "+pjtCode);
		List<String> results = jdbcTemplate.query(
				"select userid from pjtmanager where pjtcode=? and isleader='y'"
				,
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						String leaderid=rs.getString("userid");
						return leaderid;
					}
				}
				, pjtCode);
		System.out.println("PjtMakeDAO] results.isempty? - "+results.isEmpty());
		return results.isEmpty() ? null : results.get(0);
	}
	
	
	/**회원 초대수락할때 멤버추가하기.*/
	public void addpjtMember(int pjtCode, String userId){
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into pjtManager(pjtCode,userId,isLeader) values(?, ?, 'N')"
					);
				pstmt.setInt(1, pjtCode);
				pstmt.setString(2, userId);
				return pstmt;
			}
		});
	}
	
	
	public void insertWillWork(final String userId, final int pjtCode, final String name) throws ParseException{
		jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(
			"insert into willwork(userId, pjtCode, dowork, donework, statework,name) values(?, ?, '','', 'Y', ?);"
						);
					pstmt.setString(1, userId);
					pstmt.setInt(2, pjtCode);
					pstmt.setString(3, name);
					return pstmt;
				}
			});
	}
}
