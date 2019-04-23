package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerDataBeans;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//初期表示用に使っている。
		ArrayList<CustomerDataBeans> cdb = session.getAttribute("userInfo")!= null?(ArrayList<CustomerDataBeans>)
				Helper.cutSessionAttribute(session, "userInfo"):(ArrayList<CustomerDataBeans>)session.getAttribute("userInfo");;

		request.setAttribute("user", cdb);
		request.getRequestDispatcher(Helper.USER_UPDATE_PAGE).forward(request, response);

	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		CustomerDataBeans customer = (CustomerDataBeans) session.getAttribute("userInfo");
//
//		try {
//			CustomerDataBeans updateInfoExceptPass = CustomerDao.updateInfoExceptPass(customer);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		request.getRequestDispatcher(Helper.USER_UPDATE_PAGE).forward(request, response);
//	}

}
