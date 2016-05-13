// DAO와 같은 기능을 하는 BoardMapper 파일  

package com.we2.studyroom;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository  // 저장소  -> 이 어노테이션이 적용된 DAO 클래스는 DB 예외 처리를 자동으로 한다. 
// 1) 이 SQL 문을 저장한 다음!
public interface BoardMapper {
	final String select_page="select * from (select id, subject, name, created_date, mail, memo, hits, ceil( rownum / #{rowsPerPage} ) as page from spring_board order by id desc) where page = #{page}";
	
	final String select_by_id = "select id, subject, name, created_date, mail, memo, hits from spring_board where id=#{id}";
	
	final String select_cnt_by_subject = "select * from (select id, subject, name, created_date, mail, memo, hits, ceil (rownum / #{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
	
	final String select_rows_by_subject = "select * from (select id, subject, name, ceil(rownum/#{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
	
	final String select_cnt_all = "select count(1) from spring_board";
	
	final String insert = "insert into spring_board (id, subject, name, created_date, mail, memo) values (seq_id.nextval, #{subject}, #{name}, sysdate, #{mail}, #{memo})";
	
	final String update_by_id = "update spring_board set subject = #{subject}, mail = #{mail}, memo = #{memo} where id = #{id}";
	
	final String delete_by_id = "delete from spring_board where id = #{id}";
	
	// BoarderBean의 속성들과 동일한 이름으로 #{mail} 등을 지정해야 한다.
	@Select(select_page)  // 2) select 를 한 페이지를 
	
	
	@Results(value = {    //3) 결과값을 보여준다
			@Result(property="id", column="id"),
			@Result(property="subject", column="subject"),
			@Result(property="name", column="name"),
			@Result(property="created_date", column="created_date"),
			@Result(property="mail", column="mail"),
			@Result(property="memo", column="memo"),
			@Result(property="hits", column="hits")
	})
	
ArrayList<BoardBean> getList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);  // 전체 리스트 보기
	
	@Select(select_by_id)   // ID로 선택한 글 보기 
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="subject", column="subject"),
			@Result(property="name", column="name"),
			@Result(property="created_date", column="created_date"),
			@Result(property="mail", column="mail"),
			@Result(property="memo", column="memo"),
			@Result(property="hits", column="hits")
	})
	BoardBean getSpecificRow(@Param("id") String id);
	
	   // 전체 글 갯수를 조회
		@Select(select_cnt_all)
		int getTotalCnt();
		
		// 해당 주제의 관련 글 갯수를 조회
		@Select(select_cnt_by_subject)
		int getTotalCntBySubject(@Param("searchThis") String includingThis);
		
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
		
		// 글찾기 부분 
		public ArrayList<BoardBean> getSearchedList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage, @Param("likeThis") String strSearchThis);
		
		@Insert(insert)  // 글 쓰기 
		//@Options(useGeneratedKeys = true, keyProperty = "id")
		void insertBoard(BoardBean boardBean);
		
		@Update(update_by_id)  // 글 수정하기
		void updateBoard(@Param("id") int id, @Param("subject") String subject, @Param("mail") String mail, @Param("memo") String memo);
		
		@Delete(delete_by_id)   // 글 삭제하기 
		void deleteSpecificRow(@Param("id") int id);
	}