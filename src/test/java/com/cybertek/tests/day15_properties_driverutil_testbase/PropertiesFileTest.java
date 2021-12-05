package com.cybertek.tests.day15_properties_driverutil_testbase;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileTest {
    @Test
    public void readValuesFromPropertiesFile() throws Exception {
        //Properties class - comes from java lib
        Properties props = new Properties();

        //open file using FileInputStream
        FileInputStream fis = new FileInputStream("configuration.properties");

        //load file content into properties object
        props.load(fis);

        System.out.println(props.getProperty("browser"));
        System.out.println(props.getProperty("webtableUrl"));
        System.out.println(props.getProperty("env"));

    }
}
