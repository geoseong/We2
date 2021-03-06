package com.we2.studyroom;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;




@Repository
public interface StudyRoomMapper {
	
	final String select_by_rcode=
			"select * from roomshare where rcode=${rcode}";
	
	final String searchstudyroom=
			"select * from roomshare where rlocation=#{rlocation} and rlocationdetail=#{rlocationdetail} order by rcode desc limit #{row_start}, #{rows_per_page}";
	
	final String select_all = "select count(1) from roomshare";
	
	final String select_search_all = "select count(1) from roomshare where rlocation=#{rlocation} and rlocationdetail=#{rlocationdetail}";
	
	final String count_plus=
			"update set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	// 페이징 select문.
	final String select_by_id =
			/*"select rcode, rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl from roomshare order by rcode desc limit #{row_start}, #{row_end}";*/
			"select * from roomshare order by rcode desc limit #{row_start}, #{rows_per_page}";
	
	final String insertStudyRoom = "insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)"
			+ " values("
			+ "#{rname}, "
			+ "#{rlocation}, "
			+ "#{rlocationdetail}, "
			+ "#{rmember},"
			+ "#{rcontent}, "
			+ "#{rpictureurl})";
	
	final String delete_by_rcode = "delete from roomshare where rcode = #{rcode}";
	
	final String update_by_rcode = "update roomshare set rname = #{rname}, rlocation = #{rlocation}, rlocationdetail = #{rlocationdetail}, rmember = #{rmember}, rcontent = #{rcontent}, rpictureurl = #{rpictureurl} where rcode = ${rcode}";
			
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
		ArrayList<StudyRoomBean> getList(@Param("row_start") int row_start, @Param("rows_per_page") int rows_per_page);
		
		@Select(select_by_rcode)				
		@Results(value = {   
				@Result(property="rcode", column="rcode"),
				@Result(property="rname", column="rname"),
				@Result(property="rlocation", column="rlocation"),
				@Result(property="rlocationdetail", column="rlocationdetail"),
				@Result(property="rmemeber", column="rmemeber"),
				@Result(property="rcontent", column="rcontent"),
				@Result(property="rpictureurl", column="rpictureurl")
		})
		StudyRoomBean getSearchbyrcode(@Param("rcode") int rcode);
	
		
		@Select(searchstudyroom)				
		@Results(value = {   
				@Result(property="rcode", column="rcode"),
				@Result(property="rname", column="rname"),
				@Result(property="rlocation", column="rlocation"),
				@Result(property="rlocationdetail", column="rlocationdetail"),
				@Result(property="rmemeber", column="rmemeber"),
				@Result(property="rcontent", column="rcontent"),
				@Result(property="rpictureurl", column="rpictureurl")
		})
		ArrayList<StudyRoomBean> getSearchstudyroom(
				@Param("rlocation") String rlocation,
				@Param("rlocationdetail") String rlocationdetail,
				@Param("row_start") int row_start, @Param("rows_per_page") int rows_per_page);
			
		@Insert(insertStudyRoom)  		
		//@Options(useGeneratedKeys = true, keyProperty = "id")
		void insertStudyRoom(
		@Param("rname") String rname, 
		@Param("rlocation") String rlocation, 
		@Param("rlocationdetail") String rlocationdetail, 
		@Param("rcontent") String rcontent, 
		@Param("rmember") int rmember, 
		@Param("rpictureurl")String rpictureurl) ;
		
		@Select(select_all)
		int getTotalCnt();
		
		@Select(select_search_all)
		int getsearchTotalCnt(
				@Param("rlocation") String rlocation,
				@Param("rlocationdetail") String rlocationdetail);
		
		@Delete(delete_by_rcode)  
		void StudyRoomdelete(@Param("rcode") int rcode);
		
		@Update(update_by_rcode) 
		void StudyRoomupdate(
				@Param("rcode") int rcode,
				@Param("rname") String rname, 
				@Param("rlocation") String rlocation, 
				@Param("rlocationdetail") String rlocationdetail, 
				@Param("rcontent") String rcontent, 
				@Param("rmember") int rmember, 
				@Param("rpictureurl")String rpictureurl);
		
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