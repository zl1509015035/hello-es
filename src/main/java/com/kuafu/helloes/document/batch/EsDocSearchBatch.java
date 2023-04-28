package com.kuafu.helloes.document.batch;

import com.kuafu.helloes.EsClient;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.naming.directory.SearchResult;
import java.io.IOException;

public class EsDocSearchBatch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();
        //插入数据
        SearchRequest request = new SearchRequest("user");
        //构造查询条件 查询全部数据
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        request.source(query);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        System.out.println(response);

        for (SearchHit hit : response.getHits()){
            System.out.println(hit.getSourceAsString());
        }

        esClient.close();

    }


    private static DeleteRequest initRequest(String id) {
        return new DeleteRequest().id(id);
    }

}
