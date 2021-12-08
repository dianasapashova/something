package edu.diana.learn;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class ProxyAuthenticationExample {
    public static void main(String[] args) throws Exception {

        //Creating the CredentialsProvider object
        CredentialsProvider credsProvider = new BasicCredentialsProvider();

        //Setting the credentials
        credsProvider.setCredentials(new AuthScope("example.com", 80),
                new UsernamePasswordCredentials("user", "mypass"));
        credsProvider.setCredentials(new AuthScope("localhost", 8000),
                new UsernamePasswordCredentials("abc", "passwd"));

        //Creating the HttpClientBuilder
        HttpClientBuilder clientbuilder = HttpClients.custom();

        //Setting the credentials
        clientbuilder = clientbuilder.setDefaultCredentialsProvider(credsProvider);

        //Building the CloseableHttpClient object
        CloseableHttpClient httpclient = clientbuilder.build();


        //Create the target and proxy hosts
        HttpHost targetHost = new HttpHost("example.com", 80, "http");
        HttpHost proxyHost = new HttpHost("localhost", 8000, "http");

        //Setting the proxy
        RequestConfig.Builder reqconfigconbuilder= RequestConfig.custom();
        reqconfigconbuilder = reqconfigconbuilder.setProxy(proxyHost);
        RequestConfig config = reqconfigconbuilder.build();

        //Create the HttpGet request object
        HttpGet httpget = new HttpGet("/");

        //Setting the config to the request
        httpget.setConfig(config);

        //Printing the status line
        HttpResponse response = httpclient.execute(targetHost, httpget);
        System.out.println(response.getStatusLine());

    }
}
