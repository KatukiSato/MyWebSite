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
	 *確認画面で戻る、もしくは入力情報に不備があった場合、データを残して戻る。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		CustomerDataBeans cdb = (CustomerDataBeans) session.getAttribute("udb");
		String validationMessage = (String) session.getAttribute("validationMessage");


		request.getRequestDispatcher(Helper.NEWENTRY_PAGE).forward(request, response);
	}

}
