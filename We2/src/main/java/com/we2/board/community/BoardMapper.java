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


@Repository  // �����  -> �� ������̼��� ����� DAO Ŭ������ DB ���� ó���� �ڵ����� �Ѵ�. 
//1) �� SQL ���� ������ ����!
public interface BoardMapper {
    final String select_page="select * from (select cFindNum, cFindTitle, UserId, cFindDate, cFindContent, cFindClick, ceil( rownum / #{rowsPerPage} ) as page from spring_board order by cFindNum desc) where page = #{page}";
	
	final String select_by_cFindNum = "select cFindNum, cFindTitle, UserId, cFindDate, cFindContent, cFindClick from cFindWork where cFindNum=#{cFindNum}";
	
	final String select_cnt_by_cFindTitle = "select * from (select cFindNum, cFindTitle, UserId, cFindDate, cFindContent, cFindClick, ceil (rownum / #{rowsPerPage}) as page from cFindWork where cFindTitle like '%' || '${likeThis}' || '%' order by cFindNum desc) where page = #{page}";
	
	final String select_rows_by_cFindTitle = "select * from (select cFindNum, cFindTitle, UserId, ceil(rownum/#{rowsPerPage}) as page from cFindWork where cFindNum like '%' || '${likeThis}' || '%' order by cFindNum desc) where page = #{page}";
	
	final String select_cnt_all = "select count(1) from cFindWork";
	
	final String insert = "insert into cFindWork (cFindNum, cFindTitle, UserId, cFindDate, cFindContent) values (seq_cFindNum.nextval, #{cFindTitle}, #{UserId}, sysdate, #{cFindContent})";
	
	final String update_by_cFindNum = "update cFindWork set cFindTitle = #{cFindTitle}, cFindContent = #{cFindContent} where cFindNum = #{cFindNum}";
	
	final String delete_by_cFindNum = "delete from cFindWork where cFindNum = #{cFindNum}";
	
	// BoarderBean�� �Ӽ���� ������ �̸����� #{mail} ���� �����ؾ� �Ѵ�.
		@Select(select_page)  // 2) select �� �� �������� 
		
		
		@Results(value = {    //3) ������� �����ش�
				@Result(property="cFindNum", column="cFindNum"),
				@Result(property="cFindTitle", column="cFindTitle"),
				@Result(property="UserId", column="UserId"),
				@Result(property="cFindDate", column="cFindDate"),
				@Result(property="cFindContent", column="cFindContent"),
				@Result(property="cFindClick", column="cFindClick")
		})
		
	ArrayList<BoardBean> getList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);  // ��ü ����Ʈ ����
		
		@Select(select_by_cFindNum)   // ID�� ������ �� ���� 
		@Results(value = {
				@Result(property="cFindNum", column="cFindNum"),
				@Result(property="cFindTitle", column="cFindTitle"),
				@Result(property="UserId", column="UserId"),
				@Result(property="cFindDate", column="cFindDate"),
				@Result(property="cFindContent", column="cFindContent"),
				@Result(property="cFindClick", column="cFindClick")
		})
		BoardBean getSpecificRow(@Param("id") String id);
		
		   // ��ü �� ������ ��ȸ
			@Select(select_cnt_all)
			int getTotalCnt();
			
			// �ش� ������ ���� �� ������ ��ȸ
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
			
			// ��ã�� �κ� 
			public ArrayList<BoardBean> getSearchedList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage, @Param("likeThis") String strSearchThis);
			
			@Insert(insert)  // �� ���� 
			//@Options(useGeneratedKeys = true, keyProperty = "cFindNum")
			void insertBoard(BoardBean boardBean);
			
			@Update(update_by_cFindNum)  // �� �����ϱ�
			void updateBoard(@Param("cFindNum") int cFindNum, @Param("cFindTitle") String cFindTitle, @Param("cFindContent") String cFindContent);
			
			@Delete(delete_by_cFindNum)   // �� �����ϱ� 
			void deleteSpecificRow(@Param("cFindNum") int cFindNum);
		}

