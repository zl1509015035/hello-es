package com.kuafu.helloes.index;

import com.kuafu.helloes.EsClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;

import java.io.IOException;
import java.util.Map;

public class EsIndexSearch {


    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = EsClient.getHighLevelClient();

        //查询索引
        GetIndexRequest request = new GetIndexRequest("user");

        GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);
        //别名
        System.out.println(getIndexResponse.getAliases());
        //映射
        Map<String, MappingMetadata> mappings = getIndexResponse.getMappings();

        System.out.println(getIndexResponse.getMappings());
        //配置分片、副本
        System.out.println(getIndexResponse.getSettings());
        //
        //关闭ES客户端
        esClient.close();
    }
}
