package com.kuafu.helloes.document.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuafu.helloes.EsClient;
import com.kuafu.helloes.domain.User;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDocInsertBatch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //插入数据
        BulkRequest bulkRequest = new BulkRequest();

        IndexRequest addRequest = new IndexRequest();
        addRequest.index("user").id("1001");
        User user = new User();
        user.setName("赵四");
        user.setAge(40);
        user.setSex("女");
        //通过jackson转成json格式 需注意，转换为json后，未赋值的参数value将为null
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        addRequest.source(userJson, XContentType.JSON);

        bulkRequest.add(addRequest);
        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(response);

        esClient.close();;

    }
}
