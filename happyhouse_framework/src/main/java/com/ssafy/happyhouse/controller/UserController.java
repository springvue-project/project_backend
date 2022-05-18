package com.ssafy.happyhouse.controller;

import java.time.LocalDate;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.ModifyPwdDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.UserService;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserService userService;

	/*************************************************************
	 ************************** 페이지 이동 **************************
	 **************************************************************/

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	// 로그아웃하면, index.jsp로 이동
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 마이페이지로 이동
	@GetMapping("/userinfo")
	public String userinfo() throws Exception {
//			ModelAndView mav = new ModelAndView();
//			UserDto UserDto = userService.searchById(userId);
//			mav.addObject("userDto", UserDto);
//			mav.setViewName();
		return "myPage";
	}

	// 비밀번호 찾기로 이동
	@GetMapping("/findpwd")
	public String findpwd() {
		return "findPwd";
	}

	// 비밀번호 수정으로 이동
	@GetMapping("/modifypwd")
	public String modifypwd() {
		return "modifyPwd";
	}
	
	/*************************************************************
	 ************************** 페이지 이동 fin ***********************
	 **************************************************************/
	
	//회원 등록
	@ResponseBody
	@PostMapping("/regist")
	public String register(@RequestBody UserDto userDto, Model model) throws Exception {
		userDto.setManager("user");
		userDto.setRegistDate(LocalDate.now().toString());
		logger.debug("userDto info : {}", userDto);
		userService.register(userDto);
		return SUCCESS;
	}

	@GetMapping("/idcheck")
	public @ResponseBody String idCheck(@RequestParam("ckid") String checkId) throws Exception {
		int idCount = userService.idCheck(checkId);
		JSONObject json = new JSONObject();
		json.put("idcount", idCount);
		return json.toString();
	}

	// 로그인
	@PostMapping("/login")
	public @ResponseBody String login(@RequestBody UserDto userDto, HttpSession session,
			HttpServletResponse response) throws Exception {
		logger.debug("map : {}", userDto);
		UserDto UserDto = userService.login(userDto);
		if (UserDto != null) {
			session.setAttribute("userInfo", UserDto);

//			Cookie cookie = new Cookie("ssafy_id", userDto.getUserId());
//			cookie.setPath("/");
//			if ("true".equals(map.get("idsave"))) {
//				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
//			} else {
//				cookie.setMaxAge(0);
//			}
//			response.addCookie(cookie);
			return SUCCESS;
		} else {			
			return FAIL;
		}
	}

	// 회원 삭제
	@DeleteMapping(value = "/delete/{userId}")
	public @ResponseBody String userDelete(@PathVariable String userId, HttpSession session) throws Exception {
		logger.debug("[delete] userId info : {}", userId);
		userService.deleteUser(userId);
		session.invalidate();

		JSONObject json = new JSONObject();
		json.put("status", "성공적으로 삭제.");
		return json.toString();
	}

	// 회원 수정
	@PutMapping(value = "/modify")
	public ResponseEntity<String> userModify(@RequestBody UserDto userDto, HttpSession session) throws Exception {
		System.out.println("수정");
		logger.debug("[modify] userDto info : {}", userDto.toString());
		userService.updateUser(userDto);

		if (userDto.getUserPwd() == null) {
			session.setAttribute("userInfo", userDto);
		}
		System.out.println("변경성공");
		return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
	}
	
	// 회원 조회
	@GetMapping(value="/detail/{userId}")
	public ResponseEntity<UserDto> userDetail(@PathVariable String userId) throws Exception{
		return new ResponseEntity<UserDto>(userService.searchById(userId), HttpStatus.OK);
	}

	// 비번찾기
	@PostMapping(value = "/findpwd/{userId}")
	public @ResponseBody String searchPwdById(@PathVariable String userId) throws Exception {
		logger.debug("[delete] userId info : {}", userId);
		String userPwd = userService.searchPwdById(userId);
		JSONObject json = new JSONObject();
		if (userPwd == null) {
			json.put("msg", "존재하지 않는 회원입니다.");
		} else {
			json.put("pwd", userPwd);
		}
		return json.toString();
	}
	
	//비번 수정
	@PutMapping(value = "/modifypwd")
	public ResponseEntity<String> modifyPwd(@RequestBody ModifyPwdDto modifyPwdDto ) throws Exception {
		logger.debug("[delete] userId info : {}", modifyPwdDto.getUserId());
		int result = userService.modifyPwd(modifyPwdDto);
		if(result==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}else if(result==0){
			return new ResponseEntity<String>(FAIL, HttpStatus.FORBIDDEN);
		}else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	// 알고리즘 프로젝트 추가
	@GetMapping("/sj")
	public String sj() throws Exception {
		return "apart_sj";
	}
	
	

}
