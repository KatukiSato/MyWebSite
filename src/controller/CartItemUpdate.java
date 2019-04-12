package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
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

//		HttpSession session = request.getSession();
//		String login = (String) session.getAttribute("logId");
//
//		//カートに入れられた商品を表示する処理
//		try {
//			ArrayList<CartBeans> show = CartDao.showCart(login);
//
//			session.setAttribute("show", show);
//			session.getAttribute("cart");
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String login = (String) session.getAttribute("logId");
		int itemId = Integer.parseInt(request.getParameter("qualityChange"));
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
			int qualityChange = Integer.parseInt(request.getParameter("qualityChange"));

			try {
				CartBeans qChange = CartDao.qualityChange(qualityChange,login, itemId);
				session.setAttribute("qchange", qChange);
				request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			break;

		}

//		request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);

	}

}
