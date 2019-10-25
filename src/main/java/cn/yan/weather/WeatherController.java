package cn.yan.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yan.weather.component.WeatherUtil;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherUtil weatherUtil;
	
	@RequestMapping("/get")
	public String get(String location){
		return weatherUtil.getWeather(location);
//		return "123";
	}

}
