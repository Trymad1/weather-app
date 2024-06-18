package com.trymad.weather_app.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MainFrame extends JFrame {

  private final JTextField cityTextField;
  private final JButton cityFindButton;
  private final JLabel cityNameLabel;

  public MainFrame(Environment environment) {

    final Dimension windowSize = getWindowDimension(environment);
    setSize(windowSize);
    setLayout(null);
    setResizable(false);
    setLocationRelativeTo(null);

    cityTextField = new JTextField();
    cityFindButton = new JButton("=>");
    cityNameLabel = new JLabel();

    cityTextField.setBounds(5, 5, 250, 30);
    cityFindButton.setBounds(255, 5, 60, 29);
    cityNameLabel.setBounds(5, 50, 400, 40);

    cityTextField.setFont(new Font("Fira Code", Font.PLAIN, 20));
    cityFindButton.setFont(new Font("Fira Code", Font.PLAIN, 15));
    cityNameLabel.setFont(new Font("Fira Code", Font.BOLD, 25));

    getRootPane().setDefaultButton(cityFindButton);
    Action findButtonPressedAction = new AbstractAction() {

      @Override
      public void actionPerformed(ActionEvent e) {
        cityNameLabel.setText(cityTextField.getText());
      }

    };

    cityFindButton.addActionListener(findButtonPressedAction);

    getContentPane().add(cityTextField);
    getContentPane().add(cityFindButton);
    getContentPane().add(cityNameLabel);

  }

  private Dimension getWindowDimension(Environment env) {
    return new Dimension(
        Integer.valueOf(env.getProperty("application.view.window.width")),
        Integer.valueOf(env.getProperty("application.view.window.height")));
  }
}
