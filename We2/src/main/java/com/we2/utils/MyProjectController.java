package com.we2.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.pjtMake.PjtMakeVO;

@Controller
public class MyProjectController {

	@Autowired
	ExcelService service;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	HSSFWorkbook workbook;
	ExcelView excelView;
	
	//엑셀파일 변환 및 다운로드
	@RequestMapping(value="/excel_transform", method=RequestMethod.GET)
	public String excelTransform(@RequestParam("target") String target, Map<String,Object> ModelMap) throws Exception{
		System.out.println("엑셀변환 시작");
		// List<Object> excelList= null;
		List<PjtMakeVO> excelList = service.getAllObjects(target);
	    System.out.println("getAllObjects메소드 실행.");
	    ModelMap.put("excelList", excelList);
	    ModelMap.put("target", target);
	    
	    System.out.println("ModelMap : " + ModelMap.get(excelList));
	    System.out.println("ModelMap : " + ModelMap.get(target));
	    excelView.buildExcelDocument(ModelMap, workbook, request, response);
	    return "myproject/excelView";
	}
	
}
