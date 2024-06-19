package com.trymad.weather_app.model.loader;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class ImageLoaderImpl implements ImageLoader {

  @Override
  public Image loadImage(URL url) {
    try {
      return ImageIO.read(url);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

}
