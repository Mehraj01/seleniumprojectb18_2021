package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- we created properties object
    private static Properties properties = new Properties();


    static {
        //2- get the path and store in String, or directly pass into fileInputStream obj
        String path = "configuration.properties";

        try {
            //3- we need to open the file
            FileInputStream file = new FileInputStream(path);
            //4- we need to load the file to properties object
            properties.load(file);

            //5- close.file
            file.close();

        } catch (IOException e) {
            System.out.println("Properties file not found.");
        }
    }

    //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){ // it will accept string parameter ==> ex: "browser","username" etc.
        return properties.getProperty(keyWord);
        //.getProperty(Key) ==> is accepting a key and returns its value
    }

}


/*
ConfigurationReader utility class
	- What we did in that class
	-> to be able to read from .properties type of file, we have to do some setup.
	-> step by step how to read from properties file:
		1- Creating the object from Properties class
		Properties properties = new Properties();
		2- We need to OPEN the file in JVM memory
			- To do this we need the path of the file
			FileInputStream file = new FileInputStream("path");
		3- We need to load the file to properties object.
			properties.load(file);
		4- We close the previously opened file
			file.close();
	UP UNTIL HERE: WE did this all to load the file to properties object
	We created our custom method, and used java getPropery method to read from our file.
	 //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){
    	method on line 225 is coming from JAVA Properties class.
        return properties.getProperty(keyWord);
    }

 */
