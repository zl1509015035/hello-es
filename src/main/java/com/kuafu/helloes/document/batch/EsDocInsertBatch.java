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
        bulkRequest.add(initRequest("1003",new User("王五3","男",25)));
        bulkRequest.add(initRequest("1004",new User("王五4","女",23)));
        bulkRequest.add(initRequest("1005",new User("王五5","男",32)));
        bulkRequest.add(initRequest("1006",new User("王五6","女",27)));
        bulkRequest.add(initRequest("1007",new User("王五7","女",29)));
        bulkRequest.add(initRequest("1008",new User("王五8","男",32)));
        bulkRequest.add(initRequest("1009",new User("王五9","男",35)));
        bulkRequest.add(initRequest("10010",new User("王五10","女",37)));
        bulkRequest.add(initRequest("10011",new User("王五11","女",19)));
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
