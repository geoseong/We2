package mysite.com.app;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {

	final String SELECT_PAGE = 
			"select * from (select id, subject, name, created_date, mail, memo, hits, "+
			"ceil( rownum / #{rowsPerPage} ) as page "+
			" from spring_board order by id desc) where page=#{page}";
	
	final String SELECT_BY_ID =
			"select id, subject, name, created_date, mail, memo, hits "+
			"from spring_board where id=#{id}";
	
	final String SELECT_CNT_BY_SUBJECT =
			"select count(1) from spring_board where "+
			"subject like '$' || '${searchThis}' || '%'";
	
	final String SELECT_ROWS_BY_SUBJECT = 
			"select * from (select id, subject, name, created_date, mail, memo, hits, "+
			"ceil( rownum / #{rowsPerPage} ) as page from spring_board "+
			"where subject like '%' || '${likeThis} || '%' order by id desc) "+
			"where page = #{page}";
	
	final String SELECT_CNT_ALL = "select count(1) from spring_board";
	
	final String INSERT = 
			"insert into spring_board (id, subject, name, created_date, mail, memo) "+
			"values( seq_id.nextval, #{subject}, #{name}, sysdate, #{mail}, #{memo})";
	
	final String UPDATE_BY_ID = 
			"update spring_board set subject=#{subject}, mail=#{mail}, memo=#{memo} where id=#{id}";
	
	final String DELETE_BY_ID = "delete from spring_board where id=#{id}";
	
	// BoardBean의 속성들과 동일한 이름으로 #{mail} 등을 지정해야 한다.
	@Select(SELECT_PAGE)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="subject", column="subject"),
			@Result(property="name", column="name"),
			@Result(property="created_date", column="created_date"),
			@Result(property="mail", column="mail"),
			@Result(property="memo", column="memo"),
			@Result(property="hits", column="hits"),
	})
	ArrayList<BoardBean> getList(@Param("page") int page, @Param("rowsPerPage") int rowsPerPage);

	@Select(SELECT_BY_ID)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="subject", column="subject"),
			@Result(property="name", column="name"),
			@Result(property="created_date", column="created_date"),
			@Result(property="mail", column="mail"),
			@Result(property="memo", column="memo"),
			@Result(property="hits", column="hits"),
	})
	BoardBean getSpecificRow(@Param("id") String id);
	
	// 전체 글 갯수 조회
	@Select(SELECT_CNT_ALL) int getTotalCnt();
	
	// 해당 주제의 관련글 갯수를 조회
	@Select(SELECT_CNT_BY_SUBJECT) int getTotalCntBySubject(@Param("searchThis") String includingThis);
	
	// 해당 주제의 관련글 조회
	@Select(SELECT_ROWS_BY_SUBJECT)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="subject", column="subject"),
			@Result(property="name", column="name"),
			@Result(property="created_date", column="created_date"),
			@Result(property="mail", column="mail"),
			@Result(property="memo", column="memo"),
			@Result(property="hits", column="hits"),
	})
	public ArrayList<BoardBean> getSearchedList(@Param("page") int page,
															 @Param("rowsPerPage") int rowsPerPage,
															 @Param("likeThis") String strSearchThis);
	
	@Insert(INSERT)
	// @Options(useGeneratedKeys = true, keyProperty = "id")
	void insertBoard (BoardBean boardBean);
	
	@Update(UPDATE_BY_ID)
	void updateBoard(@Param("id") int id, @Param("subject") String subject,
							@Param("mail") String mail, @Param("memo") String memo);
	
	@Delete(DELETE_BY_ID)
	void deleteSpecificRow(@Param("id") int id);
}
