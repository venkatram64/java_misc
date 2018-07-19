package com.venkat.work.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestLogin {

    /*
    To get the token for given auth information
     */
    public String getToken(){
        try {
            URL myUrl = new URL("https://reqres.in/api/login");
            try {

                String jsonData = "{\"email\":\"peter@klaven\",\"password\":\"cityslicka\"}";

                System.out.println(jsonData);

                HttpURLConnection connection = (HttpURLConnection)myUrl.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("User-Agent","Mozilla/4.0");
                connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
                connection.setRequestProperty("Content-Length",String.valueOf(jsonData.getBytes("UTF-8").length));
                connection.setRequestProperty("Content-Language","en-US");
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                os.write(jsonData.getBytes("UTF-8"));
                os.flush();
                os.close();
                //response
                System.out.println("Response code: " + connection.getResponseCode());
                System.out.println("Response message: " + connection.getResponseMessage());
                String line;
                StringBuffer response = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = bufferedReader.readLine()) != null){
                    response.append(line);
                }
                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void elasticAliasing(){
        try {
            URL myUrl = new URL("http://localhost:9200/_cat/indices");

            HttpURLConnection connection = (HttpURLConnection)myUrl.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Mozilla/4.0");
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            connection.setRequestProperty("Content-Language","en-US");
            connection.setDoOutput(true);

            if(connection.getResponseCode() == 200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*

        import java.net.URL
        import java.net.HttpURLConnection
        import java.nio.charset.StandardCharsets
        import groovy.json.JsonSlurper
        import groovy.json.JsonOutput
        import org.apache.commons.io.IOUtils

        def flowFile = session.get()

        if(flowFile == null){
            flowFile = session.create()
        }

        def errorMessage = null
        def outputRelation = REL_SUCESS

        def responseCode

        flowFile = session.write(flowFile, {inputStream, outputStream ->
            def urlStr = ''
            try{
                urlStr = flowFile.getAttribute("urlString")
                urlStr = urlStr.trim()
                urlStr += "_cat/indices?format=json&pretty"
                def requiredIndex = [:]
                def url = new URL(urlStr)

                HttpURLConnection connection = (HttpURLConnection)myUrl.openConnection()

                connection.setRequestMethod("GET")
                connection.setRequestProperty("User-Agent","Mozilla/4.0")
                connection.setRequestProperty("Content-Type","application/json; charset=UTF-8")
                connection.setRequestProperty("Content-Language","en-US")
                connection.setDoOutput(true)

                if(connection.responseCode == 200){
                    def jsonResponse = connection.inputStream.withCloseable{ inStream ->
                        new JsonSlurper().parse(inStream)
                    }

                    for(rec in jsonResponse){
                        rec.earch{k,v ->
                            if(k == "index"){
                                if(v == "my_index_v"){
                                    requiredIndex.index = "my_index_v2"
                                }else if(v == "my_index_v2"){
                                    requiredIndex.index = "my_index_v"
                                }else{
                                    //this is the first time they are running
                                    requiredIndex.index = "my_index_v"
                                }
                            }

                        }
                    }
                }else{
                    requiredIndex.index = "my_index_v"
                }

                def json = JsonOutput.toJson(requiredIndex)

                outputStream.write(JsonOutput.prettyPrint(json).getBytes(StandardCharsets.UTF-8))
            }catch(Exception e){
                errorMessage = "404"
                outputRelation = REL_FAILURE
            }
        } as StreamCallback)

        if(errorMessage != null){
            flowFile = session.putAttribute(flowFile,"parseUrl.error", 200)
        }else{
            flowFile = session.putAttribute(flowFile,"parseUrl.sucess", 200)
        }

        session.transfer(flowFile,outputRelation)


     */

    public static void main(String[] args) {
        /*String token = new RestLogin().getToken();
        System.out.println("Token: " + token);*/

        new RestLogin().elasticAliasing();
    }
}

