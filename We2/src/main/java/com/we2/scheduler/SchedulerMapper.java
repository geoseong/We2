package com.we2.scheduler;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Repository;


@Repository
public interface SchedulerMapper {
	
	// 페이징 select문.
	final String select = 
			"select * from  limit #{row_start}, #{row_end}";
	
	final String select_by_calendarmemo_num=
			"select * from scheduler where calendarmemo_num=${calendarmemo_num}";
	
	final String select_all = "select count(1) from scheduler";
	
	final String count_plus=
			"update set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	final String select_by_pjtcode ="select * from scheduler where pjtcode=${pjtcode} order by calendarmemo_num asc";
	
	final String insertScheduler = "insert into scheduler(calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents, pjtcode)"
			+ " values(#{calendarmemo_year}, #{calendarmemo_month}, #{calendarmemo_day}, #{calendarmemo_contents}, ${pjtcode})";
	
	
	final String deleteScheduler = "delete from scheduler where calendarmemo_num = #{calendarmemo_num}";
	
	final String updateScheduler = "update scheduler set calendarmemo_year = #{calendarmemo_year}, calendarmemo_month = #{calendarmemo_month}, calendarmemo_day = #{calendarmemo_day}, calendarmemo_contents = #{calendarmemo_contents}, pjtcode=${pjtcode} where calendarmemo_num = ${calendarmemo_num}";
			
	/*final String select_cnt_by_subject = "select * from (select id, subject, name, created_date, mail, memo, hits, ceil (rownum / #{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
		
		final String select_rows_by_subject = "select * from (select id, subject, name, ceil(rownum/#{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
		
		final String select_cnt_all = "select count(1) from spring_board";		
		
		final String update_by_id = "update spring_board set subject = #{subject}, mail = #{mail}, memo = #{memo} where id = #{id}";
		
		final String delete_by_id = "delete from spring_board where id = #{id}";*/
	/*calendarmemo_num ,calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents
	*/
		@Select(select_by_pjtcode)				
		@Results(value = {   
				@Result(property="calendarmemo_num", column="calendarmemo_num"),
				@Result(property="pjtcode", column="pjtcode"),
				@Result(property="calendarmemo_year", column="calendarmemo_year"),
				@Result(property="calendarmemo_month", column="calendarmemo_month"),
				@Result(property="calendarmemo_day", column="calendarmemo_day"),
				@Result(property="calendarmemo_contents", column="calendarmemo_contents")
			
		})
		ArrayList<SchedulerBean> getList(@Param("pjtcode")int pjtcode);
		
		@Select(select_by_calendarmemo_num)				
		@Results(value = {   
				@Result(property="calendarmemo_num", column="calendarmemo_num"),
				@Result(property="pjtcode", column="pjtcode"),
				@Result(property="calendarmemo_year", column="calendarmemo_year"),
				@Result(property="calendarmemo_month", column="calendarmemo_month"),
				@Result(property="calendarmemo_day", column="calendarmemo_day"),
				@Result(property="calendarmemo_contents", column="calendarmemo_contents")
		})
		SchedulerBean getSearchbycalendarmemo_num(@Param("calendarmemo_num") int calendarmemo_num);
	
		
		@Insert(insertScheduler)  		
		//@Options(useGeneratedKeys = true, keyProperty = "id")
		void insertScheduler(
				@Param("calendarmemo_year") int calendarmemo_year, 
				@Param("calendarmemo_month") int calendarmemo_month, 
				@Param("calendarmemo_day") int calendarmemo_day, 
				@Param("calendarmemo_contents") String calendarmemo_contents,
				@Param("pjtcode") String pjtcode ) ;
		
		@Select(select_all)
		int getTotalCnt();
		
		@Delete(deleteScheduler)  
		void deleteScheduler(@Param("calendarmemo_num") int calendarmemo_num);
	
		@Update(updateScheduler) 
		void updateScheduler(
				@Param("pjtcode") String pjtcode,
				@Param("calendarmemo_num") int calendarmemo_num,
				@Param("calendarmemo_year") int calendarmemo_year, 
				@Param("calendarmemo_month") int calendarmemo_month, 
				@Param("calendarmemo_day") int calendarmemo_day, 
				@Param("calendarmemo_contents") String calendarmemo_contents );
			
}		
