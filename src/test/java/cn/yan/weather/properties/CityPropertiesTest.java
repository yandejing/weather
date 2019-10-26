package cn.yan.weather.properties;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yan.weather.properties.CityProperties.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityPropertiesTest {

	@Autowired
	private CityProperties cityProperties;

	@Before
	public void setup() {
	}

	@Test
	public void testGetCities() throws Exception {
		List<City> cities = cityProperties.getCities();
		for (City city : cities) {
			System.out.println(city.getName());
		}
	}
}
