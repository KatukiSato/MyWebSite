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

import beans.BuyHistryBeans;
import beans.CartBeans;
import beans.DeliveryMethodBeans;
import beans.PayMethodBeans;
import dao.DeliveryMethodDao;
import dao.PayMethodDao;

/**
 * Servlet implementation class RegisterConfirm
 */
@WebServlet("/RegisterConfirm")
public class RegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

			try {
				int paymethodid = Integer.parseInt(request.getParameter("pay_method"));
				int deliverymethodid = Integer.parseInt(request.getParameter("delivery_method"));
				ArrayList<CartBeans> show = (ArrayList<CartBeans>) session.getAttribute("show");

				//取得した配送IDを使って配送方法と値段を取得
				DeliveryMethodBeans dmb = DeliveryMethodDao.getDeliveryMethodDataBeansByID(deliverymethodid);
				session.setAttribute("dmb", dmb);

				//合計金額と配送料金の合計を表示
				String finalPrice = Helper.getFinalTotalPrice(show,deliverymethodid);
				session.setAttribute("test", finalPrice);


				//取得した支払いIDを使って支払い方法を取得
				PayMethodBeans pmb = PayMethodDao.getPayMethodDataBeansByID(paymethodid);
				session.setAttribute("pmb", pmb);

				//購入処理に必要な情報をセッションに保存、別サーブレットで処理。
				BuyHistryBeans bhb = new BuyHistryBeans();
				bhb.setId((int)session.getAttribute("userId"));
				bhb.setTotal_priceStr(finalPrice);
				bhb.setPay_method_id(paymethodid);
				bhb.setDelivery_method_id(deliverymethodid);

				session.setAttribute("bhb", bhb);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		System.out.println("購入の最終確認です。");
		request.getRequestDispatcher(Helper.REGISTER_CONFIRM_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			int paymethodid = Integer.parseInt(request.getParameter("pay_method"));
			int deliverymethodid = Integer.parseInt(request.getParameter("delivery_method"));
			ArrayList<CartBeans> show = (ArrayList<CartBeans>) session.getAttribute("show");

			//取得した配送IDを使って配送方法と値段を取得
			DeliveryMethodBeans dmb = DeliveryMethodDao.getDeliveryMethodDataBeansByID(deliverymethodid);
			session.setAttribute("dmb", dmb);

			//合計金額と配送料金の合計を表示
			String finalPrice = Helper.getFinalTotalPrice(show,deliverymethodid);
			session.setAttribute("test", finalPrice);


			//取得した支払いIDを使って支払い方法を取得
			PayMethodBeans pmb = PayMethodDao.getPayMethodDataBeansByID(paymethodid);
			session.setAttribute("pmb", pmb);

			//購入処理に必要な情報をセッションに保存、別サーブレットで処理。
			BuyHistryBeans bhb = new BuyHistryBeans();
			bhb.setUser_id((int)session.getAttribute("userId"));
			bhb.setTotal_priceStr(finalPrice);
			bhb.setPay_method_id(paymethodid);
			bhb.setDelivery_method_id(deliverymethodid);

			session.setAttribute("bhb", bhb);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	System.out.println("購入の最終確認です。");
	request.getRequestDispatcher(Helper.REGISTER_CONFIRM_PAGE).forward(request, response);
	}

}
