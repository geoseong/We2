package com.we2.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.we2.notice.NoticeDto;
import com.we2.pjtMake.PjtMakeVO;
import com.we2.scheduler.SchedulerBean;
import com.we2.willwork.WillWorkVO;

public class ExcelDAO{

	private static JdbcTemplate jdbcTemplate;
	
	public ExcelDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	/** 프로젝트 overview */
	public List<PjtMakeVO> getPjtMake(int pjtCode){
		List<PjtMakeVO> results = 
			jdbcTemplate.query(	"select * from pjtMake where pjtCode=?"
			,
			new RowMapper<PjtMakeVO>(){
				@Override
				public PjtMakeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					PjtMakeVO pjtvo = new PjtMakeVO(
							rs.getInt("pjtCode"),
							rs.getString("pjtName"),
							rs.getString("pjtClassify"),
							rs.getString("startDate"),
							rs.getString("endDate"));
					return pjtvo;
				}
			}, pjtCode);
		return results.isEmpty()? null : results;
	}
	
	/** 할 일*/
	public List<WillWorkVO> getWillWork(int pjtCode){
		List<WillWorkVO> results = 
				jdbcTemplate.query(	"select * from willwork where pjtCode=?"
				,
				new RowMapper<WillWorkVO>(){
					@Override
					public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						WillWorkVO willwork = new WillWorkVO(
								rs.getString("userId"), 
								rs.getInt("pjtCode"), 
								rs.getString("doWork"), 
								rs.getString("doneWork"), 
								rs.getString("stateWork"), 
								rs.getString("name"));
						return willwork;
					}
				}, pjtCode);
			return results.isEmpty()? null : results;
	}
	
	/** 공지사항 */
	public List<NoticeDto> getNotice(int pjtCode){
		List<NoticeDto> results = 
				jdbcTemplate.query(	"select * from notice where pjtCode=? order by num asc"
				,
				new RowMapper<NoticeDto>(){
					@Override
					public NoticeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						NoticeDto notice = new NoticeDto(
								rs.getInt("num"), 
								rs.getString("title"), 
								rs.getString("writer"), 
								rs.getString("content"), 
								rs.getString("writedate"), 
								rs.getInt("pjtCode")
								);
						return notice;
					}
				}, pjtCode);
			return results.isEmpty()? null : results;
	}
	
	/** 스케쥴러 */
	public List<SchedulerBean> getSchedule(int pjtCode){
		List<SchedulerBean> results = 
				jdbcTemplate.query(	"select * from scheduler where pjtCode=? order by calendarmemo_year, calendarmemo_month, calendarmemo_day"
				,
				new RowMapper<SchedulerBean>(){
					@Override
					public SchedulerBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						SchedulerBean scheduler = new SchedulerBean(
								rs.getInt("calendarmemo_num"), 
								rs.getInt("pjtcode"), 
								rs.getInt("calendarmemo_year"), 
								rs.getInt("calendarmemo_month"), 
								rs.getInt("calendarmemo_day"), 
								rs.getString("calendarmemo_contents"));
						return scheduler;
					}
				}, pjtCode);
			return results.isEmpty()? null : results;
	}
}//제발좀 되렴!!
