package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerDataBeans;
import dao.CustomerDao;

/**
 * Servlet implementation class EntrySuccess
 */
@WebServlet("/EntrySuccess")
public class EntrySuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EntrySuccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object logcheck = session.getAttribute("userId");

		if (logcheck == null) {
			System.out.println("飛びます！");
			response.sendRedirect("TopPage");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");

		String NewEntry = request.getParameter("entry_button");

		//修正と登録ボタンの棲み分けの処理
		switch (NewEntry) {
		case "cancel":
			session.getAttribute("udb");
			request.getRequestDispatcher(Helper.NEWENTRY_PAGE).forward(request, response);
			break;

		case "entry":
			CustomerDataBeans cdb =(CustomerDataBeans) session.getAttribute("udb");
			try {
				CustomerDao.entryUser(cdb);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//登録完了したらセッションを捨てる。
			request.getRequestDispatcher(Helper.NEW_ENTRY_SUCCESS_PAGE).forward(request, response);
			session.removeAttribute("udb");
			break;
		}

	}

}
