package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.ApartDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.ApartService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class WebController {

   
   @Autowired
   private UserService memberService;
   
   @Autowired
   private ApartService apartService;
   
   @RequestMapping(value="/")
   public String index() {
      return "index";
   }
   
   @RequestMapping(value="/park")
	public String park() {
	    return "/parking/park";
	}
   
	
//	  @RequestMapping(value="/login") public String login() { return "user/login";
//	  }
//	  
//	  @RequestMapping(value="/logout") public String logout(HttpSession session) {
//	  System.out.println("efwefwefwefwef"); session.invalidate(); return
//	  "redirect:/"; }
//	  
//	  @GetMapping("/regist") public String register() { return "user/regist"; }
//	  
//	  @GetMapping("/idcheck") public @ResponseBody String
//	  idCheck(@RequestParam("ckid") String checkId) throws Exception { int idCount
//	  = memberService.idCheck(checkId); JSONObject json = new JSONObject();
//	  json.put("idcount", idCount); return json.toString(); }
//	  
//	  @PostMapping("/register") public String register(MemberDto memberDto, Model
//	  model) throws Exception { memberService.registerMember(memberDto); return
//	  "redirect:/login"; }
//	  
//	  @PostMapping("/login") public String login(@RequestParam Map<String, String>
//	  map, Model model, HttpSession session, HttpServletResponse response) throws
//	  Exception { System.out.println("로그인요청"); MemberDto memberDto =
//	  memberService.login(map); if (memberDto != null) {
//	  session.setAttribute("loginUser", memberDto);
//	  System.out.println(memberDto.toString());
//	  
//	  Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
//	  cookie.setPath("/"); if ("saveok".equals(map.get("idsave"))) {
//	  cookie.setMaxAge(60 * 60 * 24 * 365 * 40); } else { cookie.setMaxAge(0); }
//	  response.addCookie(cookie); return "index"; } else {
//	  model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!"); return
//	  "user/login"; } }
//	  
//	  @GetMapping(value = "/detail/{userid}") public ModelAndView
//	  userInfo(@PathVariable("userid") String userid) throws Exception {
//	  System.out.println("wefawefawe123123"); ModelAndView mav = new
//	  ModelAndView(); MemberDto memberDto = memberService.selectMember(userid);
//	  mav.addObject("userinfo", memberDto); mav.setViewName("user/detail"); return
//	  mav; }
//	  
//	  @GetMapping(value = "findPass") public String findPass() { return
//	  "user/findpass"; }
//	  
//	  @GetMapping(value ="/delete/{userid}") public String deleteView(HttpSession
//	  session,@PathVariable("userid") String userid) throws Exception {
//	  System.out.println(userid); memberService.deleteMember(userid);
//	  session.invalidate(); return "redirect:/"; }
	 
   
   @GetMapping("/search/{aptCode}/{aptName}")
	 //public ModelAndView userInfo(@RequestParam("aptCode") String aptCode, @RequestParam("aptName") String aptName) throws Exception {
	   public ModelAndView apartSearch(@PathVariable("aptCode") String aptCode, @PathVariable("aptName") String aptName) throws Exception {
	   		List<ApartDto> list = apartService.getApartList(Integer.parseInt(aptCode));
	      	ModelAndView mav = new ModelAndView();
	      	mav.addObject("list", list);
	      	mav.addObject("apartName", aptName);
	      	mav.setViewName("apart/apartDetail");
	      	return mav;
	   }
}