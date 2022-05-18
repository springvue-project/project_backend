package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {

   @Autowired
   private HouseMapMapper houseMapMapper;

   @Override
   public List<SidoGugunCodeDto> getSido() throws Exception {
      return houseMapMapper.getSido();
   }

   @Override
   public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
      return houseMapMapper.getGugunInSido(sido);
   }

   @Override
   public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
      return houseMapMapper.getDongInGugun(gugun);
   }

   // 밑에 오버라이드 2개 작업 끝나면 지워도 됨
   @Override
   public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
      // 현재 동 코드 기준으로 해당 동의 위도, 경도 좌표를 읽어들임 
      // select lat, lng from baseaddress where dongcode = dong
      //double[2] xy = houseMapper.getxy(dong);

      List<HouseInfoDto> list = null;
      list = houseMapMapper.getAptInDong(dong);
      System.out.println(list.toString());
      // 
      return list;
   }


   @Override
   public List<HouseInfoDto> getAptInDongSortDistance(String dong, int type) throws Exception {
      PriorityQueue<distanceWithDto> pq = new PriorityQueue<>();
      List<HouseInfoDto> list = null;
      list = houseMapMapper.getAptInDong(dong);
      System.out.println(list.size());
      if(type == 1) {
         return list;
      }else {
         //베이스 (기준위치의 위도 ,겨오=뎌
         double baseaddress_lng = 0;
         double baseaddress_lat = 0;
         double destination_lng = 0;
         double destination_lat = 0;
         double distance = 0;

         baseaddress_lng = Double.parseDouble(houseMapMapper.getlatlng(dong).get("lng"));
         baseaddress_lat = Double.parseDouble(houseMapMapper.getlatlng(dong).get("lat"));


         System.out.println(baseaddress_lng);
         System.out.println(baseaddress_lat);
         System.out.println(destination_lng);
         System.out.println(destination_lng);

         for(int i=0; i<list.size(); i++) {
            destination_lng = Double.parseDouble(list.get(i).getLng());
            destination_lat = Double.parseDouble(list.get(i).getLat());   

            distance = distance(baseaddress_lat, baseaddress_lng, destination_lat, destination_lng,"kilometer");

            pq.add(new distanceWithDto(distance, list.get(i)));
         }

         list.clear();

         int cycle = pq.size();
         for(int i=0; i<cycle; i++) {
            list.add(pq.poll().dto);
         }

         System.out.println(list.toString());
         return list;
      }
   }

   @Override
   public Map<String, String> getlatlng(String dong) throws Exception {
      // TODO Auto-generated method stub
      Map<String, String> map = houseMapMapper.getlatlng(dong);
      System.out.println(map);
      return houseMapMapper.getlatlng(dong);
   }

   public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;

      if (unit == "kilometer") {
         dist = dist * 1.609344;
      } else if(unit == "meter"){
         dist = dist * 1609.344;
      }

      return (dist);
   }


   // This function converts decimal degrees to radians
   public static double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
   }

   // This function converts radians to decimal degrees
   public static double rad2deg(double rad) {
      return (rad * 180 / Math.PI);
   }

}
class distanceWithDto implements Comparable<distanceWithDto>{
   double distance;
   HouseInfoDto dto;

   public distanceWithDto(double distance, HouseInfoDto dto) {
      super();
      this.distance = distance;
      this.dto = dto;
   }

   @Override
   public int compareTo(distanceWithDto o) {
      return (int) (this.distance-o.distance);
   }
}