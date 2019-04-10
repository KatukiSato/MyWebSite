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

	/**
	 * @author snowr
	 *保存したセッションを取り出して削除。やり直した場合、何も入力されていない状態にしている。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		CustomerDataBeans cdb = (CustomerDataBeans) session.getAttribute("udb");

		if(cdb == null) {
			System.out.println("真っ新な状態で出ています。");
		}else {
			System.out.println("入力情報が残っています。");
		}

		request.getAttribute("validationMessage");

		request.getRequestDispatcher(Helper.NEWENTRY_PAGE).forward(request, response);
	}

}
