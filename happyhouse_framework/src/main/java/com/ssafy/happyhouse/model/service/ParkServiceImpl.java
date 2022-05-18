package com.ssafy.happyhouse.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.ParkDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;	

@Service
public class ParkServiceImpl implements ParkService {
	private HouseMapServiceImpl house = new HouseMapServiceImpl();
	@Autowired
	private HouseMapMapper houseMapMapper;
	
	@Override
	public List<ParkDto> parkFromDong(String dong) throws Exception {
		// TODO Auto-generated method stub
		return getAPI(dong);
	}
	
	public List<ParkDto> getAPI(String dong) throws Exception {
		// 지역5자리. 2(광역시/도) + 3(시군구) 50개 데이터로 위도/경도 받아서 실거리계산후 어느 거리 범위까지해서 주차공간 포함시키는
		// 서울시 종로구 (35, 50)   JSON 50개 좌표 int[50][2]
		
		String Key = "=3YoGT1R72EiBYd%2Br9Dfw2x9wfhPzZsCWvBeODEn%2B5fXWSamYcCONA0l%2F3dKVQ0%2Bpa2%2Fh3cWVz0Urj2m5jjMOow%3D%3D";
		StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15050093/v1/uddi:d19c8e21-4445-43fe-b2a6-865dff832e08"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "="+ URLEncoder.encode("1", "UTF-8")); 		/*페이지 수*/
		urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "=" + URLEncoder.encode("50", "UTF-8"));	/*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("cond[지역코드::EQ]", "UTF-8") + "=" + URLEncoder.encode(dong.substring(0, 5), "UTF-8"));	/*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + Key); /*Service Key*/
        System.out.println(urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        List<ParkDto> list = new ArrayList<ParkDto>();
        JSONParser jsonParser = new JSONParser();
      //JSON데이터를 넣어 JSON Object 로 만들어 준다.
        JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
        System.out.println("wef");
        //books의 배열을 추출
        JSONArray array = (JSONArray) jsonObject.get("data");
        for (int i = 0; i < array.size(); i++) {
        	JSONObject data = (JSONObject) array.get(i);
        	ParkDto parkDto = new ParkDto(data.get("주차장명").toString(), 
        			 					  data.get("주차장도로명주소").toString(), 
        			 					  data.get("주차장구분").toString(), 
        			 					  data.get("요금정보").toString(), 
        			 					  Integer.parseInt(data.get("주차구획수").toString()),
        			 					  data.get("위도").toString(), 
        			 					  data.get("경도").toString(), 
        			 					  data.get("연락처").toString());
        	
        	//배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
            System.out.println(parkDto.toString());
            list.add(parkDto);
        }
        return distanceCal(list, dong);
	}
	
	public List<ParkDto> distanceCal(List<ParkDto> inputlist, String dong) throws Exception {
		PriorityQueue<distance> pq = new PriorityQueue<>();
		List<ParkDto> list = inputlist;
	    System.out.println(list.size());
	         //베이스 (기준위치의 위도, 경도)
	         double baseaddress_lng = 0;
	         double baseaddress_lat = 0;
	         double destination_lng = 0;
	         double destination_lat = 0;
	         double distance = 0;
	         System.out.println(dong);
	         baseaddress_lng = Double.parseDouble(houseMapMapper.getlatlng(dong).get("lng"));
	         baseaddress_lat = Double.parseDouble(houseMapMapper.getlatlng(dong).get("lat"));


	         System.out.println(baseaddress_lng);
	         System.out.println(baseaddress_lat);
	         System.out.println(destination_lng);
	         System.out.println(destination_lng);

	         for(int i=0; i<list.size(); i++) {
	            destination_lng = Double.parseDouble(list.get(i).getLng());
	            destination_lat = Double.parseDouble(list.get(i).getLat());   
	            System.out.println(destination_lng + " " + destination_lat);
	            distance = house.distance(baseaddress_lat, baseaddress_lng, destination_lat, destination_lng,"kilometer");
	            System.out.println(distance);
	            if (distance < 2)
	            	pq.add(new distance(distance, list.get(i)));
	         }

	         list.clear();

	         int cycle = pq.size();
	         for(int i=0; i<cycle; i++) {
	            list.add(pq.poll().dto);
	         }
	         System.out.println("사이즈 전");
	         System.out.println(list.size());
	         System.out.println(list.toString());
	         return list;
	      
	}
}

class distance implements Comparable<distance>{
	   double distance;
	   ParkDto dto;

	   public distance(double distance, ParkDto dto) {
	      super();
	      this.distance = distance;
	      this.dto = dto;
	   }

	   @Override
	   public int compareTo(distance o) {
	      return (int) (this.distance-o.distance);
	   }
	}