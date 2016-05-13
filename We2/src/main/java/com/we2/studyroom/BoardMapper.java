// DAO�� ���� ����� �ϴ� BoardMapper ����  

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


@Repository  // �����  -> �� ������̼��� ����� DAO Ŭ������ DB ���� ó���� �ڵ����� �Ѵ�. 
// 1) �� SQL ���� ������ ����!
public interface BoardMapper {
	final String select_page="select * from (select id, subject, name, created_date, mail, memo, hits, ceil( rownum / #{rowsPerPage} ) as page from spring_board order by id desc) where page = #{page}";
	
	final String select_by_id = "select id, subject, name, created_date, mail, memo, hits from spring_board where id=#{id}";
	
	final String select_cnt_by_subject = "select * from (select id, subject, name, created_date, mail, memo, hits, ceil (rownum / #{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
	
	final String select_rows_by_subject = "select * from (select id, subject, name, ceil(rownum/#{rowsPerPage}) as page from spring_board where subject like '%' || '${likeThis}' || '%' order by id desc) where page = #{page}";
	
	final String select_cnt_all = "select count(1) from spring_board";
	
	final String insert = "insert into spring_board (id, subject, name, created_date, mail, memo) values (seq_id.nextval, #{subject}, #{name}, sysdate, #{mail}, #{memo})";
	
	final String update_by_id = "update spring_board set subject = #{subject}, mail = #{mail}, memo = #{memo} where id = #{id}";
	
	final String delete_by_id = "delete from spring_board where id = #{id}";
	
	// BoarderBean�� �Ӽ���� ������ �̸����� #{mail} ���� �����ؾ� �Ѵ�.
	@Select(select_page)  // 2) select �� �� �������� 
	
	
	@Results(value = {    //3) ������� �����ش�
			@Result(property="id", column="id"),
			@Result(property="subject", column="subject"),
			@Result(property="name", column="name"),
			@Result(property="created_date", column="created_date"),
			@Result(property="mail", column="mail"),
			@Result(property="memo", column="memo"),
			@Result(property="hits", column="hits")
	})
	
ArrayList<BoardBean> getList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);  // ��ü ����Ʈ ����
	
	@Select(select_by_id)   // ID�� ������ �� ���� 
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
	
	   // ��ü �� ������ ��ȸ
		@Select(select_cnt_all)
		int getTotalCnt();
		
		// �ش� ������ ���� �� ������ ��ȸ
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
		
		// ��ã�� �κ� 
		public ArrayList<BoardBean> getSearchedList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage, @Param("likeThis") String strSearchThis);
		
		@Insert(insert)  // �� ���� 
		//@Options(useGeneratedKeys = true, keyProperty = "id")
		void insertBoard(BoardBean boardBean);
		
		@Update(update_by_id)  // �� �����ϱ�
		void updateBoard(@Param("id") int id, @Param("subject") String subject, @Param("mail") String mail, @Param("memo") String memo);
		
		@Delete(delete_by_id)   // �� �����ϱ� 
		void deleteSpecificRow(@Param("id") int id);
	}