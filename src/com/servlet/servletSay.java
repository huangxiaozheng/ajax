package com.servlet;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Message;
import com.Dao.MessageDao;
public class servletSay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		//接收从前台传过来的聊天记录
		String msg = request.getParameter("message");
		Message message = new Message(null, msg, new Date());
		
		//将聊天记录保存到数据库中
		MessageDao messageDao = new MessageDao();
		messageDao.saveMessage(message);
		
	
	}


}
