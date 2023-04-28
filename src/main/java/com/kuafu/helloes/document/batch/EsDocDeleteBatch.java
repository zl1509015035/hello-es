package com.kuafu.helloes.document.batch;

import com.kuafu.helloes.EsClient;
import com.kuafu.helloes.domain.User;
import com.kuafu.helloes.util.JsonUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDocDeleteBatch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();
        //插入数据
        BulkRequest bulkRequest = new BulkRequest("user");

        bulkRequest.add(initRequest("1001"));
        bulkRequest.add(initRequest("1002"));
        bulkRequest.add(initRequest("1003"));
        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(response);

        esClient.close();

    }


    private static DeleteRequest initRequest(String id) {
        return new DeleteRequest().id(id);
    }

}
