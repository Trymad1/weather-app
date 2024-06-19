package com.trymad.weather_app.ui;

import java.io.IOException;

import javax.swing.JPanel;

import org.springframework.core.io.ClassPathResource;

public class CurrentForecastPanel extends JPanel {

    private javax.swing.JLabel forecastMainImage1;
    private javax.swing.JLabel forecastTemperature1;
    private javax.swing.JLabel forecastTime1;

    private final String PATH_TO_TEST_IMAGE = "static/image/test.png";

    public CurrentForecastPanel() {
        initComponents();
    }

    private void initComponents() {

        forecastMainImage1 = new javax.swing.JLabel();
        forecastTime1 = new javax.swing.JLabel();
        forecastTemperature1 = new javax.swing.JLabel();

        try {
            forecastMainImage1
                    .setIcon(new javax.swing.ImageIcon(getImageResouce(PATH_TO_TEST_IMAGE).getURL()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // NOI18N

        forecastTime1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        forecastTime1.setText("00:00");

        forecastTemperature1.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        forecastTemperature1.setText("+28°");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(forecastMainImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(forecastTime1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(forecastTemperature1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(forecastTime1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forecastMainImage1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(forecastTemperature1)
                                .addContainerGap()));
    }

    private ClassPathResource getImageResouce(String path) {
        return new ClassPathResource(path);
    }
}
