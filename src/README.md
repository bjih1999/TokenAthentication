# Token 기반 인증 구현해보기
## Access Token, Refresh Token를 사용하여 인증 Flow 구현을 해보렵니다.
### 요구 사항
#### 기본
* login 엔드 포인트로 Credential 정보(ID, Password)를 전송하면 Access Token과 Refresh Token 반환
* Refresh Token은 DB에도 저장함
* Access Token을 요청에 포함시켜 인증 상태 확인
* Access Token이 만료된 경우 만료된 Access Token과 Refresh Token을 보내 Access Token 재발급
  * 서버에서 전송 받은 Refresh Token과 저장된 Refresh Token을 비교하여 일치하는 경우 Access Token을 재발급함
  * 일치하지 않는 경우 Access Token을 재발급하지 않음
#### sliding session
* Refresh Token을 통해 Access Token을 재발급 받는 경우 
 Refresh Token 또한 갱신하여 클라이언트에 전달하고 DB의 기존 Refresh Token에 덮어쓴다.
#### 중복 로그인 방지
* 로그인이 발생할 때마다 Refresh Token을 갱신하여 DB에 덮어쓴다.
* 기존 로그인 유저의 Access Token이 만료되어 Refresh Token을 DB의 것과 비교할 때
이미 신규 로그인 유저의 Refresh Token으로 변경되었기 때문에 신규 Access Token을 발급받지 못하여 기존 유저가 로그아웃 처리 된다.