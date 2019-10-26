package cn.yan.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yan.weather.component.WeatherUtil;
import cn.yan.weather.properties.CityProperties;
import cn.yan.weather.properties.CityProperties.City;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherUtil weatherUtil;
	@Autowired
	private CityProperties cityProperties;
	
	@RequestMapping("/get")
	@Description("查询天气")
	public String get(String location){
		return weatherUtil.getWeather(location);
	}
	
	@RequestMapping("/getCities")
	@Description("获取城市列表")
	public List<City> getCities(){
		return cityProperties.getCities();
	}

}
