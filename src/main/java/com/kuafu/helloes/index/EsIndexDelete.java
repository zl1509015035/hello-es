package com.kuafu.helloes.index;

import com.kuafu.helloes.EsClient;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class EsIndexDelete {


    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //创建索引
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        AcknowledgedResponse delete = esClient.indices().delete(request, RequestOptions.DEFAULT);
        //相应状态
        boolean acknowledged = delete.isAcknowledged();
        System.out.println("索引删除操作:"+acknowledged);

        //关闭ES客户端
        esClient.close();
    }
}
