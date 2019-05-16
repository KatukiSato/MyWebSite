package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TagDao;

/**
 * Servlet implementation class TagUpdateSuccess
 */
@WebServlet("/TagUpdateSuccess")
public class TagUpdateSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TagUpdateSuccess() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");

		String tagUpdate = request.getParameter("update_button");

		//修正と登録ボタンの棲み分けの処理
		switch (tagUpdate) {
		case "correction":
			session.getAttribute("tagName");
			response.sendRedirect("TagUpdate");
		break;

		case "update":
			String newTagSuccess =(String) session.getAttribute("newTag");
			int tagid = Integer.parseInt( request.getParameter("tagId"));

			try {
				TagDao.updateTag(newTagSuccess, tagid);
				System.out.println("タグの名前が変わりました。");
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			request.getRequestDispatcher(Helper.TAG_UPDATE_SUCCESS_PAGE).forward(request, response);
		}
	}
}
