package com.we2.studyroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.we2.studyroom.RPagingManager;

public class RPagingManager {


		// 인스턴스 싱글톤 객체
		private static final RPagingManager pagingManager = new RPagingManager();
		
		// 기본생성자
		private RPagingManager(){}
		
		// 싱글톤 사용
		public static RPagingManager getInstance(){
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
