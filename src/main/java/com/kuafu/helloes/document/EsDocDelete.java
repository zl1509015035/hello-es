package com.kuafu.helloes.document;

import com.kuafu.helloes.EsClient;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

public class EsDocDelete {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //插入数据
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");


        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);

        System.out.println(response);

        esClient.close();;

    }
}
