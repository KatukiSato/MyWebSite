package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerDataBeans;
import dao.CustomerDao;

/**
 * Servlet implementation class UpdateSuccess
 */
@WebServlet("/UpdateSuccess")
public class UpdateSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(Helper.UPDATE_SUCCESS_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		ArrayList<CustomerDataBeans> cusList = new ArrayList<CustomerDataBeans>();
		CustomerDataBeans cus =(CustomerDataBeans) session.getAttribute("updateInfoExceptPass");
		cusList.add(cus);

		String update = request.getParameter("updete_button");

		switch (update) {
		case "update":
			try {
				if(!CustomerDao.isMatchPass(cus.getLogin_id())) {
					try {
						CustomerDao.updateInfoExceptPass(cus);
						session.removeAttribute("updateInfoExceptPass");

					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				} else {
					try {
						CustomerDao.updateInfoAll(cus);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			System.out.println("テスト！");
			request.getRequestDispatcher(Helper.UPDATE_SUCCESS_PAGE).forward(request, response);
			break;

		case "cancel":
			session.setAttribute("userInfo", cusList);
			System.out.println("戻りました。");
			response.sendRedirect("UserUpdate");
			break;

		}
	}

}
