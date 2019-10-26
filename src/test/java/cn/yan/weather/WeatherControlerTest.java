package cn.yan.weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherControlerTest {

	@Autowired
	private WeatherController weatherController;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(weatherController).build();
	}

	@Test
	public void testGetWeather() throws Exception {
		System.out.println(weatherController.get("北京"));
	}

	@Test
	public void testGetCities() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/weather/getCities").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())//
		.andDo(MockMvcResultHandlers.print())//
		.andReturn();
	}

}
