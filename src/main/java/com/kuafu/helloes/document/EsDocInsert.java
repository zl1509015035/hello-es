package com.kuafu.helloes.document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuafu.helloes.EsClient;
import com.kuafu.helloes.domain.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDocInsert {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");
        User user = new User();
        user.setName("张三");
        user.setAge(30);
        user.setSex("男");

        //通过jackson转成json格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        request.source(userJson, XContentType.JSON);
        IndexResponse index = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(index.getResult());

        System.out.println(index);

        esClient.close();;

    }
}
