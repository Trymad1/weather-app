package com.trymad.weather_app;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.trymad.weather_app.model.entity.WeatherData;
import com.trymad.weather_app.model.service.WeatherDataService;
import com.trymad.weather_app.ui.MainFrame;

@SpringBootApplication
public class WeatherApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(WeatherApplication.class)
				.headless(false)
				.web(WebApplicationType.NONE)
				.run(args);

		SwingUtilities.invokeLater(() -> {
			JFrame test = context.getBean(MainFrame.class);
			test.setVisible(true);
		});

		var test = context.getBean(WeatherDataService.class);
		WeatherData forecast = test.getForecastData("Москва", 3, false, false);
		WeatherData history = test.getHistoryData("Москва", LocalDate.of(2024, 6, 15));
		System.out.println(forecast.isForecastData());
		System.out.println(history.isHistoryData());
	}
}
