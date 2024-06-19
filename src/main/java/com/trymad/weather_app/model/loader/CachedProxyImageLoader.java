package com.trymad.weather_app.model.loader;

import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CachedProxyImageLoader implements ImageLoader {

  private final ImageLoader imageLoader;
  private final Map<URL, Image> cache;

  public CachedProxyImageLoader(ImageLoader imageLoader) {
    this.imageLoader = imageLoader;
    this.cache = new HashMap<>();
  }

  @Override
  public Image loadImage(URL url) {
    if (cache.containsKey(url)) {
      return cache.get(url);
    } else {
      final Image image = imageLoader.loadImage(url);
      cache.put(url, image);
      return image;
    }
  }
}
