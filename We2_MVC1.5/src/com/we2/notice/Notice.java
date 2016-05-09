package com.we2.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Notice.do")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpSession session = request.getSession();

		String list = request.getParameter("list");
		/* String url = "../notice/list.jsp"; */
		String view = request.getParameter("view");
		String num = request.getParameter("num");
		String modify = request.getParameter("modify");
		String delete = request.getParameter("delete");
		String write = request.getParameter("write");

		// list.jsp?óê?Ñú ?ã§?ñâ?ê† Î∂?Î∂ÑÏúºÎ°? ?òà?ÉÅ?ê®
		request.setAttribute("num", num);

		if (list != null) {
			request.setAttribute("page", list);
		} else if (view != null) {
			request.setAttribute("page", view);
		} else if (modify != null) {
			request.setAttribute("page", modify);
		} else if (delete != null) {
			request.setAttribute("page", delete);
		} else {
			request.setAttribute("page", write);
		} // end if
		System.out.println(list);
		// end if
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Project/02_project.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
