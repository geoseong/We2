package com.we2.file;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;




@Repository
public interface FileMapper {
	
	// 페이징 select문.
	final String select = 
			 
			"select * from  limit #{row_start}, #{row_end}";
	
	final String select_by_fcode=
			"select fcode, fname, fileurl, fdate from fileshare where fcode=${fcode}";
	
	final String select_all = "select count(1) from fileshare";
	
	final String count_plus=
			"update set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	final String select_by_id ="select fcode, fname, fileurl, fdate from fileshare order by fcode desc limit #{row_start}, #{row_end}";
	
	final String insertFile = "insert into fileshare(fname, fileurl, fdate) values (#{fname}, #{fileurl}, date_format(now(),'%y-%m-%d'))";

	
	final String delete_by_fcode = "delete from fileshare where fcode = #{fcode}";
	
	final String update_by_fcode = "update fileshare set fname = #{fname}, fileurl = #{fileurl}, fdate=now() where fcode = #{fcode}";
			
	/*final String select_cnt_by_subject = "select * from (select id, subject, name, created_date, mail, memo, hits, ceil (rownum / #{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
		
		final String select_rows_by_subject = "select * from (select id, subject, name, ceil(rownum/#{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
		
		final String select_cnt_all = "select count(1) from spring_board";		
		
		final String update_by_id = "update spring_board set subject = #{subject}, mail = #{mail}, memo = #{memo} where id = #{id}";
		
		final String delete_by_id = "delete from spring_board where id = #{id}";*/

	
		@Select(select_by_id)				
		@Results(value = {   
				@Result(property="rcode", column="rcode"),
				@Result(property="rname", column="rname"),
				@Result(property="rlocation", column="rlocation"),
				@Result(property="rlocationdetail", column="rlocationdetail"),
				@Result(property="rmemeber", column="rmemeber"),
				@Result(property="rcontent", column="rcontent"),
				@Result(property="rpictureurl", column="rpictureurl")
		})
		ArrayList<FileBean> getList(@Param("row_start") int row_start, @Param("row_end") int row_end);
		
		@Select(select_by_fcode)				
		@Results(value = {   
				@Result(property="rcode", column="rcode"),
				@Result(property="rname", column="rname"),
				@Result(property="rlocation", column="rlocation"),
				@Result(property="rlocationdetail", column="rlocationdetail"),
				@Result(property="rmemeber", column="rmemeber"),
				@Result(property="rcontent", column="rcontent"),
				@Result(property="rpictureurl", column="rpictureurl")
		})
		FileBean getSearchbyfcode(@Param("fcode") int fcode);
	
		
		@Insert(insertFile)  		
		//@Options(useGeneratedKeys = true, keyProperty = "id")
		void insertFile(@Param("fname")String fname, @Param("fileurl")String fileurl) ;
		
		@Select(select_all)
		int getTotalCnt();
		
		@Delete(delete_by_fcode)  
		void filedelete(@Param("fcode") int fcode);
		
		@Update(update_by_fcode) 
		void fileupdate(
				@Param("fcode") int rcode,
				@Param("fname") String fname, 
				@Param("fileurl")String fileurl);
		
}
		
/*	
		StudyRoomBean getSpecificRow(@Param("id") String id);
		
		   // 전체 글 갯수를 조회
			@Select(select_cnt_all)
			int getTotalCnt();
			
			// 해당 주제의 관련글 갯수를 조회
			@Select(select_cnt_by_subject)
			int getTotalCntBySubject(@Param("searchThis") String includingThis);
			
			//해당 주제의 관련글 조회
			@Select(select_rows_by_subject)
			@Results(value = {
					@Result(property="id", column="id"),
					@Result(property="subject", column="subject"),
					@Result(property="name", column="name"),
					@Result(property="created_date", column="created_date"),
					@Result(property="mail", column="mail"),
					@Result(property="memo", column="memo"),
					@Result(property="hits", column="hits")
			})
			
	
			public ArrayList<StudyRoomBean> getSearchedList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage, @Param("likeThis") String strSearchThis);
			
	
			
			
		
		}*/