package com.we2.notice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public class NoticeDao {

	private static JdbcTemplate jdbcTemplate;
	
	public NoticeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<NoticeDto> memRowMapper = new RowMapper<NoticeDto>() {
		@Override
		public NoticeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			NoticeDto noticedto = new NoticeDto(
				rs.getInt("num"),
				rs.getString("title"),
				rs.getString("writer"),
				rs.getString("content"),
				rs.getTimestamp("writedate"),
				rs.getInt("pjtCode")
				);
			return noticedto;
		}
	};
	
	public List<NoticeDto> list(int pjtCode){
		String sql = "select * from notice where pjtcode=? order by num desc"; 
		List<NoticeDto> results = jdbcTemplate.query(sql,memRowMapper, pjtCode);
		
		return results.isEmpty() ? null : results;
	}
	
	public String write(final HttpServletRequest request, int pjtCode) {
			System.out.println(request.getParameter("title")+" / "+request.getParameter("content")+" / "+request.getParameter("writer"));
		String sql = "insert into notice (title, content, writer, writedate, pjtCode) values (?, ?, ?, now(), ?)";
		jdbcTemplate.update(sql, 
				request.getParameter("title"), request.getParameter("content"), request.getParameter("writer"), 
				pjtCode
				);
		return null;
	}
	
	public List<NoticeDto> view(String num, int pjtCode){
		System.out.println("DAO view - num : "+num);
		String sql = "select * from notice where num="+num+" and pjtCode="+pjtCode;
		List<NoticeDto> result = jdbcTemplate.query(sql, memRowMapper);
		
		return result;
	}
	
	public String modify(String num, HttpServletRequest request, int pjtCode) {
		System.out.println(request.getParameter("title")+" / "+request.getParameter("content"));
		String sql = "update notice set title=?, content=? where num="+num+" and pjtCode="+pjtCode;
		jdbcTemplate.update(sql, 
				request.getParameter("title"), request.getParameter("content"));
		
		return null;
	}

	public String delete(String num){
		String sql = "delete from notice where num="+num;
		jdbcTemplate.update(sql);
		return null;
	}
}
