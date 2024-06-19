package com.trymad.weather_app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.formdev.flatlaf.FlatDarkLaf;
import com.trymad.weather_app.model.service.WeatherUpdator;
import com.trymad.weather_app.ui.MainFrame;

@SpringBootApplication
public class WeatherApplication {

	private final static String START_CITY_FOR_DISPLAY = "Алчевск";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(WeatherApplication.class)
				.headless(false)
				.web(WebApplicationType.NONE)
				.run(args);

		FlatDarkLaf.setup();
		SwingUtilities.invokeLater(() -> {
			JFrame mainFrame = context.getBean(MainFrame.class);
			WeatherUpdator weatherUpdator = context.getBean(WeatherUpdator.class);
			weatherUpdator.getWeatherInformation(START_CITY_FOR_DISPLAY);
			mainFrame.setVisible(true);

		});
	}
}
