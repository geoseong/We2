package com.we2.studyroom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageNumberingManager {

private static final PageNumberingManager pageNumberingManger = new PageNumberingManager();
	
	private static final Logger logger = LoggerFactory.getLogger(PageNumberingManager.class);
	
	private PageNumberingManager(){}
	
	public static PageNumberingManager getInstance(){
		return pageNumberingManger;
	}
	
	public int getTotalPage(int total_cnt, int rowsPerPage){
		logger.info("getTotalPage callled!!");
		int total_pages=0;
		if((total_cnt%rowsPerPage)==0){
			total_pages = total_cnt / rowsPerPage;
		}else{
			total_pages = (total_cnt/rowsPerPage)+1;
		}
		logger.info("getTotalPage return total_pages="+total_pages);
		return total_pages;
	}
	
	//�Խ�����  blockó�� �߰� �ʿ�(����/���� �� ��ư ó��)
	public int getPageBlock(int curPage, int pagePerBlock){
		int block = 0;
		if((curPage%pagePerBlock)==0){
			block = curPage / pagePerBlock;
		}else{
			block = curPage / pagePerBlock + 1;
		}
		return block;
	}
	
	//block �� ���� ù��° ������ ���
	public int getFirstPageInBlock(int block, int pagePerBlock){
		return ((block-1)*pagePerBlock+1);
		
	}
	
	// block�� ���� ������ ������ ���
	public int getLastPageBlock(int block, int pagePerBlock){
		return (block*pagePerBlock);
	}
}
