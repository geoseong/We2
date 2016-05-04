package mysite.com.app;

import javax.jws.WebParam.Mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BbsController {

	@Autowired		// ���� ��ü �ڵ� ��������
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@RequestMapping(value="/show_write_form.do", method=RequestMethod.GET)
	public String show_write_form(Model model){
		logger.info("show_write_form called!!");	// ��ü�� �����ؼ� ���� ���;� ��!!!
		model.addAttribute("boardBeanObjToWrite", new BoardBean());
		return "board/writeBoard";
	}
	
	@RequestMapping(value="/DoWriteBoard.do", method=RequestMethod.POST)
	public String DoWriteBoard(BoardBean boardBeanObjToWrite, Model model){
		logger.info("DoWriteBoard called!!");
		logger.info("memo=[" + boardBeanObjToWrite.getMemo() + "]");
		boardService.insertBoard(boardBeanObjToWrite);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", "1");		// ���ۼ� �Ŀ��� ó�� �������� ���ư���
		model.addAttribute("boardList", boardService.getList(1, 2));
		return "board/listSpecificPage";
	}
	
	// ���� ��� ��ȸ
	@RequestMapping(value="/viewWork.do", method=RequestMethod.GET)
	public String viewWork (
				@RequestParam("memo_id") String memo_id,
				@RequestParam("current_page") String current_page,
				@RequestParam("searchStr") String searchStr,
				Model model
			)
	{
		logger.info("viewWork called!!");
		logger.info("memo_id=[" + memo_id + "] current_page=[" + current_page + "] searchStr=[" + searchStr + "]");
		model.addAttribute("memo_id", memo_id);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardService.getSpecificRow(memo_id));
		return "board/viewMemo";
	}
	
	// Ư�� ���������� �۾��� ������� ���ð��, ���� ������ ��ȣ�� �����ؼ� �ش� ������ ���
	@RequestMapping(value="/listSpecificPageWork.do", method=RequestMethod.GET)
	public String listSpecificPageWork( @RequestParam("current_page") String pageForView, Model model)
	{
		System.out.println("-------------------------------------------");
		logger.info("listSpecificPageWork called!!");
		logger.info("current_page=[" + pageForView + "]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView), 2));
		System.out.println("-------------------------------------------listSpecificPage");
		return "board/listSpecificPage";
	}
	
	// Ư�� ������ ������ ���� ���� ���
	@RequestMapping(value="/listSpecificPageWork_to_update.do", method=RequestMethod.GET)
	public String listSpecificPageWork_to_update(
				@RequestParam("memo_id") String memo_id,
				@RequestParam("current_page") String current_page,
				Model model
			)
	{
		logger.info("listSpecificPageWork_to_update called!!");
		logger.info("memo_id=[" + memo_id + "] current_page=[" + current_page + "]");
		model.addAttribute("memo_id", memo_id);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(memo_id));
		return "board/viewMemoForUpdate";
	}
	
	// ���� row ������Ʈ
	@RequestMapping(value="/DoUpdateBoard.do", method=RequestMethod.POST)
	public String DoUpdateBoard(
				BoardBean boardBoardObjToUpdate,
				@RequestParam("memo_id") int memo_id,	// String, int �� �� �����
				@RequestParam("current_page") String current_page,
				Model model
			)
	{
		logger.info("DoUpdateBoard called!!");
		logger.info("listSpecificPageWork_to_update called!!");
			// boardBeanObjToUpdate.getId() �� 0�̴�! ���� �������� �ʾұ� �����̴�. ���, memo_id�� �̿�����.
		logger.info("memo_id=[" + memo_id + "" + "/" + boardBoardObjToUpdate.getId() + "current_page=[" + current_page + "]");
		logger.info("memo=[" + boardBoardObjToUpdate.getMemo() + "]");
		boardBoardObjToUpdate.setId(memo_id); 	//�ణ�� �ļ�.(?)
		boardService.updateBoard(boardBoardObjToUpdate);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "board/listSpecificPage";
	}
	
	// ���� DeleteSpecificRow
	@RequestMapping(value="/DeleteSpecificRow.do", method=RequestMethod.GET)
	public String DeleteSpecificRow(
			@RequestParam("memo_id") int memo_id,
			@RequestParam("current_page") String current_page,
			Model model
			)
	{
		logger.info("DeleteSpecificRow called!!");
		logger.info("memo_id=[" + memo_id + "] current_page=[" + current_page + "]");
		boardService.deleteRow(memo_id);
		// �ٽ� �������� ��ȸ�Ѵ�.
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "board/listSpecificPage";
	}
	
	@RequestMapping(value="/searchWithSubject.do", method=RequestMethod.POST)
	public String searchWithSubject(
				@RequestParam("searchStr") String searchStr,
				Model model
			) 
	{
		// redirection...
		return listSearchedSepcificPageWork("1", searchStr, model); 		// ó������ 1 �������� ������
	}
	
	// �˻��� ���¿��� Ư�� �������� �̵��ϱ�
	@RequestMapping(value="/listSearchedSepcificPageWork.do", method=RequestMethod.GET)
	public String listSearchedSepcificPageWork(
				@RequestParam("pageForView") String pageForView,
				@RequestParam("searchStr") String searchStr,
				Model model
			)
	{
		logger.info("listSearchedSepcificPageWork called!!");
		logger.info("pageForView=[" + pageForView + "]");
		logger.info("searchStr=[" + searchStr + "]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCntBySubject(searchStr)));
		model.addAttribute("searchedList", boardService.getSearchedList(Integer.parseInt(pageForView), 2, searchStr));
		model.addAttribute("pageForView", Integer.parseInt(pageForView));
		model.addAttribute("searchStr", searchStr);
		return "board/listSearchedPage";
	}
	
} //end class
