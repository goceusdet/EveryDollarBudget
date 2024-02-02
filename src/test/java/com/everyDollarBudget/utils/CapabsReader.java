package com.everyDollarBudget.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CapabsReader {

    public CapabsReader(){}

    public static DesiredCapabilities getCapabilities(){

        DesiredCapabilities caps = new DesiredCapabilities();
        BufferedReader reader = null;
        String line;

            try {
                if(ConfigurationReader.getProperty("platform").equalsIgnoreCase("android")) {
                    reader = new BufferedReader(new FileReader(Environment.ANDROID_CAPABS_FILE_PATH));
                }else if(ConfigurationReader.getProperty("platform").equalsIgnoreCase("ios")){
                    reader = new BufferedReader(new FileReader(Environment.IOS_CAPABS_FILE_PATH));
                }
                line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    String[] cap = line.split("=");
                    caps.setCapability(cap[0], cap[1]);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return caps;
        }

}
