package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 画面を表示　2019/04/04 17:30
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Helper.LOGIN_PAGE).forward(request, response);
	}

	/**
	 * ログイン処理
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getAttribute("loginErrorMessage");

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		try {
			String loginId = request.getParameter("login_id");
			String password = request.getParameter("password");

			int customer = CustomerDao.receiveUserId(loginId, password);

			if(customer != 0){
				session.setAttribute("isLogin", true);
				session.setAttribute("userId", customer);
				session.setAttribute("logId", loginId);
				response.sendRedirect("TopPage");
				System.out.println("ログイン処理完了！");

			} else {

				session.setAttribute("loginId", loginId);
				request.setAttribute("loginErrorMessage", "入力内容が正しくありません<br><br>正しいものを入力してください。");
				request.getRequestDispatcher(Helper.LOGIN_PAGE).forward(request, response);
			}

		} catch (NoSuchAlgorithmException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
