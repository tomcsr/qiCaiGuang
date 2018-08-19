package com.txz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txz.Bean.wordBean;
import com.txz.dao.WordDao;
import com.txz.dao.impl.WordDaoImpl;

/**
 * Servlet implementation class wordServlet
 */
@WebServlet("/wordServlet")
public class wordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 String word=request.getParameter("word");
			 WordDao dao=new WordDaoImpl();
			List<wordBean> list = dao.findWord(word);
			request.setAttribute("list", list);
			request.getRequestDispatcher("word.jsp").forward(request, response);
		} catch (SQLException e) {			 
			e.printStackTrace();
		}
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
