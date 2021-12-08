package edu.diana.learn;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;

public class FormLoginExample {
    public static void main(String args[]) throws Exception {

        //Creating CloseableHttpClient object
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating the RequestBuilder object
        RequestBuilder reqbuilder = RequestBuilder.post();

        //Setting URI and parameters
        RequestBuilder reqbuilder1 = reqbuilder.setUri("http://httpbin.org/post");
        RequestBuilder reqbuilder2 = reqbuilder1.addParameter("Name",
                "username").addParameter("password", "password");

        //Building the HttpUriRequest object
        HttpUriRequest httppost = reqbuilder2.build();

        //Executing the request
        HttpResponse httpresponse = httpclient.execute(httppost);

        //Printing the status and the contents of the response
        System.out.println(EntityUtils.toString(httpresponse.getEntity()));
        System.out.println(httpresponse.getStatusLine());
    }
}
