package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.MessageDao;

public class servletAsk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//获取本地最新的聊天记录的ID --- finalMessaged
		String finalMessageId = request.getParameter("finalMessageId");
		//根据finalMessageId查询是否有最新的聊天记录
		MessageDao messageDao = new MessageDao();
		boolean hasNew = messageDao.hasNew(finalMessageId);
		//将布尔类型的返回值以ajax响应的形式返回给浏览器
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(hasNew+"");//布尔类型转字符串，直接加上空
	}


}
