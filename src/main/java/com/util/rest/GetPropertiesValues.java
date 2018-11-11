package com.util.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class GetPropertiesValues {

    String result = "";
    InputStream inputStream;

    final static Logger LOGGER = Logger.getLogger("InfoLogging");

    public String getValues(String name) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "webservice.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file " + propFileName + " not found");
            }

            result = prop.getProperty(name);
        } catch (Exception e) {
            LOGGER.info("Error");
        }

        return result;

    }
}
