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

public class PjtMakeDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
   /* // ��� 1. �����ڸ� ���� DataSource�� > JdbcTemplate�� �����Ͽ� JdbcTemplate ��ü ����.
    public PjtMakeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
    
 // ��� 2. setter�� ���� DataSource�� > JdbcTemplate�� �����Ͽ� JdbcTemplate ��ü ����.
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);    
    }
	
	public void insertPjtMake(final PjtMakeVO pVo) throws ParseException{
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 	
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con) 
	                    throws SQLException {
	                // �Ķ���ͷ� ���޹��� Connection�� �̿��ؼ� PreparedStatement ����
	                PreparedStatement pstmt = con.prepareStatement(
                        "insert into pjtMake(pjtName,pjtClassify,startDate,endDate) "
	                		+"values(?, ?, STR_TO_DATE(?,'%m/%d/%Y'), STR_TO_DATE(?,'%m/%d/%Y'))"
                       , new String[] {"pjtCode"});
	                // �ε��� �Ķ���� �� ����
	                pstmt.setString(1, pVo.getPjtName());
	                pstmt.setString(2,  pVo.getPjtClassify());
	                pstmt.setString(3, pVo.getStartDate());
	                pstmt.setString(4, pVo.getEndDate());
	                
	                // ������ PreparedStatement ��ü ����
	                return pstmt;
	            } //end createPreparedStatement()
	        }, keyHolder);
	        Number keyValue = keyHolder.getKey();
	        pVo.setPjtCode(keyValue.intValue());
	}
	
	//�ֱ� ����� ������Ʈ ���� ����ϱ�
	public List<PjtMakeVO> selectAll(){
		List<PjtMakeVO> results = 
				jdbcTemplate.query("select * from pjtMake",
						new RowMapper<PjtMakeVO>(){
		@Override
		public PjtMakeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PjtMakeVO pjtMakeVO = new PjtMakeVO(
					rs.getString("pjtName"),
					rs.getString("pjtClassify"),
					rs.getString("startDate"),
					rs.getString("pjtClasendDateify"));
			pjtMakeVO.setPjtCode(rs.getInt("pjtCode"));
			return pjtMakeVO;
		}
		});
		return (List<PjtMakeVO>) (results.isEmpty()?null:results);
	}
	
	/*
	// ȸ���� �����ִ� ������Ʈ�̸� �Ѹ���
	public List<PjtMakeVO> selectUserpjts(String userid){
		String sql="select * from pjtmake where userid=?";
		List<PjtMakeVO> list = new ArrayList<PjtMakeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PjtMakeVO pVo = new PjtMakeVO();
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setPjtName(rs.getString("pjtName"));
				pVo.setPjtClassify(rs.getString("pjtClassify"));
				pVo.setEndDate(rs.getString("endDate"));
				pVo.setStartDate(rs.getString("startDate"));
				pVo.setUserId(rs.getString("userId"));
				list.add(pVo);
			}// while�� ��
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public PjtMakeVO selectuserpjt(String pjtcode){
		//�ֱ� ����� ��ǰ ���� ����ϱ�
		String sql = "select * from pjtMake where pjtcode=?";
		PjtMakeVO pVo = new PjtMakeVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pjtcode);
			rs = pstmt.executeQuery();
			while(rs.next()){	
				pVo.setPjtCode(rs.getInt("pjtCode"));
				pVo.setPjtName(rs.getString("pjtName"));
				pVo.setPjtClassify(rs.getString("pjtClassify"));
				pVo.setStartDate(rs.getString("startDate"));
				pVo.setEndDate(rs.getString("endDate"));
				pVo.setUserId(rs.getString("userId"));
			}// while�� ��
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}
	*/
}
