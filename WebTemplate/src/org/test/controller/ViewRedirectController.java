package org.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewRedirectController {
	
  @RequestMapping("/")
  public ModelAndView index() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/index");
    return mav;
  }
  
  @RequestMapping("/signin")
  public ModelAndView signin() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/login");
    return mav;
  }
  
  @RequestMapping("/query")
  public ModelAndView query() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/query");
    return mav;
  }
  
  @RequestMapping("encrypt/{data}")
	public ModelAndView getBlogContent(HttpServletRequest request, @PathVariable String data, String pk) {
		
  	System.out.println(pk);
  	String sessionID = request.getSession().getId();
  	ModelAndView mav = new ModelAndView();
  	mav.addObject("data", data);
  	mav.addObject("pk", pk);
  	mav.addObject("sessionID",sessionID);
	  mav.setViewName("/encrypt");
	  return mav;
		
	}
  
  @RequestMapping("encryptShow")
	public @ResponseBody String encryptShow(HttpServletRequest request,String data) {
  	
  	return data;
		
	}
  
  @RequestMapping("getEncryped")
	public @ResponseBody String getEncypted(HttpServletRequest request,String sessionID) {
  	
  	
	  return (String) request.getSession().getAttribute("encryped");
		
	}

}
