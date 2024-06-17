package com.trymad.weather_app.model;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

@Component
public class MainFrame extends JFrame {

  public MainFrame() {
    setSize(300, 300);
  }
}
