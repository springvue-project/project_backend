package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.ApartDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.LatLngParamDto;
import com.ssafy.happyhouse.model.ParamsForSearchAptDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;


@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class HouseMapController {
   
   private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	//Controller
   @Autowired
   private HouseMapService haHouseMapService;
   
   @GetMapping("/sido")
   public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
      logger.debug("sido : {}", haHouseMapService.getSido());
      return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
   }
   
   @GetMapping("/gugun")
   public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
      return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
   }
   
   @GetMapping("/dong")
   public ResponseEntity<List<SidoGugunCodeDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
      return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
   }
   
   @GetMapping("/apt")
   public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
      haHouseMapService.getlatlng(dong);
      return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
   }
   
   @GetMapping("/aptdeal")
   public ResponseEntity<List<ApartDto>> aptdeal(@RequestParam("aptCode") String aptCode) throws Exception {
      return new ResponseEntity<List<ApartDto>>(haHouseMapService.getAptDeal(aptCode), HttpStatus.OK);
   }
   

   @GetMapping("/type")
   public ResponseEntity<List<HouseInfoDto>> aptsort(@RequestParam("dong") String dong, @RequestParam("type") int type) throws Exception {
      return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDongSortDistance(dong, type), HttpStatus.OK);
   }
   
	@GetMapping("/aroundapt")
	public ResponseEntity<List<HouseInfoDto>> getApt(@RequestParam("lat") String lat, @RequestParam("lng") String lng) throws SQLException {
		LatLngParamDto latlng = new LatLngParamDto(lat, lng, "1");
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.searchBestApt(latlng),HttpStatus.OK);
	}
	
}