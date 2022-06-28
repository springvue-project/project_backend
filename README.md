# HappyHouse

## 프로젝트 개요

- 전국 아파트별 매매 정보(2015 ~ 2022)를 조회하고    
아파트별 주변 상권(부동산,주유소, 카페)정보와 전국 동별 주차장 정보를 제공합니다.

## 개발 환경

> BackEnd

- Java 1.8
- SpringBoot 2.6.7
- MyBatis 2.2.2

> FrontEnd

- node.js 16.15.0
- npm 8.5.5
- vue 2.6.14

## 주요기능

1. 아파트 매매 정보 조회

- 전국 행정동별 아파트 조회      
   :heavy_check_mark:`시도/시구군/동 을 선택하면 해당 행정동의 아파트 리스트가 보이고 지도상에 아파트의 위치가 표시됩니다.`    
   :heavy_check_mark:`지도위의 마커를 클릭하면 해당 위치의 아파트 정보를 볼 수 있습니다.`    
- 아파트별 매매 정보 조회    
  - 거래금액, 거래연도, 면적, 층
- 아파트별 주변 상권 조회      
  :heavy_check_mark:`아파트 이름의 클릭하면 아파트 2015~2022년도의 아파트 매매 정보를 조회할 수 있습니다.`      
  :heavy_check_mark:`아파트 좌측의 아이콘을 통해 각 상권 정보를 조회할 수 있고 지도에서 위치를 확인할 수 있습니다.`    
  - 상권 : 부동산, 카페, 주유소
- 관심 아파트 등록/해제      
  :heavy_check_mark:`🖤 아이콘 클릭으로 해당 아파트를 관심 아파트로 등록/해제 할 수 있습니다.`    

2. 마커 주변 아파트 조회

- 선호하는/자주가는 지역 선택(5곳 이하)      
  :heavy_check_mark:`지도 상에서 선호하는/자주가는 지역을 선택하면 마커가 표시되고 선택한 위치의 주소 리스트가 보여집니다.`
- 선택한 마커로 계산한 중심 지점 주변 아파트 정보 제공
  - 반경 500m 이내
- 아파트별 매매 정보 조회
- 아파트별 주변 상권 조회
- 관심 아파트 등록/해제

3. 주차장 정보 조회
  :heavy_check_mark:`시도/시구군/동 을 선택하면 해당 행정동의 주차장 정보를 제공합니다.`    
  :heavy_check_mark:`주차장을 선택하면 세부 정보를 확인할 수 있습니다.`    
  :heavy_check_mark:`지도 위의 교통정보 토글버튼은 통해 실시간 교통 정보를 확인할 수 있습니다.`    

4. QnA 게시판

- 게시물 등록/수정/삭제
- 댓글 등록/삭제
