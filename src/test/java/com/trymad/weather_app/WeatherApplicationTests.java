package com.trymad.weather_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.trymad.weather_app.ui.MainFrame;

@SpringBootTest(properties = {
		"java.awt.headless=true"
})

class WeatherApplicationTests {

	@MockBean
	MainFrame frame;

	@Test
	void contextLoads() {
	}

}
