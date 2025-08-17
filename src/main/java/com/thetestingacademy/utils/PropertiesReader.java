package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // File - read the data from the data.properties -(key, value)

    public static String readKey(String key) {
        //static because we dont want to create any object of this file
        // setting the value in the try so initialise it as null
        Properties p = null; // its actually a legacy class
        // first we shall initialize the local variable & take it as null & then assign the value down
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
            p = new Properties(); // create instance of property
            // its a good practice to set the value in try as if it fails atleast value of p = null
            // to load the file and this will also cause an exception -> IOException
            p.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }


}
