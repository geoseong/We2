package com.we2.pjtMake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
	public int searchDate(int pjtCode){
	String sql = 
			"select (endDate - startDate) from pjtmake where pjtcode=?";
	int count = jdbcTemplate.queryForObject(sql, new Object[] {pjtCode}, Integer.class);
	return count;
	}
	
	
	/** 프로젝트 정보 뿌리기위한 DAO*/
	public PjtMakeVO selectAllpjtInfo(int pjtCode){
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
	public List<PjtMemDelVO> selectAllpjtMem(int pjtCode){
		List<PjtMemDelVO> results = jdbcTemplate.query(
				"select mem.name pjtmembers, mgr.* from pjtmanager mgr, member mem where mgr.userId=mem.userId and mgr.pjtcode = ?"
				,
				new RowMapper<PjtMemDelVO>() {
					@Override
					public PjtMemDelVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						PjtMemDelVO pjtmemdelvo = 
								new PjtMemDelVO(
										rs.getString("pjtmembers"),
										rs.getInt("pjtCode"),
										rs.getString("userId"),
										rs.getString("isLeader")
										);
						return pjtmemdelvo;
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
	public void addpjtMember(final int pjtCode, final String userId){
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
		System.out.println("addpjtMember Completed");
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
		System.out.println("insertWillWork Completed");
	}
	
	/** 이미 해당 프로젝트에 가입되어있는 지 확인 */
	public String checkpjtmember(int pjtCode, String userId){
		List<String> results = jdbcTemplate.query(
				"select userId from pjtmanager where pjtcode=? and userid=?"
				,
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						String leaderid=rs.getString("userid");
						return leaderid;
					}
				}
				, pjtCode, userId);
		System.out.println("PjtMakeDAO] results.isempty? - "+results.isEmpty());
		return results.isEmpty() ? null : results.get(0);
	}
	/** 프로젝트 제거전 제거멤버이름 확인*/
	public String checkmembeforedel(int pjtCode, String userId){
		List<String> results = jdbcTemplate.query(
				"select mem.name pjtmembers from pjtmanager mgr, member mem "+
					"where mgr.userId=mem.userId and mgr.pjtcode = ? and mgr.userId=?"
				,
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						String leaderid=rs.getString("pjtmembers");
						return leaderid;
					}
				}
				, pjtCode, userId);
		System.out.println("PjtMakeDAO] results.isempty? - "+results.isEmpty());
		return results.isEmpty() ? null : results.get(0);
	} 
	
	
	/**프로젝트 멤버 삭제하기. - pjtManager 테이블*/
	public void pjtmgrmemDel(final int pjtCode, final String userId){
		System.out.println("pjtmemDel에서 받은 pjtCode : " + pjtCode);
		System.out.println("pjtmemDel에서 받은 userId : " + userId);

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"delete from pjtManager where pjtCode=? and userId=?"
					);
				pstmt.setInt(1, pjtCode);
				pstmt.setString(2, userId);
				return pstmt;
			}
		});
			System.out.println("pjtmemDel pjtManager delete 완료");
	}
	/** 프로젝트 멤버 삭제하기. - WillWork 테이블*/
	public void pjtwillworkmemDel(final int pjtCode, final String userId){
		System.out.println("pjtmemDel에서 받은 pjtCode : " + pjtCode);
		System.out.println("pjtmemDel에서 받은 userId : " + userId);

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"delete from willwork where pjtCode=? and userId=?"
					);
				pstmt.setInt(1, pjtCode);
				pstmt.setString(2, userId);
				return pstmt;
			}
		});
			System.out.println("pjtmemDel willwork delete 완료");
	}
	
	/** 해당 프로젝트 시작&종료기간 수정*/
	public void updatePjtMake(final String startDate, final String endDate, final int pjtCode) throws ParseException{
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con) 
	                    throws SQLException {
	                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
	                PreparedStatement pstmt = con.prepareStatement(
                       "update pjtmake set "
                       + "startDate=STR_TO_DATE(?,'%m/%d/%Y'), "
                       + "endDate=STR_TO_DATE(?,'%m/%d/%Y') "
                       + "where pjtcode=?");
	                // 인덱스 파라미터 값 설정
	                pstmt.setString(1, startDate);
	                pstmt.setString(2, endDate);
	                pstmt.setInt(3, pjtCode);
	                
	                // 생성한 PreparedStatement 객체 리턴
	                return pstmt;
	            } //end createPreparedStatement()
	        });
	}
}
