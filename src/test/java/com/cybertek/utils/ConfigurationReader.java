package com.cybertek.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this util class is used to read values from configuration.properties file
 */

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {
            //Open the file using inputstream
            FileInputStream inputStream = new FileInputStream("configuration.properties");

            //load to properties object
            properties.load(inputStream);

            //close the file after loading. Free up memory
            inputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");
        }
    }

    /**
     * Method is used to read value from a configuration.properties file
     * @param key -> key name in properties file
     * @return -> value for the key. returns null if key not found
     * EX: driver.get( ConfigurationReader.getProperty("url") ) ;
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
