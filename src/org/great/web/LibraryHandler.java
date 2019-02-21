package org.great.web;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.great.biz.LibraryBiz;
import org.great.entity.Library;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/library")
public class LibraryHandler {
	
	@Resource
	LibraryBiz libraryBiz;
	
	@RequestMapping("/findAllLibrary.action")
	public ModelAndView findAllLibrary() {
		List<Library> libraryList = libraryBiz.findAllLibrary();
		ModelAndView mav = new ModelAndView();
		mav.addObject("libraryList",libraryList);
		mav.setViewName("library_search");
		return mav;
	}
	
	@RequestMapping("/updateLibraryThreshold.action")
	@ResponseBody
	public String updateLibraryThreshold(int library_id,String library_threshold) {
		String message = "no";
		int ret = libraryBiz.updateLibraryThreshold(library_threshold, library_id);
		if(ret>0) {
			message = "yes";
		}
		
		return message;
	}
	
}
