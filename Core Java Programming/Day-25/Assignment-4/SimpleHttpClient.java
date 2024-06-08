package Day_25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttpClient {

	public static void main(String[] args) {
		String urlString = "http://example.com";
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			System.out.println("Response Code: " + connection.getResponseCode());
			System.out.println("Response Headers:");
			connection.getHeaderFields().forEach((k, v) -> System.out.println(k + ": " + v));
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			connection.disconnect();
			System.out.println("Response Body:");
			System.out.println(content.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}