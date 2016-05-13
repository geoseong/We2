package com.we2.sharepjtboard;

public class PagingManager {

	// 인스턴스 싱글톤 객체
	private static final PagingManager pagingManager = new PagingManager();
	
	// 기본생성자
	private PagingManager(){}
	
	// 싱글톤 사용
	public static PagingManager getInstance(){
		return pagingManager;
	}
	
	// 현재페이지 시작레코드
	public int getFirstRowInPage(int page, int rows_per_page){
		return ((page-1)*rows_per_page+1);
	}
	
	// 현재페이지 종료레코드
	public int getLastRowInPage(int page, int rows_per_page){
		return (page*rows_per_page);
	}
}
