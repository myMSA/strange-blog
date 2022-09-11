//package com.blog.strange.member;
//
//import java.util.HashMap;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.eveadam.blog.dto.member.MemberDTO;
//import com.eveadam.blog.service.member.MemberService;
//
//import lombok.extern.log4j.Log4j;
//
//
//@Log4j
//@Controller
//public class MemberController {
//
//	@Autowired
//    private MemberService MemberService;
//
//	@RequestMapping(value = "/kakaoLogin", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public HashMap<String, String> kakaoLogin(MemberDTO memberDTO) throws Exception {
//		//
//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		HttpServletRequest request = attr.getRequest();
//    	HttpServletResponse response = attr.getResponse();
//
//		HttpSession session= request.getSession(false);
//		session.setAttribute("member", memberDTO);
//		//
//		MemberService.insertMember(memberDTO);
//		//
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("loginSuccess", "True");
//
//		return map;
//	}
//
//	@RequestMapping(value = "/sessionInval", method = RequestMethod.GET)
//	public String home3(Locale locale, Model model) {
//
//		return "sessionInval";
//	}
//
//
//}
