package com.we2.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.we2.pjtMake.PjtMakeVO;

public class ExcelDAO{

	private JdbcTemplate jdbcTemplate;
	public ExcelDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} //MemberDao에 DataSource를 주입함!!
	
	public List<PjtMakeVO> getPjtMake(){
		List<PjtMakeVO> results = 
			jdbcTemplate.query(
					"select pjtname, pjtclassify, startdate, enddate from pjtMake"
					,
					new RowMapper<PjtMakeVO>(){
						@Override
						public PjtMakeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
							PjtMakeVO pjtMakeVO = new PjtMakeVO(
									rs.getInt("pjtCode"),
									rs.getString("pjtName"),
									rs.getString("pjtClassify"),
									rs.getString("startDate"),
									rs.getString("endDate"));
							System.out.println("rs.getString(pjtName) : "+rs.getString("pjtName"));
							return pjtMakeVO;
						}
					}
				);
			System.out.println("List<pjtmakevo> : "+ results.get(0).getPjtName());
			System.out.println("isempty? "+results.isEmpty());
		return results.isEmpty()?null:results;
	}
	public List<Object> getPjtManager(){
		return null;
	}
	public List<Object> getWillWork(){
		return null;
	}
	public List<Object> getNotify(){
		return null;
	}
	public List<Object> getSchedule(){
		return null;
	}
	public List<Object> getFileShare(){
		return null;
	}
}//제발좀 되렴!!
