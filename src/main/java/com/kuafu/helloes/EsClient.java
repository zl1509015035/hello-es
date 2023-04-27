package com.kuafu.helloes;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class EsClient {

    public static RestHighLevelClient getHighLevelClient(){
        //指定elastic search的ip和端口
        HttpHost host= new HttpHost("es1.xforwardai.com",39200,"http");
        RestClientBuilder builder = RestClient.builder(host);
        //设置es 账户名和密码
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "Xyzn@e1s2"));
        builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));

        return new RestHighLevelClient(builder);
    }

    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = getHighLevelClient();


        //关闭ES客户端
        esClient.close();
    }
}
