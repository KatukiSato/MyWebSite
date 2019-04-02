package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerDataBeans;

/**
 * Servlet implementation class NewEntry
 */
@WebServlet("/NewEntry")
public class NewEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//入力内容に誤りがある、確認画面で戻るボタン押し下げでアクセスしてきたときはセッションから入力情報を取得
		CustomerDataBeans udb = session.getAttribute("udb") != null?(CustomerDataBeans) Helper.cutSessionAttribute(session, "udb"):new CustomerDataBeans();
		String validationMessage = (String) Helper.cutSessionAttribute(session, "validationMessage");

		request.setAttribute("udb", udb);
		request.setAttribute("validationMessage",validationMessage);

		request.getRequestDispatcher(Helper.NEWENTRY_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//入力内容に誤りがある、確認画面で戻るボタン押し下げでアクセスしてきたときはセッションから入力情報を取得
		CustomerDataBeans udb = session.getAttribute("udb") != null?(CustomerDataBeans) Helper.cutSessionAttribute(session, "udb"):new CustomerDataBeans();
		String validationMessage = (String) Helper.cutSessionAttribute(session, "validationMessage");

		request.setAttribute("udb", udb);
		request.setAttribute("validationMessage",validationMessage);

		request.getRequestDispatcher(Helper.NEWENTRY_PAGE).forward(request, response);
	}


}
