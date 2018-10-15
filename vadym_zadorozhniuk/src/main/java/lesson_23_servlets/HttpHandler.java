package lesson_23_servlets;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpHandler {
    private CloseableHttpClient client = HttpClientBuilder.create().build();

    public void get(String host){
        HttpGet httpGet = new HttpGet(host);

        try(CloseableHttpResponse httpResponse = client.execute(httpGet)){
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                String s = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println(s);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void set(String host){
        HttpPost httpPost = new HttpPost(host);

        try(CloseableHttpResponse httpResponse = client.execute(httpPost)){
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                String s = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println(s);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpHandler httpHandler = new HttpHandler();
        httpHandler.get("http://localhost:8080/vadym_zadorozhniuk-1.0-SNAPSHOT/servlet?id=1");

        httpHandler.set("http://localhost:8080/vadym_zadorozhniuk-1.0-SNAPSHOT/servlet?id=2");
        httpHandler.get("http://localhost:8080/vadym_zadorozhniuk-1.0-SNAPSHOT/servlet?id=2");

    }



}
