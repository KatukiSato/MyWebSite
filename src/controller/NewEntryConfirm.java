package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerDataBeans;
import dao.CustomerDao;

/**
 * Servlet implementation class NewEntryConfirm
 */
@WebServlet("/NewEntryConfirm")
public class NewEntryConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEntryConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		try {
			//入力した内容を入れていく処理を行う。

			String inputloginId = request.getParameter("login_id");
			String inputName = request.getParameter("name");
			String inputMail = request.getParameter("mail");
			String inputPhone = request.getParameter("phone");
			String inputAddress = request.getParameter("address");
			String inputPassword = request.getParameter("password");
			String inputCheckPassword = request.getParameter("Checkpassword");

			CustomerDataBeans cdb = new CustomerDataBeans();

			cdb.setLogin_id(inputloginId);
			cdb.setName(inputName);
			cdb.setMail(inputMail);
			cdb.setPhone(inputPhone);
			cdb.setAddress(inputAddress);
			cdb.setLogin_password(inputPassword);

			String validationMessage = "";

			// 入力されているパスワードが確認用と等しいか
			if (!inputPassword.equals(inputCheckPassword)) {
				validationMessage += "入力されているパスワードと確認用パスワードが違います<br>";
			}

			// ログインIDの入力規則チェック 英数字 ハイフン のみ入力可能
			if (!Helper.isLoginIdform(cdb.getLogin_id())) {
				validationMessage += "半角英数とハイフンのみ入力できます";
			}

			// loginIdの重複をチェック
			if (CustomerDao.isMatchLoginId(inputloginId)) {
				validationMessage += "ほかのユーザーが使用中のログインIDです";
			}

			// 問題がないなら登録完了画面へ。そうでないなら新規登録画面へ。
			if (validationMessage.length() == 0) {
				request.setAttribute("udb", cdb);
//				request.getRequestDispatcher(Helper.REGIST_CONFIRM_PAGE).forward(request, response);
				request.getRequestDispatcher(Helper.NEW_ENTRY_CONFIRM_PAGE).forward(request, response);

			} else {
				session.setAttribute("udb", cdb);
				session.setAttribute("validationMessage", validationMessage);
				request.getRequestDispatcher(Helper.NEW_ENTRY_CONFIRM_PAGE).forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
