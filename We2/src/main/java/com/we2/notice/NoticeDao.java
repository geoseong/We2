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
				rs.getTimestamp("writedate")
				);
			return noticedto;
		}
	};
	
	public List<NoticeDto> list(String pjtCode){
		String sql = "select * from notice where pjtCode=? order by num desc"; 
		List<NoticeDto> results = jdbcTemplate.query(sql,memRowMapper, pjtCode);
		
		return results.isEmpty() ? null : results;
	}
	
	public String write(final HttpServletRequest request, String pjtCode) {
		System.out.println(request.getParameter("title")+"/"+request.getParameter("content")+"/"+request.getParameter("writer"));
		String sql = "insert into notice (title, content, writer, writedate, pjtCode) values (?, ?, ?, now(), ?)";
		jdbcTemplate.update(sql, 
				request.getParameter("title"), request.getParameter("content"), request.getParameter("writer"), pjtCode
				);
		return null;
	}
	
	public List<NoticeDto> view(String num, String pjtCode){
		System.out.println("DAO view - num : "+num);
		String sql = "select * from notice where num="+num+" and pjtCode="+pjtCode;
		List<NoticeDto> result = jdbcTemplate.query(sql, memRowMapper);
		
		return result;
	}
	
	public String modify(String num, HttpServletRequest request, String pjtCode) {
		System.out.println("22222222222222");
		System.out.println(request.getParameter("title")+"/"+request.getParameter("content"));
		String sql = "update notice set title=?, content=? where num="+num+" and pjtCode="+pjtCode;
		jdbcTemplate.update(sql, 
				request.getParameter("title"), request.getParameter("content"));
		
		return null;
	}

	public String delete(@RequestParam("num") String num, Model model){
		String sql = "delete from notice where num="+num;
		jdbcTemplate.update(sql);
		return null;
	}
	/*public NoticeDto list(){
		List<NoticeDto> results = jdbcTemplate.query(
				"select num, title, content, writer, writedate from notice order by num desc", 
				new RowMapper<NoticeDto>()
				@Override
				public NoticeDto mapRow(ResultSet rs) throws SQLException{
					NoticeDto dtos = new NoticeDto(),
							rs.getString("title");
							
				});
	}*/
	
	

/*	public ArrayList<NoticeDto> list() {
		
		ArrayList<NoticeDto> dtos = null;
		
		String sql = "select num, title, content, writer, writedate from notice order by num desc";
		dtos = (ArrayList<NoticeDto>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<NoticeDto>(NoticeDto.class));
		
		return dtos;
	}*/
	
	

/*	NoticeDto dto = new NoticeDto();
	DataSource ds;
	
	public NoticeDao(){
		try{
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<NoticeDto> list(){
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = ds.getConnection();
			String sql = "select num, title, content, writer, writedate from notice order by num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Timestamp writedate = rs.getTimestamp("writedate");
				
				NoticeDto dto = new NoticeDto(num, title, writer, content, writedate);
				dtos.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public void write(String title, String content){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	}*/
}
