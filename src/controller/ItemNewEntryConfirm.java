package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.ItemBeans;

/**
 * Servlet implementation class ItemNewEntryConfirm
 */
@WebServlet("/ItemNewEntryConfirm")
@MultipartConfig(location="/org", maxFileSize=1048576)
public class ItemNewEntryConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemNewEntryConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

        Part part = request.getPart("img");
        String img = this.getFileName(part);
        part.write(getServletContext().getRealPath("/img") + "/" + img);

        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        int price =Integer.parseInt(request.getParameter("price"));

        ItemBeans ib = new ItemBeans();
        ib.setName(name);
        ib.setDetail(detail);
        ib.setPrice(price);
        ib.setFileName(img);

        session.setAttribute("newItem", ib);

		request.getRequestDispatcher(Helper.ITEM_NEW_ENTRY_CONFIEM_PAGE).forward(request, response);
//        response.sendRedirect("sampleupload");
	}

     String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
