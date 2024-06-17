package com.trymad.weather_app.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MainFrame extends JFrame {

  public MainFrame(Environment environment) {
    final Dimension windowSize = getWindowDimension(environment);
    setSize(windowSize);
  }

  private Dimension getWindowDimension(Environment env) {
    return new Dimension(
        Integer.valueOf(env.getProperty("application.view.window.width")),
        Integer.valueOf(env.getProperty("application.view.window.height")));
  }
}
