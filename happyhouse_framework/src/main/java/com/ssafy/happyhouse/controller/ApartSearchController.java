package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.ParamsForSearchAptDto;
import com.ssafy.happyhouse.model.service.ApartSearchByNameService;

@Controller
@RequestMapping("/apart")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class ApartSearchController {

	@Autowired
	private ApartSearchByNameService aptsearchservcie;
	
	@GetMapping("/searchName")
	public ResponseEntity<List<HouseInfoDto>> getApt(@RequestParam("dongCode") String dongCode,@RequestParam("aptName") String aptName) throws SQLException {
		System.out.println(aptName);
		ParamsForSearchAptDto dto = new ParamsForSearchAptDto(aptName,dongCode);
		System.out.println(aptsearchservcie.getApartSearchByNameList(dto).toString());
		return new ResponseEntity<List<HouseInfoDto>>(aptsearchservcie.getApartSearchByNameList(dto),HttpStatus.OK);
	}
}
