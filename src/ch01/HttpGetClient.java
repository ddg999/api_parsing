package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class HttpGetClient {

	public static void main(String[] args) {
		int count = 0;

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			// HTTP 응답 메세지에서 데이터를 추출할 수 있다
			int statusCode = conn.getResponseCode();
//			System.out.println("HTTP CODE : " + statusCode); // 200: 통신ㅇ / 404 : 통신X
			if (statusCode == 200) {
				BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;

				StringBuffer responseBuffer = new StringBuffer();

				while ((inputLine = brIn.readLine()) != null) {
					responseBuffer.append(inputLine);
				}

				String str2 = responseBuffer.toString();
				Gson gson2 = new Gson();
				User[] userArr = gson2.fromJson(str2, User[].class);
				for (int i = 0; i < userArr.length; i++) {
					System.out.println("userId : " + userArr[i].getUserId());
					System.out.println("id : " + userArr[i].getId());
					System.out.println("title : " + userArr[i].getTitle());
					System.out.println("completed : " + userArr[i].isCompleted());
					System.out.println();
					if (userArr[i].getUserId() == 10) {
						count++;
					}
				}
				System.out.println(count);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
