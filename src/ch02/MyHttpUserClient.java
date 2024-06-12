package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpUserClient {

	public static void main(String[] args) {

		// 순수 자바코드에서 HTTP 통신
		// 1. 서버 주소 경로
		// 2. URL 클래스
		// 3. url.openConnectio() <-- 스트림 I/O

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 서버 자원의 정보얻기 --> GET, 서버에 저장 --> POST
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);

			// HTTP 응답 메세지에서 데이터 추출 [] -- Stream -- []
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			System.out.println(buffer.toString());
			System.err.println("-----------------------------------------");

			// gson lib 활용
			// Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// toJson() -> 객체를 json 으로 , fromJson() -> json을 객체로
			User userDTO = gson.fromJson(buffer.toString(), User.class);

			System.out.println(userDTO.getId());
			System.out.println(userDTO.getName());
			System.out.println(userDTO.getUsername());
			System.out.println(userDTO.getEmail());
			System.out.println(userDTO.getAddress().getStreet());
			System.out.println(userDTO.getAddress().getSuite());
			System.out.println(userDTO.getAddress().getCity());
			System.out.println(userDTO.getAddress().getZipcode());
			System.out.println(userDTO.getAddress().getGeo().getLat());
			System.out.println(userDTO.getAddress().getGeo().getLng());
			System.out.println(userDTO.getPhone());
			System.out.println(userDTO.getWebsite());
			System.out.println(userDTO.getCompany().getName());
			System.out.println(userDTO.getCompany().getCatchPhrase());
			System.out.println(userDTO.getCompany().getBs());

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

}
