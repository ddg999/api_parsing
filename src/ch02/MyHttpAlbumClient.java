package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpAlbumClient {

	public static void main(String[] args) {

		// 순수 자바코드에서 HTTP 통신
		// 1. 서버 주소 경로
		// 2. URL 클래스
		// 3. url.openConnectio() <-- 스트림 I/O

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums/1");
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
			Album albumDTO = gson.fromJson(buffer.toString(), Album.class);

			System.out.println(albumDTO.getId());
			System.out.println(albumDTO.getUserId());
			System.out.println(albumDTO.getTitle());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
