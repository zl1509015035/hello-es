package com.kuafu.helloes.document.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuafu.helloes.EsClient;
import com.kuafu.helloes.domain.User;
import com.kuafu.helloes.util.JsonUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDocInsertBatch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();
        //插入数据
        BulkRequest bulkRequest = new BulkRequest("user");

        bulkRequest.add(initRequest("1001",new User("张三","男",18)));
        bulkRequest.add(initRequest("1002",new User("李四","女",19)));
        bulkRequest.add(initRequest("1003",new User("王五","男",25)));
        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(response);

        esClient.close();

    }


    private static IndexRequest initRequest(String id, User user) {
        IndexRequest request = new IndexRequest().id(id);
        request.source(JsonUtil.obj2Json(user),XContentType.JSON);
        return request;
    }

}
