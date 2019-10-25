package cn.yan.weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherControlerTest {

	@Autowired
	private WeatherController weatherController;

	@Before
	public void setup() {
	}

	@Test
	public void testGetWeather() throws Exception {
		System.out.println(weatherController.get("北京"));
	}

}
