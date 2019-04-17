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
 * Servlet implementation class UserDetail
 */
@WebServlet("/UserDetail")
public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userId");

		try {
			ArrayList<CustomerDataBeans> userInfo = CustomerDao.getUserInfoByUserId(userId);
			session.setAttribute("userInfo", userInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher(Helper.USER_DETAIL_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
