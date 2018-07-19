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

    public static void main(String[] args) {
        String token = new RestLogin().getToken();
        System.out.println("Token: " + token);
    }
}

