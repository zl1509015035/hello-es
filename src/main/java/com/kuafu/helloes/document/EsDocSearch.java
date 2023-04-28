package com.kuafu.helloes.document;

import com.kuafu.helloes.EsClient;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDocSearch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //插入数据
        GetRequest request = new GetRequest();
        request.index("user").id("1001");


        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        System.out.println(response);

        esClient.close();;

    }
}
