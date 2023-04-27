package com.kuafu.helloes;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class EsIndexCreate {


    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);
        //相应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作:"+acknowledged);

        //关闭ES客户端
        esClient.close();
    }
}
