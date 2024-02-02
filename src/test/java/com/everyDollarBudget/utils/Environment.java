package com.everyDollarBudget.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String USER_NAME;
    public static final String USER_PASSWORD;
    public static final String ANDROID_CAPABS_FILE_PATH;
    public static final String IOS_CAPABS_FILE_PATH;

    static {
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.getProperty("environment");
        //this field will get its value from configuration.properties file environment key /qa1 qa2 qa3
        //String environment = ConfigurationReader.getProperty("environment");

        try {
            //where is our file ?, path is holding that one
            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        USER_NAME = properties.getProperty("userName");
        USER_PASSWORD = properties.getProperty("userPassword");
        ANDROID_CAPABS_FILE_PATH = properties.getProperty("androidCapAbsFilePath");
        IOS_CAPABS_FILE_PATH = properties.getProperty("iosCapAbsFilePath");
    }

}
