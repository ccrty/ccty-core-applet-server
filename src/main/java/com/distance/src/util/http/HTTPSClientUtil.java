package com.distance.src.util.http;

import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @author 缄默
 * @date 2019/12/23
 */
public class HTTPSClientUtil {
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 表单请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @return
     * @throws Exception
     */
    public static String doPost(HttpClient httpClient, String url, Map<String, String> paramHeader,
                                Map<String, String> paramBody) throws Exception {
        return doPost(httpClient, url, paramHeader, paramBody, DEFAULT_CHARSET);
    }

    /**
     * 表单请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doPost(HttpClient httpClient, String url,Map<String, String> paramHeader,
                                Map<String, String> paramBody, String charset) throws Exception {

        String result = null;
        HttpPost httpPost = new HttpPost(url);
        setHeader(httpPost, paramHeader);
        setBody(httpPost, paramBody, charset);

        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = EntityUtils.toString(resEntity, charset);
            }
        }

        return result;
    }

    /**
     * 请求体请求
     * @param httpClient
     * @param paramHeader
     * @param url
     * @param strJson
     * @return
     * @throws Exception
     */
    public static String doPostJson(HttpClient httpClient, Map<String, String> paramHeader,String url,String strJson) throws Exception {
        return doPostJson(httpClient, url,paramHeader, strJson, DEFAULT_CHARSET);
    }

    /**
     * 请求体请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param strJson
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doPostJson(HttpClient httpClient, String url,Map<String, String> paramHeader, String strJson, String charset) throws Exception {

        String result = null;
        HttpPost httpPost = new HttpPost(url);
        setHeader(httpPost,paramHeader);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        httpPost.setHeader("Authentication", "Basic "
                + Base64.getEncoder().encodeToString("xxxx:xxxx".getBytes()));
        StringEntity entity = new StringEntity(strJson);
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = EntityUtils.toString(resEntity, charset);
            }
        }

        return result;
    }

    /**
     * get请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @return
     * @throws Exception
     */
    public static String doGet(HttpClient httpClient, String url, Map<String, String> paramHeader,
                               Map<String, String> paramBody) throws Exception {
        return doGet(httpClient, url, paramHeader, paramBody, DEFAULT_CHARSET);
    }

    /**
     * get请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doGet(HttpClient httpClient, String url, Map<String, String> paramHeader,
                               Map<String, String> paramBody, String charset) throws Exception {

        String result = null;
        HttpGet httpGet = new HttpGet(url);
        setHeader(httpGet, paramHeader);

        HttpResponse response = httpClient.execute(httpGet);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = EntityUtils.toString(resEntity, charset);
            }
        }

        return result;
    }

    /**
     * 设置请求头
     * @param request
     * @param paramHeader
     */
    private static void setHeader(HttpRequestBase request, Map<String, String> paramHeader) {
        // 设置Header
        if (paramHeader != null) {
            Set<String> keySet = paramHeader.keySet();
            for (String key : keySet) {
                request.addHeader(key, paramHeader.get(key));
            }
        }
    }

    /**
     * 设置请求体
     * @param httpPost
     * @param paramBody
     * @param charset
     * @throws Exception
     */
    private static void setBody(HttpPost httpPost, Map<String, String> paramBody, String charset) throws Exception {
        // 设置参数
        if (paramBody != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Set<String> keySet = paramBody.keySet();
            for (String key : keySet) {
                list.add(new BasicNameValuePair(key, paramBody.get(key)));
            }

            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
        }
    }
}