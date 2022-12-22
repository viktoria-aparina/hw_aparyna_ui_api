package org.pm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DefaultConfig {
  private Properties currentProperties;
  private static final Logger logger = Logger.getLogger(DefaultConfig.class);
  private static final String PROPERTIES_FILE_PATH = "src/main/resources/project-config.properties";
  private static final DefaultConfig instance = new DefaultConfig();

  private DefaultConfig() {}

  public static DefaultConfig getInstance() {
    return instance;
  }

  private Properties getCurrentProperties() {
    if(currentProperties == null) {
      logger.info("Loading properties from " + PROPERTIES_FILE_PATH);
      try {
        InputStream input = new FileInputStream(PROPERTIES_FILE_PATH);
        currentProperties = new Properties();
        currentProperties.load(input);
        logger.info(currentProperties.entrySet().size() + " properties loaded.");
      } catch (IOException e) {
        logger.error("Couldn`t load properties.", e);
      }
    }
    return currentProperties;
  }

  public String getUrl(String property) {
    return getCurrentProperties().getProperty(property);
  }

  public int getPropertiesNumber(){
    return getCurrentProperties().entrySet().size();
  }
}
