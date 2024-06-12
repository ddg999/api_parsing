package ch01;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class client {

	public static void main(String[] args) throws IOException {

		URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(null);
		conn.setRequestProperty("Content-type", "application/json");
	}
}
