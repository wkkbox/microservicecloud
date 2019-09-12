
package com.wk.springcloud.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientTest {

    public static void main(String[] args) {

        Map<String, String> param = new HashMap<>();
        param.put("accountName", "123456");
        param.put("password", "123456");
        //param.put("userId", "26");
        //param.put("activityType", "0");
        //System.out.println(doPost("http://192.168.0.104:8080/dangyuan/user/login", param));

        //System.out.println("返回数据：" + doGet("http://127.0.0.1:8080/dangyuan/user/login", param));
        System.out.println(new Gson().toJson(new MessageResult(true, "eweweew")));
        System.out.println(new Gson().fromJson("{\"success\":false,\"msg\":\"用户名或密码错误\",\"data\":null}", MessageResult.class).getData());
        //System.out.println(doPost("http://127.0.0.1:8080/dangyuan/activity/activities", param));
        List<MessageResult> list = new ArrayList<>();
        list.add(new MessageResult(true, "2121212"));
        list.add(new MessageResult(false, "2rer1212"));
        System.out.println(new Gson().toJson(list));
        System.out.println(list);
        List<MessageResult> list1 = new Gson().fromJson("[{\"success\":true,\"msg\":\"2121212\"},{\"success\":false,\"msg\":\"2rer1212\"}]", new TypeToken<List<MessageResult>>() {
        }.getType());
        System.out.println(list1);

    }

    public static String doPost(String url, Map<String, String> param) {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = null;

        String resultString = "";

        try {
            // 创建HttpPost请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                // 设置请求的内容
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    resultString = EntityUtils.toString(entity, "utf-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("dsd");
        return resultString;
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }

    public static String doGet(String url, Map<String, String> param) {

        // 创建HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;

        String resultString = "";

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建HttpGET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    resultString = EntityUtils.toString(entity, "utf-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }

}
