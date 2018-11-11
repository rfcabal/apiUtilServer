package com.util.rest;


import com.util.rest.models.ResponseTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.logging.Logger;

public class RestClient {

    final static Logger LOGGER = Logger.getLogger("InfoLogging");

    public String getPropertie(String name) throws IOException {

        GetPropertiesValues properties = new GetPropertiesValues();
        String url = "";

        try {
            url = properties.getValues(name);
        } catch (Exception e) {
            LOGGER.info("Problema al rescatar el propertie");
        }

        return url;

    }


    public ResponseTest getValues() throws IOException {

        String url = getPropertie("test.service.web");
        RestTemplate restTemplate =  new RestTemplate();

        LOGGER.info("URL");
        LOGGER.info(url);

        ResponseTest response = restTemplate.getForObject(url, ResponseTest.class);

        LOGGER.info("Body");
        LOGGER.info("Codigo de respuesta: " + response.toString());

        return response;

    }



}
