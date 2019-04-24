package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerDataBeans;

/**
 * Servlet implementation class UserUpdateConfirm
 */
@WebServlet("/UserUpdateConfirm")
public class UserUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateConfirm() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<CustomerDataBeans> cusList = new ArrayList<CustomerDataBeans>();


		int id =(int) session.getAttribute("userId");
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String pass = request.getParameter("pass");
		String check = request.getParameter("check");

		CustomerDataBeans cus = new CustomerDataBeans();
		cus.setId(id);
		cus.setLogin_id(loginId);
		cus.setName(name);
		cus.setMail(mail);
		cus.setPhone(phone);
		cus.setAddress(address);
		cusList.add(cus);

		String validationMessage = "";

		if(!pass.equals("") && !check.equals("")) {
			try {
				String changePass = Helper.getAngo(pass);
				String changeCheck = Helper.getAngo(check);

				//入力したパスワードの確認
				if(changePass.equals(changeCheck)) {

					cus.setLogin_password(changePass);
				} else {
					validationMessage += "パスワードと確認のパスワードが間違っています";
				}

				if (!Helper.isLoginIdform(cus.getLogin_id())) {
					validationMessage += "ログインIDは半角英数とハイフンのみ入力できます";
				}

			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		if (validationMessage.length() == 0) {

			session.setAttribute("updateInfoExceptPass", cus);
			request.getRequestDispatcher(Helper.USER_UPDATE_CONFIRM_PAGE).forward(request, response);

		} else {
			session.setAttribute("userInfo", cusList);
			session.setAttribute("validationMessage", validationMessage);
			response.sendRedirect("UserUpdate");

		}
	}

}
