package com.kuafu.helloes;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class EsClient {

    public static RestHighLevelClient getHighLevelClient(){
        //指定elastic search的ip和端口
        HttpHost host= new HttpHost("127.0.0.1",9200,"http");
        return new RestHighLevelClient(RestClient.builder(host));
    }
}
