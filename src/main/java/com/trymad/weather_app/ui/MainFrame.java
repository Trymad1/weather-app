package com.trymad.weather_app.ui;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class MainFrame extends JFrame {

    private javax.swing.JButton cityFindButton;
    private javax.swing.JTextField cityFindTextField;
    private javax.swing.JLabel cityNameLabel;
    private javax.swing.JLabel cityYesterdayTemperatureLabel;
    private javax.swing.JLabel cityYesterdayTimeInfoLabel;
    private javax.swing.JPanel currentWeatherPanel;
    private javax.swing.JTextArea forecastConditionDay1;
    private javax.swing.JTextArea forecastConditionDay2;
    private javax.swing.JScrollPane forecastConditionPaneDay1;
    private javax.swing.JScrollPane forecastConditionPaneDay2;
    private javax.swing.JScrollPane forecastConditionPaneDay3;
    private javax.swing.JTextArea forecastCondititonDay3;
    private javax.swing.JLabel forecastDateDay1;
    private javax.swing.JLabel forecastDateDay2;
    private javax.swing.JLabel forecastDateDay3;
    private javax.swing.JPanel forecastDaysPanel;
    private javax.swing.JLabel forecastFeelTemperatureDay1;
    private javax.swing.JLabel forecastFeelTemperatureDay2;
    private javax.swing.JLabel forecastFeelTemperatureDay3;
    private javax.swing.JLabel forecastImageDay1;
    private javax.swing.JLabel forecastImageDay2;
    private javax.swing.JLabel forecastImageDay3;
    private javax.swing.JScrollPane forecastMain;
    private javax.swing.JPanel forecastMainPanel;
    private javax.swing.JPanel forecastPanelDay1;
    private javax.swing.JPanel forecastPanelDay2;
    private javax.swing.JPanel forecastPanelDay3;
    private javax.swing.JLabel forecastTemperatureDay1;
    private javax.swing.JLabel forecastTemperatureDay2;
    private javax.swing.JLabel forecastTemperatureDay3;
    private javax.swing.JLabel forecastWeekendDay1;
    private javax.swing.JLabel forecastWeekendDay2;
    private javax.swing.JLabel forecastWeekendDay3;
    private javax.swing.JPanel mainWeatherPanel;
    private javax.swing.JLabel temperatureFeelsLabel;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JLabel waterImageLabel;
    private javax.swing.JLabel waterPercentsLabel;
    private javax.swing.JLabel weatherFeelsInfoLabel;
    private javax.swing.JLabel weatherImageLabel1;
    private javax.swing.JLabel weatherInfoLabel;
    private javax.swing.JLabel windImageLabel;
    private javax.swing.JLabel windInfoLabel;

    private final String WIND_IMAGE_PATH = "static/image/wind.png";
    private final String WATER_IMAGE_PATH = "static/image/water.png";
    private final String TEST_IMAGE_PATH = "static/image/test.png";

    public MainFrame(Environment environment) throws IOException {
        initComponents();
        setSize(getWindowDimension(environment));
    }

    private void initComponents() throws IOException {

        mainWeatherPanel = new javax.swing.JPanel();
        cityFindTextField = new javax.swing.JTextField();
        cityFindButton = new javax.swing.JButton();
        currentWeatherPanel = new javax.swing.JPanel();
        windImageLabel = new javax.swing.JLabel();
        windInfoLabel = new javax.swing.JLabel();
        waterPercentsLabel = new javax.swing.JLabel();
        waterImageLabel = new javax.swing.JLabel();
        temperatureLabel = new javax.swing.JLabel();
        weatherImageLabel1 = new javax.swing.JLabel();
        weatherInfoLabel = new javax.swing.JLabel();
        weatherFeelsInfoLabel = new javax.swing.JLabel();
        cityYesterdayTimeInfoLabel = new javax.swing.JLabel();
        cityYesterdayTemperatureLabel = new javax.swing.JLabel();
        cityNameLabel = new javax.swing.JLabel();
        temperatureFeelsLabel = new javax.swing.JLabel();
        forecastMain = new javax.swing.JScrollPane();
        forecastMainPanel = new javax.swing.JPanel();
        forecastDaysPanel = new javax.swing.JPanel();
        forecastPanelDay3 = new javax.swing.JPanel();
        forecastImageDay3 = new javax.swing.JLabel();
        forecastTemperatureDay3 = new javax.swing.JLabel();
        forecastFeelTemperatureDay3 = new javax.swing.JLabel();
        forecastDateDay3 = new javax.swing.JLabel();
        forecastWeekendDay3 = new javax.swing.JLabel();
        forecastConditionPaneDay3 = new javax.swing.JScrollPane();
        forecastCondititonDay3 = new javax.swing.JTextArea();
        forecastPanelDay2 = new javax.swing.JPanel();
        forecastImageDay2 = new javax.swing.JLabel();
        forecastTemperatureDay2 = new javax.swing.JLabel();
        forecastFeelTemperatureDay2 = new javax.swing.JLabel();
        forecastDateDay2 = new javax.swing.JLabel();
        forecastWeekendDay2 = new javax.swing.JLabel();
        forecastConditionPaneDay2 = new javax.swing.JScrollPane();
        forecastConditionDay2 = new javax.swing.JTextArea();
        forecastPanelDay1 = new javax.swing.JPanel();
        forecastImageDay1 = new javax.swing.JLabel();
        forecastTemperatureDay1 = new javax.swing.JLabel();
        forecastFeelTemperatureDay1 = new javax.swing.JLabel();
        forecastDateDay1 = new javax.swing.JLabel();
        forecastWeekendDay1 = new javax.swing.JLabel();
        forecastConditionPaneDay1 = new javax.swing.JScrollPane();
        forecastConditionDay1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cityFindTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cityFindButton.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cityFindButton.setText("=>");

        currentWeatherPanel
                .setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        currentWeatherPanel.setPreferredSize(new java.awt.Dimension(475, 390));

        windImageLabel.setIcon(
                new javax.swing.ImageIcon(getImageResouce(WIND_IMAGE_PATH).getURL())); // NOI18N

        weatherImageLabel1.setIcon(
                new javax.swing.ImageIcon(getImageResouce(TEST_IMAGE_PATH).getURL()));

        windInfoLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        windInfoLabel.setText("16,2 м/c, СЗ");

        waterPercentsLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        waterPercentsLabel.setText("100%");

        waterImageLabel.setIcon(
                new javax.swing.ImageIcon(getImageResouce(WATER_IMAGE_PATH).getURL())); // NOI18N

        temperatureLabel.setFont(new java.awt.Font("sansserif", 0, 40)); // NOI18N
        temperatureLabel.setText("+26°");
        temperatureLabel.setToolTipText("");

        weatherInfoLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        weatherInfoLabel.setText("Облачно с прояснениями");

        weatherFeelsInfoLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        weatherFeelsInfoLabel.setForeground(new java.awt.Color(102, 102, 102));
        weatherFeelsInfoLabel.setText("Ощущается как");

        cityYesterdayTimeInfoLabel.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        cityYesterdayTimeInfoLabel.setForeground(new java.awt.Color(102, 102, 102));
        cityYesterdayTimeInfoLabel.setText("Сейчас 13:16. Вчера в это время");

        cityYesterdayTemperatureLabel.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        cityYesterdayTemperatureLabel.setForeground(new java.awt.Color(51, 51, 51));
        cityYesterdayTemperatureLabel.setText("15°");

        cityNameLabel.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        cityNameLabel.setText("Санкт-петербург");
        cityNameLabel.setPreferredSize(new java.awt.Dimension(275, 50));

        temperatureFeelsLabel.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        temperatureFeelsLabel.setForeground(new java.awt.Color(51, 51, 51));
        temperatureFeelsLabel.setText("+28°");

        forecastMain.setBorder(null);
        forecastMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        forecastMainPanel.setPreferredSize(new java.awt.Dimension(1820, 145));

        javax.swing.GroupLayout forecastMainPanelLayout = new javax.swing.GroupLayout(forecastMainPanel);
        forecastMainPanel.setLayout(forecastMainPanelLayout);
        forecastMainPanelLayout.setHorizontalGroup(
                forecastMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1820, Short.MAX_VALUE));
        forecastMainPanelLayout.setVerticalGroup(
                forecastMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 145, Short.MAX_VALUE));

        forecastMain.setViewportView(forecastMainPanel);

        javax.swing.GroupLayout currentWeatherPanelLayout = new javax.swing.GroupLayout(currentWeatherPanel);
        currentWeatherPanel.setLayout(currentWeatherPanelLayout);
        currentWeatherPanelLayout.setHorizontalGroup(
                currentWeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentWeatherPanelLayout
                                .createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(currentWeatherPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(forecastMain, javax.swing.GroupLayout.PREFERRED_SIZE, 451,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(currentWeatherPanelLayout.createSequentialGroup()
                                                .addComponent(cityYesterdayTimeInfoLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cityYesterdayTemperatureLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 335,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(currentWeatherPanelLayout.createSequentialGroup()
                                                .addComponent(temperatureLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        87,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weatherImageLabel1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addGroup(
                                                        currentWeatherPanelLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(currentWeatherPanelLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(weatherFeelsInfoLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(temperatureFeelsLabel))
                                                                .addComponent(weatherInfoLabel)))
                                        .addGroup(currentWeatherPanelLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(waterImageLabel)
                                                .addGap(0, 0, 0)
                                                .addComponent(waterPercentsLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(windImageLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(windInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        109,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        currentWeatherPanelLayout.setVerticalGroup(
                currentWeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(currentWeatherPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(currentWeatherPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cityYesterdayTemperatureLabel)
                                        .addComponent(cityYesterdayTimeInfoLabel))
                                .addGap(18, 18, 18)
                                .addGroup(currentWeatherPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(currentWeatherPanelLayout.createSequentialGroup()
                                                .addComponent(weatherInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        29,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(
                                                        currentWeatherPanelLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weatherFeelsInfoLabel)
                                                                .addComponent(temperatureFeelsLabel)))
                                        .addComponent(temperatureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(weatherImageLabel1))
                                .addGap(13, 13, 13)
                                .addGroup(currentWeatherPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(windImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(waterImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(currentWeatherPanelLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(
                                                        currentWeatherPanelLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(windInfoLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(waterPercentsLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forecastMain, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(7, Short.MAX_VALUE)));

        javax.swing.GroupLayout mainWeatherPanelLayout = new javax.swing.GroupLayout(mainWeatherPanel);
        mainWeatherPanel.setLayout(mainWeatherPanelLayout);
        mainWeatherPanelLayout.setHorizontalGroup(
                mainWeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainWeatherPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainWeatherPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainWeatherPanelLayout.createSequentialGroup()
                                                .addComponent(cityFindTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        303,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cityFindButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        55,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(currentWeatherPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)));
        mainWeatherPanelLayout.setVerticalGroup(
                mainWeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainWeatherPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainWeatherPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cityFindButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cityFindTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentWeatherPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        forecastDaysPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forecastDaysPanel.setPreferredSize(new java.awt.Dimension(325, 390));

        forecastImageDay3
                .setIcon(new javax.swing.ImageIcon(getImageResouce(TEST_IMAGE_PATH).getURL())); // NOI18N

        forecastTemperatureDay3.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        forecastTemperatureDay3.setText("+33°");

        forecastFeelTemperatureDay3.setForeground(new java.awt.Color(102, 102, 102));
        forecastFeelTemperatureDay3.setText("+32°");

        forecastDateDay3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        forecastDateDay3.setForeground(new java.awt.Color(102, 102, 102));
        forecastDateDay3.setText("21 июня");

        forecastWeekendDay3.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        forecastWeekendDay3.setText("Пт");

        forecastConditionPaneDay3.setBorder(null);
        forecastConditionPaneDay3
                .setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        forecastConditionPaneDay3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        forecastCondititonDay3.setEditable(false);
        forecastCondititonDay3.setColumns(20);
        forecastCondititonDay3.setForeground(new java.awt.Color(102, 102, 102));
        forecastCondititonDay3.setLineWrap(true);
        forecastCondititonDay3.setRows(5);
        forecastCondititonDay3.setText("Облачно с небольшими осадками\n");
        forecastCondititonDay3.setWrapStyleWord(true);
        forecastCondititonDay3.setBorder(null);
        forecastCondititonDay3.setCaretColor(new java.awt.Color(204, 204, 204));
        forecastCondititonDay3.setOpaque(false);
        forecastConditionPaneDay3.setViewportView(forecastCondititonDay3);

        javax.swing.GroupLayout forecastPanelDay3Layout = new javax.swing.GroupLayout(forecastPanelDay3);
        forecastPanelDay3.setLayout(forecastPanelDay3Layout);
        forecastPanelDay3Layout.setHorizontalGroup(
                forecastPanelDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forecastPanelDay3Layout.createSequentialGroup()
                                .addGroup(forecastPanelDay3Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(forecastPanelDay3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(forecastDateDay3))
                                        .addGroup(forecastPanelDay3Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(forecastWeekendDay3))
                                        .addGroup(forecastPanelDay3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(forecastImageDay3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        64,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(forecastPanelDay3Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(forecastPanelDay3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(forecastTemperatureDay3)
                                                        .addGroup(forecastPanelDay3Layout.createSequentialGroup()
                                                                .addGap(2, 2, 2)
                                                                .addComponent(forecastFeelTemperatureDay3)))))
                                .addGap(10, 18, Short.MAX_VALUE))
                        .addComponent(forecastConditionPaneDay3, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
        forecastPanelDay3Layout.setVerticalGroup(
                forecastPanelDay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forecastPanelDay3Layout
                                .createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(forecastWeekendDay3)
                                .addGap(0, 0, 0)
                                .addComponent(forecastDateDay3, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(forecastImageDay3)
                                .addGap(0, 0, 0)
                                .addComponent(forecastTemperatureDay3)
                                .addGap(0, 0, 0)
                                .addComponent(forecastFeelTemperatureDay3)
                                .addGap(0, 0, 0)
                                .addComponent(forecastConditionPaneDay3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));

        forecastImageDay2
                .setIcon(new javax.swing.ImageIcon(getImageResouce(TEST_IMAGE_PATH).getURL())); // NOI18N

        forecastTemperatureDay2.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        forecastTemperatureDay2.setText("+32°");

        forecastFeelTemperatureDay2.setForeground(new java.awt.Color(102, 102, 102));
        forecastFeelTemperatureDay2.setText("+36°");

        forecastDateDay2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        forecastDateDay2.setForeground(new java.awt.Color(102, 102, 102));
        forecastDateDay2.setText("20 июня");

        forecastWeekendDay2.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        forecastWeekendDay2.setText("Чт");

        forecastConditionPaneDay2.setBorder(null);
        forecastConditionPaneDay2
                .setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        forecastConditionPaneDay2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        forecastConditionDay2.setEditable(false);
        forecastConditionDay2.setColumns(20);
        forecastConditionDay2.setForeground(new java.awt.Color(102, 102, 102));
        forecastConditionDay2.setLineWrap(true);
        forecastConditionDay2.setRows(5);
        forecastConditionDay2.setText("Облачно с небольшими осадками\n");
        forecastConditionDay2.setWrapStyleWord(true);
        forecastConditionDay2.setBorder(null);
        forecastConditionDay2.setCaretColor(new java.awt.Color(204, 204, 204));
        forecastConditionDay2.setOpaque(false);
        forecastConditionPaneDay2.setViewportView(forecastConditionDay2);

        javax.swing.GroupLayout forecastPanelDay2Layout = new javax.swing.GroupLayout(forecastPanelDay2);
        forecastPanelDay2.setLayout(forecastPanelDay2Layout);
        forecastPanelDay2Layout.setHorizontalGroup(
                forecastPanelDay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forecastPanelDay2Layout.createSequentialGroup()
                                .addGroup(forecastPanelDay2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(forecastPanelDay2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(forecastDateDay2))
                                        .addGroup(forecastPanelDay2Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(forecastWeekendDay2))
                                        .addGroup(forecastPanelDay2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(forecastImageDay2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        64,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(forecastPanelDay2Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(forecastPanelDay2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(forecastTemperatureDay2)
                                                        .addGroup(forecastPanelDay2Layout.createSequentialGroup()
                                                                .addGap(2, 2, 2)
                                                                .addComponent(forecastFeelTemperatureDay2)))))
                                .addGap(10, 18, Short.MAX_VALUE))
                        .addComponent(forecastConditionPaneDay2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
        forecastPanelDay2Layout.setVerticalGroup(
                forecastPanelDay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forecastPanelDay2Layout
                                .createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(forecastWeekendDay2)
                                .addGap(0, 0, 0)
                                .addComponent(forecastDateDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(forecastImageDay2)
                                .addGap(0, 0, 0)
                                .addComponent(forecastTemperatureDay2)
                                .addGap(0, 0, 0)
                                .addComponent(forecastFeelTemperatureDay2)
                                .addGap(0, 0, 0)
                                .addComponent(forecastConditionPaneDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));

        forecastImageDay1
                .setIcon(new javax.swing.ImageIcon(getImageResouce(TEST_IMAGE_PATH).getURL())); // NOI18N

        forecastTemperatureDay1.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        forecastTemperatureDay1.setText("+30°");

        forecastFeelTemperatureDay1.setForeground(new java.awt.Color(102, 102, 102));
        forecastFeelTemperatureDay1.setText("+34°");

        forecastDateDay1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        forecastDateDay1.setForeground(new java.awt.Color(102, 102, 102));
        forecastDateDay1.setText("19 июня");

        forecastWeekendDay1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        forecastWeekendDay1.setText("Ср");

        forecastConditionPaneDay1.setBorder(null);
        forecastConditionPaneDay1
                .setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        forecastConditionPaneDay1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        forecastConditionDay1.setEditable(false);
        forecastConditionDay1.setColumns(20);
        forecastConditionDay1.setForeground(new java.awt.Color(102, 102, 102));
        forecastConditionDay1.setLineWrap(true);
        forecastConditionDay1.setRows(5);
        forecastConditionDay1.setText("Облачно с небольшими осадками\n");
        forecastConditionDay1.setWrapStyleWord(true);
        forecastConditionDay1.setBorder(null);
        forecastConditionDay1.setCaretColor(new java.awt.Color(204, 204, 204));
        forecastConditionDay1.setOpaque(false);
        forecastConditionPaneDay1.setViewportView(forecastConditionDay1);

        javax.swing.GroupLayout forecastPanelDay1Layout = new javax.swing.GroupLayout(forecastPanelDay1);
        forecastPanelDay1.setLayout(forecastPanelDay1Layout);
        forecastPanelDay1Layout.setHorizontalGroup(
                forecastPanelDay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forecastPanelDay1Layout.createSequentialGroup()
                                .addGroup(forecastPanelDay1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(forecastPanelDay1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(forecastDateDay1))
                                        .addGroup(forecastPanelDay1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(forecastWeekendDay1))
                                        .addGroup(forecastPanelDay1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(forecastImageDay1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        64,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(forecastPanelDay1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(forecastPanelDay1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(forecastTemperatureDay1)
                                                        .addGroup(forecastPanelDay1Layout.createSequentialGroup()
                                                                .addGap(2, 2, 2)
                                                                .addComponent(forecastFeelTemperatureDay1)))))
                                .addGap(10, 18, Short.MAX_VALUE))
                        .addComponent(forecastConditionPaneDay1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
        forecastPanelDay1Layout.setVerticalGroup(
                forecastPanelDay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forecastPanelDay1Layout
                                .createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(forecastWeekendDay1)
                                .addGap(0, 0, 0)
                                .addComponent(forecastDateDay1, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(forecastImageDay1)
                                .addGap(0, 0, 0)
                                .addComponent(forecastTemperatureDay1)
                                .addGap(0, 0, 0)
                                .addComponent(forecastFeelTemperatureDay1)
                                .addGap(0, 0, 0)
                                .addComponent(forecastConditionPaneDay1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));

        javax.swing.GroupLayout forecastDaysPanelLayout = new javax.swing.GroupLayout(forecastDaysPanel);
        forecastDaysPanel.setLayout(forecastDaysPanelLayout);
        forecastDaysPanelLayout.setHorizontalGroup(
                forecastDaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forecastDaysPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(forecastPanelDay1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forecastPanelDay2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(forecastPanelDay3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE)));
        forecastDaysPanelLayout.setVerticalGroup(
                forecastDaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forecastDaysPanelLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(forecastDaysPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(forecastPanelDay3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(forecastPanelDay1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(forecastPanelDay2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(94, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainWeatherPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forecastDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainWeatherPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(forecastDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }

    private ClassPathResource getImageResouce(String path) {
        return new ClassPathResource(path);
    }

    private Dimension getWindowDimension(Environment env) {
        return new Dimension(
                Integer.valueOf(env.getProperty("application.view.window.width")),
                Integer.valueOf(env.getProperty("application.view.window.height")));
    }
}
