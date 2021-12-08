package edu.diana.learn;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.Scanner;

public class HttpPostExample {
    public static void main(String args[]) throws Exception {

        //Creating a HttpClient object
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating a HttpGet object
        HttpPost httppost = new HttpPost("https://krisha.kz/");

        //Printing the method used
        System.out.println("Request Type: " + httppost.getMethod());

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httppost);

        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }


    }
}