package com.we2.board.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.board.community.BoardController;
import com.we2.board.community.BoardBean;
import com.we2.board.community.BoardService;

@Controller
//@RequestMapping(value="/testSpringMvc")

public class BoardController {

	@Autowired  // ������ �ڵ� ����
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	// BoardWritefind - 1) �۾���
	@RequestMapping(value = "/show_write_form.do", method=RequestMethod.GET)  // ��Ʈ�ѷ��� ó���� ��û URL
	public String show_write_form(Model model){
		logger.info("show_write_form called!!");
		//��ü�� �����ؼ� ���� ���;� ��!!
		model.addAttribute("boardBeanObjToWrite", new BoardBean());
		
		return "communityboard/BoardWritefind";   // �۾��� â���� ����
	}
	
	// BoardWritefind -> BoardListfind 2) �� �ۼ��� ����Ʈ�� ���ư��� 
	@RequestMapping(value="/DoWriteBoard.do", method=RequestMethod.POST)
	public String DoWrtieBoard(BoardBean boardBeanObjToWrite, Model model){
		logger.info("DoWriteBoard called!!");
		logger.info("cFindContent=["+boardBeanObjToWrite.getcFindContent()+"]");
		boardService.insertBoard(boardBeanObjToWrite);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", "1"); // ���� �ۼ��Ŀ��� ó�� �������� ���ư���
		model.addAttribute("boardList", boardService.getList(1, 2));
		return "communityboard/BoardListfind";  // �� ���(����Ʈ)�� ����
	}
	
	
	
	// BoardContentfind - 1) ���� ����
	@RequestMapping(value="/viewWork.do", method=RequestMethod.GET)
	public String viewWork(@RequestParam("cFindContent_cFindNum") String cFindContent_cFindNum, @RequestParam("current_page") String current_page, @RequestParam("searchStr") String searchStr, Model model){
		logger.info("viewWork called!!");
		logger.info("cFindContent_cFindNum=["+cFindContent_cFindNum+"] current_page=["+current_page+"] searchStr=["+searchStr+"]");
		model.addAttribute("cFindContent_cFindNum", cFindContent_cFindNum);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardService.getSpecificRow(cFindContent_cFindNum));
		return "communityboard/BoardContentfind";
	}
	
	// BoardContentfind -> BoardListfind - 2) ���� �� �� �ٽ� list�� ���ư���
	@RequestMapping(value="/listSpecificPageWork.do", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("current_page") String pageForView, Model model){
		System.out.println("-------------------------------");
		logger.info("listSpecificPageWork called!!");
		logger.info("current_page=["+pageForView+"]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView), 2));
		System.out.println("--------------------------BoardListfind");
		
		return "communityboard/BoardListfind";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		System.out.println("test");
		return "index";
	}
	
	//Ư�� ������ ������ ���� ���� ���
	// BoardUpdatefind - 1) �� �����ϱ�
	@RequestMapping(value="/listSpecificPageWork_to_update.do", method=RequestMethod.GET)
	public String listSpecificPageWork_to_update(@RequestParam("cFindContent_cFindNum") String cFindContent_cFindNum, @RequestParam("current_page") String current_page, Model model){
		logger.info("listSpecificPageWork_to_update called!!");
		logger.info("cFindContent_cFindNum=["+cFindContent_cFindNum+"] current_page=["+current_page+"]");
		model.addAttribute("cFindContent_cFindNum", cFindContent_cFindNum);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(cFindContent_cFindNum));
		return "communityboard/BoardUpdatefind";
	}
	
	
	// BoardUpdatefind -> BoardListfind - 2) �� ������ �� �ٽ� list�� ���ư���
	//���� row ������Ʈ
	@RequestMapping(value="/DoUpdateBoard.do", method=RequestMethod.POST)
	public String DoUpdateBoard(BoardBean boardBeanObjToUpdate, @RequestParam("cFindContent_cFindNum") int cFindContent_cFindNum, @RequestParam("current_page") String current_page, Model model){
		logger.info("DoUpdateBoard called");
		logger.info("listSpecificPageWork_to_update called!!");
		//boardBeanObjToUpdate.getId()�� 0�̴�! ���� �������� �ʾұ� �����̴�. ��� .cFindContent_cFindNum�� �̿�����.
		logger.info("cFindContent_cFindNum=["+cFindContent_cFindNum+""+"/"+boardBeanObjToUpdate.getcFindNum()+"] current_page=["+current_page+"]");
		logger.info("cFindContent=["+boardBeanObjToUpdate.getcFindContent()+"]");
		boardBeanObjToUpdate.setcFindNum(cFindContent_cFindNum);//�ణ�� �ļ�
		boardService.updateBoard(boardBeanObjToUpdate);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "communityboard/BoardListfind";
	}
	
	
	// BoardDeletefind - 1) �� �����ϱ�
	// ���� DeleteSpecificRow
	@RequestMapping(value="/DeleteSpecificRow.do", method=RequestMethod.GET)
	public String DeleteSpecificRow(@RequestParam("cFindContent_cFindNum") int cFindContent_cFindNum, @RequestParam("current_page") String current_page, Model model){
		logger.info("DeleteSpecificRow called!!");
		logger.info("cFindNum=["+cFindContent_cFindNum+"] current_page=["+current_page+"]");
		boardService.deleteRow(cFindContent_cFindNum);
		//�ٽ� �������� ��ȸ�Ѵ�.
		// BoardDeletefind -> BoardListfind - 2) �� ���� �� �ٽ� ����Ʈ�� ���ư���
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "communityboard/BoardListfind";   
	}
	
	
	// BoardSearch - 1) �� �˻��ϱ� 
	@RequestMapping(value="/searchWithSubject.do", method=RequestMethod.POST)
	public String searchWithSubject(@RequestParam("searchStr") String searchStr, Model model){
		//redirection...
		return listSearchedSpecificPageWork("1", searchStr, model);//ó������ 1�������� ������
	}

	// BoardSearch - 2) �˻��� Ư�� list�� �̵��ϱ�  
	// �˻��� ���¿��� Ư�� �������� �̵��ϱ�
	@RequestMapping(value="/listSearchedSpecificPageWork.do", method=RequestMethod.GET)
	public String listSearchedSpecificPageWork(@RequestParam("pageForView") String pageForView, @RequestParam("searchStr") String searchStr, Model model){
		logger.info("listSearchedSpecificPageWork called!!");
		logger.info("pageForView=["+pageForView+"]");
		logger.info("searchStr=["+searchStr+"]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCntBySubject(searchStr)));
		model.addAttribute("searchedList", boardService.getSearchedList(Integer.parseInt(pageForView), 2, searchStr));
		model.addAttribute("searchStr", searchStr);
		return "communityboard/BoardListfind";
	}
	
	
}
