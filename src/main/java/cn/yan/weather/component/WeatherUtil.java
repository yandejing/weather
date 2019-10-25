package cn.yan.weather.component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherUtil {

	@Value("${hf.key}")
	private String key;

	public String getWeather(String location) {
		String param = "key=" + key + "&location=" + location;
		StringBuilder sb = new StringBuilder();
		InputStream is = null;
		BufferedReader br = null;
		PrintWriter out = null;
		try {
			String url = "https://free-api.heweather.net/s6/weather/now";
			URL uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			connection.setRequestMethod("POST");
			connection.setReadTimeout(5000);
			connection.setConnectTimeout(10000);
			connection.setRequestProperty("accept", "*/*");
			// 发送参数
			connection.setDoOutput(true);
			out = new PrintWriter(connection.getOutputStream());
			out.print(param);
			out.flush();
			// 接收结果
			is = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			return sb.toString();
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (br != null) {
					br.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception ignored) {
			}
		}
	}

}
