package com.qa.utils;

import java.io.*;
import java.util.*;

public class ConfigReader {

    private Properties prop;

    /**
     * This method is used to load the properties from config.properties file
     * @return it returns Properties prop object
     */
    public Properties init_prop(){
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }



}
