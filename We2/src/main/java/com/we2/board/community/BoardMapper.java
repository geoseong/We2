package com.we2.board.community;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.we2.board.community.BoardBean;


@Repository  // 저장소  -> 이 어노테이션이 적용된 DAO 클래스는 DB 예외 처리를 자동으로 한다. 
//1) 이 SQL 문을 저장한 다음!
public interface BoardMapper {
    final String select_page="select * from (select cFindNum, cFindTitle, UserId, cFindDate, cFindContent, cFindClick, ceil( rownum / #{rowsPerPage} ) as page from spring_board order by cFindNum desc) where page = #{page}";
	
	final String select_by_cFindNum = "select cFindNum, cFindTitle, UserId, cFindDate, cFindContent, cFindClick from cFindWork where cFindNum=#{cFindNum}";
	
	final String select_cnt_by_cFindTitle = "select * from (select cFindNum, cFindTitle, UserId, cFindDate, cFindContent, cFindClick, ceil (rownum / #{rowsPerPage}) as page from cFindWork where cFindTitle like '%' || '${likeThis}' || '%' order by cFindNum desc) where page = #{page}";
	
	final String select_rows_by_cFindTitle = "select * from (select cFindNum, cFindTitle, UserId, ceil(rownum/#{rowsPerPage}) as page from cFindWork where cFindNum like '%' || '${likeThis}' || '%' order by cFindNum desc) where page = #{page}";
	
	final String select_cnt_all = "select count(1) from cFindWork";
	
	final String insert = "insert into cFindWork (cFindNum, cFindTitle, UserId, cFindDate, cFindContent) values (seq_cFindNum.nextval, #{cFindTitle}, #{UserId}, sysdate, #{cFindContent})";
	
	final String update_by_cFindNum = "update cFindWork set cFindTitle = #{cFindTitle}, cFindContent = #{cFindContent} where cFindNum = #{cFindNum}";
	
	final String delete_by_cFindNum = "delete from cFindWork where cFindNum = #{cFindNum}";
	
	// BoarderBean의 속성들과 동일한 이름으로 #{mail} 등을 지정해야 한다.
		@Select(select_page)  // 2) select 를 한 페이지를 
		
		
		@Results(value = {    //3) 결과값을 보여준다
				@Result(property="cFindNum", column="cFindNum"),
				@Result(property="cFindTitle", column="cFindTitle"),
				@Result(property="UserId", column="UserId"),
				@Result(property="cFindDate", column="cFindDate"),
				@Result(property="cFindContent", column="cFindContent"),
				@Result(property="cFindClick", column="cFindClick")
		})
		
	ArrayList<BoardBean> getList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);  // 전체 리스트 보기
		
		@Select(select_by_cFindNum)   // ID로 선택한 글 보기 
		@Results(value = {
				@Result(property="cFindNum", column="cFindNum"),
				@Result(property="cFindTitle", column="cFindTitle"),
				@Result(property="UserId", column="UserId"),
				@Result(property="cFindDate", column="cFindDate"),
				@Result(property="cFindContent", column="cFindContent"),
				@Result(property="cFindClick", column="cFindClick")
		})
		BoardBean getSpecificRow(@Param("id") String id);
		
		   // 전체 글 갯수를 조회
			@Select(select_cnt_all)
			int getTotalCnt();
			
			// 해당 주제의 관련 글 갯수를 조회
			@Select(select_cnt_by_cFindTitle)
			int getTotalCntBycFindTitle(@Param("searchThis") String includingThis);
			
			@Select(select_rows_by_cFindTitle)
			@Results(value = {
					@Result(property="cFindNum", column="cFindNum"),
					@Result(property="cFindTitle", column="cFindTitle"),
					@Result(property="UserId", column="UserId"),
					@Result(property="cFindDate", column="cFindDate"),
					@Result(property="cFindContent", column="cFindContent"),
					@Result(property="cFindClick", column="cFindClick")
			})
			
			// 글찾기 부분 
			public ArrayList<BoardBean> getSearchedList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage, @Param("likeThis") String strSearchThis);
			
			@Insert(insert)  // 글 쓰기 
			//@Options(useGeneratedKeys = true, keyProperty = "cFindNum")
			void insertBoard(BoardBean boardBean);
			
			@Update(update_by_cFindNum)  // 글 수정하기
			void updateBoard(@Param("cFindNum") int cFindNum, @Param("cFindTitle") String cFindTitle, @Param("cFindContent") String cFindContent);
			
			@Delete(delete_by_cFindNum)   // 글 삭제하기 
			void deleteSpecificRow(@Param("cFindNum") int cFindNum);
		}

