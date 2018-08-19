package com.txz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.txz.Bean.cityBean;
import com.txz.dao.CityDao;
import com.txz.dao.impl.CityDaoImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class cityServlet
 */
@WebServlet("/cityServlet")
public class cityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String lx = request.getParameter("lx");
		/**
		 * lx=xml 将返回xml数据 lx=json 将返回json数据
		 */

		if (lx.equals("xml") && lx != null) {
			System.out.println(1);
			try {
				CityDao dao = new CityDaoImpl();
				List<cityBean> list = dao.findCityByPid(pid);

				// 把list 集合对象转化为xml 格式,返回给ajax

				XStream xs = new XStream();
				// <com.txz.Bean.cityBean> 替换成 city
				xs.alias("citys", cityBean.class);

				String list_xml = xs.toXML(list);

				System.out.println(list_xml);
				// 告诉浏览器返回的格式是xml,编码是utf-8 ;将结果返回
				response.setContentType("text/xml;charset=utf-8");
				response.getWriter().write(list_xml);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		else if (lx.equals("json")) {
			try {
				CityDao dao = new CityDaoImpl();
				List<cityBean> list = dao.findCityByPid(pid);
				// System.out.println(list.toString());
				// 3. 把list ---> json数据
				JSONArray array = JSONArray.fromObject(list);
				  System.out.println(array.toString());
				
				response.setContentType("text/html;charset=utf-8");
				 response.getWriter().write(array.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
