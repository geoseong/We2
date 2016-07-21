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

import com.we2.sharepjtboard.PjtBoardBean;




@Repository
public interface FileMapper {
	
	// 페이징 select문.
	final String select = 
			"select fcode, fname, fileurl, pjtCode, date_format(fdate,'%Y-%m-%d') from limit #{row_start}, #{row_end}";
	
	final String select_by_fcode=
			"select * from fileshare where fcode=${fcode} and pjtCode=${pjtCode}";
	
	final String select_all = "select count(1) from fileshare where pjtCode=${pjtCode}";
	
	final String count_plus=
			"update set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	final String select_by_id ="select fcode, fname, fileurl, date_format(fdate,'%Y-%m-%d') fdate from fileshare where pjtcode=${pjtcode} order by fcode desc limit #{row_start}, #{row_end}";
	
	final String insertFile = "insert into fileshare(fname, fileurl, fdate, pjtCode) values (#{fname}, #{fileurl}, date_format(now(),'%Y-%m-%d'), ${pjtCode})";

	
	final String delete_by_fcode = "delete from fileshare where fcode = #{fcode} and pjtCode=${pjtCode}";
	
	final String update_by_fcode = "update fileshare set fname = #{fname}, fileurl = #{fileurl}, fdate=now() where fcode = #{fcode} and pjtCode=${pjtCode}";
			
	final String select_by_num =
			"select * from fileshare where fcode=${fcode} and pjtCode=${pjtCode}";
	
	/*final String select_cnt_by_subject = "select * from (select id, subject, name, created_date, mail, memo, hits, ceil (rownum / #{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
		
		final String select_rows_by_subject = "select * from (select id, subject, name, ceil(rownum/#{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
		
		final String select_cnt_all = "select count(1) from spring_board";		
		
		final String update_by_id = "update spring_board set subject = #{subject}, mail = #{mail}, memo = #{memo} where id = #{id}";
		
		final String delete_by_id = "delete from spring_board where id = #{id}";*/

	
		@Select(select_by_id)				
		@Results(value = {   
				@Result(property="fcode", column="fcode"),
				@Result(property="fname", column="fname"),
				@Result(property="fileurl", column="fileurl"),
				@Result(property="fdate", column="fdate"),
				@Result(property="pjtcode", column="pjtcode"),
				
		})
		ArrayList<FileBean> getList(@Param("row_start") int row_start, @Param("row_end") int row_end, @Param("pjtcode") int pjtcode);
		
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
		FileBean getSearchbyfcode(@Param("fcode") int fcode, @Param("pjtCode") int pjtCode);
	
		
		@Insert(insertFile)  		
		//@Options(useGeneratedKeys = true, keyProperty = "id")
		void insertFile(@Param("fname")String fname, @Param("fileurl")String fileurl, @Param("pjtCode") int pjtCode) ;
		
		@Select(select_all)
		int getTotalCnt(@Param("pjtCode") int pjtCode);
		
		@Delete(delete_by_fcode)  
		void filedelete(@Param("fcode") int fcode, @Param("pjtCode") int pjtCode);
		
		@Update(update_by_fcode) 
		void fileupdate(
				@Param("fcode") int rcode,
				@Param("fname") String fname, 
				@Param("fileurl")String fileurl,
				@Param("pjtCode") int pjtCode);
		
		@Select(select_by_num)
		@Results(value = {
				@Result(property="itemNum", column="itemNum"),
				@Result(property="itemTitle", column="itemTitle"),
				@Result(property="userId", column="userId"),
				@Result(property="itemDate", column="idate"),
				@Result(property="itemClick", column="itemClick"),
				@Result(property="itemPath", column="itemPath"),
				@Result(property="itemContent", column="itemContent"),
				@Result(property="itemDataType", column="itemDataType")
		})
		FileBean select_by_num(@Param("pjtCode")int pjtCode, @Param("fcode")int fcode);

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