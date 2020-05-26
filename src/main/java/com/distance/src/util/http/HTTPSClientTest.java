package com.distance.src.util.http;



import org.apache.http.client.HttpClient;

import java.util.HashMap;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = null;

        httpClient = new HTTPSTrustClient().init();
        //httpClient = new HTTPSCertifiedClient().init();

        String url = "https://blog.csdn.net/api/ArticleHighWords/list";

        String result = HTTPSClientUtil.doGet(httpClient, url, new HashMap<>(),new HashMap<>());

        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);

        System.out.println(result);
    }

}