package com.we2.file;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.we2.file.RPagingManager;

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
		public int getTotalPage(int t_rows, int rows_per_page){
			int total_pages=0;
			if((t_rows%rows_per_page)==0){
				total_pages = t_rows / rows_per_page;
			}else{
				total_pages = (t_rows / rows_per_page)+1;
			}
			return total_pages;
		}
			//게시판의 block처리 (한 화면에 표시할 페이지 수 , 이전/다음 버튼 처리)
			public int getPageBlock(int page, int page_for_block){
				int block = 0;
				if((page%page_for_block)==0){
					block = page / page_for_block;
				}else{
					block = page / page_for_block + 1;
				}
				return block;
			}
			
			public int getFirstPageInBlock(int block, int page_for_block){
				return ((block-1)*page_for_block+1);
			}
			
			public int getLastPageBlock(int block, int page_for_block){
				return (block*page_for_block);
			}
			
		}
