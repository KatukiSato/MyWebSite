package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;

/**
 * Servlet implementation class CartItemDelete
 */
@WebServlet("/CartItemUpdate")
public class CartItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String login = (String) session.getAttribute("logId");
		String command = request.getParameter("cart_button");

		switch(command) {
		case "delete":
			int deleteCartId = Integer.parseInt(request.getParameter("deleteCartItem"));

			try {
				CartDao.deleteCartItem(login, deleteCartId);
				response.sendRedirect("Cart");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Change":
			int itemId = Integer.parseInt(request.getParameter("test"));
			int qualityChange = Integer.parseInt(request.getParameter("qualityChange"));

			try {
				CartDao.qualityChange(qualityChange,login, itemId);
				response.sendRedirect("Cart");
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			break;

		}

	}

}
