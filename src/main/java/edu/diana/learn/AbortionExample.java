package edu.diana.learn;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class AbortionExample {
    public static void main(String args[]) throws Exception {

        //Creating an HttpClient object
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating an HttpGet object
        HttpGet httpget = new HttpGet("https://krisha.kz/");

        //Printing the method used
        System.out.println(httpget.getMethod());

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());

        httpget.abort();
        System.out.println(httpresponse.getEntity().getContentLength());

        //Executing the Get request
        HttpResponse httpresponse2 = httpclient.execute(httpget);
        System.out.println(httpresponse2.getStatusLine());
    }
}