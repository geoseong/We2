package com.we2.utils;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.we2.notice.NoticeDto;
import com.we2.pjtMake.PjtMakeVO;
import com.we2.scheduler.SchedulerBean;
import com.we2.willwork.WillWorkVO;

public class ExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> ModelMap, 
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 한글 인코딩 설정 
		response.setContentType("text/plain;charset=UTF-8");
		
		// 변수 지정
		String excelName = ModelMap.get("target").toString();
        HSSFSheet worksheet = null;
        HSSFRow row = null;
        	
        if(excelName.equals("pjtexport")){
        	// 엑셀 파일명 지정.
           excelName=URLEncoder.encode(ModelMap.get("pjtname").toString(),"UTF-8");
           
           /** 프로젝트 Overview */
           // 엑셀시트 이름 지정 및 만들기
           worksheet = workbook.createSheet(ModelMap.get("pjtname").toString()+ " 프로젝트 정보");
           @SuppressWarnings("unchecked")
           List<PjtMakeVO> list = (List<PjtMakeVO>)ModelMap.get("overview");
               row = worksheet.createRow(0);
               row.createCell(0).setCellValue("프로젝트코드");
               row.createCell(1).setCellValue("프로젝트이름");
               row.createCell(2).setCellValue("프로젝트분류");
               row. createCell(3).setCellValue("시작날짜");
               row.createCell(4).setCellValue("종료날짜");
               
           for(int i=1;i<list.size()+1;i++){
                  row = worksheet.createRow(i);
                  row.createCell(0).setCellValue(list.get(i-1).getPjtCode());
                  row.createCell(1).setCellValue(list.get(i-1).getPjtName());
                  row.createCell(2).setCellValue(list.get(i-1).getPjtClassify());
                  row.createCell(3).setCellValue(list.get(i-1).getStartDate());
                  row.createCell(4).setCellValue(list.get(i-1).getEndDate());
           }
           
	       /** 공지사항 */
	       // 엑셀시트 이름 지정 및 만들기
	       worksheet = workbook.createSheet("공지사항");
	       @SuppressWarnings("unchecked")
	       List<NoticeDto> notice = (List<NoticeDto>)ModelMap.get("notice");
	           row = worksheet.createRow(0);
	           row.createCell(0).setCellValue("글제목");
	           row.createCell(1).setCellValue("내용");
	           row.createCell(2).setCellValue("글쓴이");
	           row. createCell(3).setCellValue("글쓴날짜");
	           
	       for(int i=1;i<notice.size()+1;i++){
	              row = worksheet.createRow(i);
	              row.createCell(0).setCellValue(notice.get(i-1).getTitle());
	              row.createCell(1).setCellValue(notice.get(i-1).getContent());
	              row.createCell(2).setCellValue(notice.get(i-1).getWriter());
	              row.createCell(3).setCellValue(notice.get(i-1).getWritedate());
	       }
           
	        /** 스케쥴러 */
	        // 엑셀시트 이름 지정 및 만들기
	           worksheet = workbook.createSheet("스케쥴러");
	           @SuppressWarnings("unchecked")
	           List<SchedulerBean> scheduler = (List<SchedulerBean>)ModelMap.get("scheduler");
	               row = worksheet.createRow(0);
	               row.createCell(0).setCellValue("년");
	               row.createCell(1).setCellValue("월");
	               row.createCell(2).setCellValue("일");
	               row. createCell(3).setCellValue("내용");
	               
	           for(int i=1;i<scheduler.size()+1;i++){
	                  row = worksheet.createRow(i);
	                  row.createCell(0).setCellValue(scheduler.get(i-1).getCalendarmemo_year());
	                  row.createCell(1).setCellValue(scheduler.get(i-1).getCalendarmemo_month());
	                  row.createCell(2).setCellValue(scheduler.get(i-1).getCalendarmemo_day());
	                  row.createCell(3).setCellValue(scheduler.get(i-1).getCalendarmemo_contents());
	           }
           
           /** 할 일 */
           // 엑셀시트 이름 지정 및 만들기
              worksheet = workbook.createSheet("할 일");
              @SuppressWarnings("unchecked")
              List<WillWorkVO> willwork = (List<WillWorkVO>)ModelMap.get("willwork");
                  row = worksheet.createRow(0);
                  row.createCell(0).setCellValue("유저아이디");
                  row.createCell(1).setCellValue("이름");
                  row.createCell(2).setCellValue("해야 할 일");
                  row. createCell(3).setCellValue("완료한 일");
                  
              for(int i=1;i<willwork.size()+1;i++){
                     row = worksheet.createRow(i);
                     row.createCell(0).setCellValue(willwork.get(i-1).getUserId());
                     row.createCell(1).setCellValue(willwork.get(i-1).getName());
                     row.createCell(2).setCellValue(willwork.get(i-1).getDoWork());
                     row.createCell(3).setCellValue(willwork.get(i-1).getDoneWork());
              }
        }
        //  다운로드를 구현하였기때문에 response 객체에 몇가지 설정을 추가하였다.
        response.setContentType("Application/Msexcel");
        response.setHeader("Content-Disposition", "ATTachment; Filename=We2_"+excelName+"_info.xls");
	}
}
