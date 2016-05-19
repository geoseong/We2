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

import com.we2.pjtMake.PjtMakeVO;
import com.we2.spring.Member;

public class ExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> ModelMap, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String excelName = ModelMap.get("target").toString();
        HSSFSheet worksheet = null;
        HSSFRow row = null;
        if(excelName.equals("article")){
               excelName=URLEncoder.encode("프로젝트","UTF-8");
               worksheet = workbook.createSheet(excelName+ " WorkSheet");
               @SuppressWarnings("unchecked")
               List<PjtMakeVO> list = (List<PjtMakeVO>)ModelMap.get("excelList");
               row = worksheet.createRow(0);
               row.createCell(0).setCellValue("글번호");
               row.createCell(1).setCellValue("제목");
               row.createCell(2).setCellValue("날짜");
               row. createCell(3).setCellValue("글쓴이");
               row.createCell(4).setCellValue("비밀번호");
               row.createCell(5).setCellValue("내용");
               for(int i=1;i<list.size()+1;i++){
                      row = worksheet.createRow(i);
                      row.createCell(0).setCellValue(list.get(i-1).getPjtName());
                      row.createCell(1).setCellValue(list.get(i-1).getPjtClassify());
                      row.createCell(2).setCellValue(list.get(i-1).getStartDate());
                      row.createCell(3).setCellValue(list.get(i-1).getEndDate());
               }
        }
        if(excelName.equals("comment")){
               @SuppressWarnings("unchecked")
               List<Member> list = (List<Member>)ModelMap.get("excelList");
               excelName=URLEncoder.encode("댓글","UTF-8");
               worksheet = workbook.createSheet(excelName+ " WorkSheet");
               row = worksheet.createRow(0);
               row.createCell(0).setCellValue("댓글번호");
               row.createCell(1).setCellValue("게시글번호");
               row.createCell(2).setCellValue("날짜");
               row.createCell(3).setCellValue("글쓴이");
               row.createCell(4).setCellValue("비밀번호");
               row.createCell(5).setCellValue("내용");
               for(int i=1;i<list.size()+1;i++){
                      row = worksheet.createRow(i);
                      row.createCell(0).setCellValue(list.get(i-1).getEmail());
                      row.createCell(1).setCellValue(list.get(i-1).getGender());
                      row.createCell(2).setCellValue(list.get(i-1).getName());
                      row.createCell(3).setCellValue(list.get(i-1).getUserId());
                      row.createCell(4).setCellValue(list.get(i-1).getPwd());
                      row.createCell(5).setCellValue(list.get(i-1).getRegDate());
               }
        }
       /* if(excelName.equals("file")){
               @SuppressWarnings("unchecked")
               List<BoardFile> list = (List<BoardFile>)ModelMap.get("excelList");
               excelName=URLEncoder.encode("파일","UTF-8");
               worksheet = workbook.createSheet(excelName+ " WorkSheet");
               row = worksheet.createRow(0);
               row.createCell(0).setCellValue("파일번호");
               row.createCell(1).setCellValue("게시글번호");
               row.createCell(2).setCellValue("파일경로");
               row.createCell(3).setCellValue("파일이름");
               row.createCell(4).setCellValue("파일크기");
               for(int i=1;i<list.size()+1;i++){
                      row = worksheet.createRow(i);
                      row.createCell(0).setCellValue(list.get(i-1).getFileNo());
                      row.createCell(1).setCellValue(list.get(i-1).getArticleNo());
                      row.createCell(2).setCellValue(list.get(i-1).getFilePath());
                      row.createCell(3).setCellValue(list.get(i-1).getFileName());
                      row.createCell(4).setCellValue(list.get(i-1).getFileSize());
               }
        }*/
        
        //  다운로드를 구현하였기때문에 response 객체에 몇가지 설정을 추가하였다.
        response.setContentType("Application/Msexcel");
        response.setHeader("Content-Disposition", "ATTachment; Filename="+excelName+"-excel");
		
	}

}

/*
@Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow header = sheet.createRow(0);
        header.createCell((short) 0).setCellValue("Test1");
        header.createCell((short) 1).setCellValue("Test2");
        header.createCell((short) 2).setCellValue("Test3");
        header.createCell((short) 3).setCellValue("Test4");
        header.createCell((short) 4).setCellValue("Test5");

        HSSFRow row = sheet.createRow(1);
        row.createCell((short) 0).setCellValue("Test1");
        row.createCell((short) 1).setCellValue("Test2");
        row.createCell((short) 2).setCellValue("Test3");
        row.createCell((short) 3).setCellValue("Test4");
        row.createCell((short) 4).setCellValue("Test5");
*/