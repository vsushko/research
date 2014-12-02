package ru.vsprog.springinaction.chapter12;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.codehaus.jackson.map.ObjectMapper;
import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter7.Spittle;

import java.io.IOException;

public class SpitterClientTheHardWay implements SpitterClient {

    public Spittle[] retrieveSpittlesForSpitter(String username) {
        try {
            HttpClient httpClient = new DefaultHttpClient();

            String spittleUrl = "http://localhost:8080/Spitter/spitters/" +
                    username + "/spittles"; // подготовить Url

            HttpGet getRequest = new HttpGet(spittleUrl); // создать запрос
            getRequest.setHeader(
                    new BasicHeader("Accept", "application/json"));

            HttpResponse response = httpClient.execute(getRequest);// выполнить

            HttpEntity entity = response.getEntity(); // извлечь результаты
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(entity.getContent(), Spittle[].class);
        } catch (IOException e) {
            throw new SpitterClientException("Unable to retrieve Spittles", e);
        }
    }

    public String postSpitter(Spitter spitter) {
        // TODO Auto-generated method stub
        return null;
    }
}
