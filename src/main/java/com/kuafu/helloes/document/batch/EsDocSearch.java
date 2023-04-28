package com.kuafu.helloes.document.batch;

import com.kuafu.helloes.EsClient;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;
import java.util.List;

public class EsDocSearch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = EsClient.getHighLevelClient();
        //插入数据
        SearchRequest request = new SearchRequest("user");
        //构造查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();


        /**
         * 1.全量查询
         */
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        /**
         * 2.条件查询
         */
//        searchSourceBuilder.query(QueryBuilders.termQuery("age",18));

        /**
         * 3.分页查询
         */
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //(当前页码-1)*每页显示数据条数
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(10);

        /**
         * 4.查询排序
         */
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.sort("age", SortOrder.DESC);

        /**
         * 5.过滤字段
         */
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        String[] includes = {};
//        String[] excludes = {"age"};
//        searchSourceBuilder.fetchSource(includes, excludes);


        /**
         * 6.组合查询
         */
//        BoolQueryBuilder QueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.termQuery("age",19));
//        boolQueryBuilder.must(QueryBuilders.termQuery("sex","女"));
//        boolQueryBuilder.mustNot(QueryBuilders.termQuery("sex","男"));
//        boolQueryBuilder.should(QueryBuilders.termQuery("age",18));
//        boolQueryBuilder.should(QueryBuilders.termQuery("age",19));

        /**
         * 7.范围查询
         */

//        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("age");
        //大于等于
//        queryBuilder.gte(30);
        //小于等于
//        queryBuilder.lte(40);

        /**
         * 8.范围查询
         */
        //查一个字符也可以
//        FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", "王五")
//                .fuzziness(Fuzziness.ONE);


        /**
         * 9.高亮显示
         */
        //查询条件
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        queryBuilder.must(QueryBuilders.matchQuery("name","张三"));
//        //高亮
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        //前
//        highlightBuilder.preTags("<font color = 'red'>");
//        //后
//        highlightBuilder.postTags("</font>");
//        //指定属性
//        highlightBuilder.field("name");
//        searchSourceBuilder.highlighter(highlightBuilder);


        /**
         * 10.聚合查询 最大年龄
         */
//        MaxAggregationBuilder boolQueryBuilder = AggregationBuilders.max("maxAge").field("age");
//        searchSourceBuilder.aggregation(boolQueryBuilder);


        /**
         * 11、聚合查询 分组
         */
        TermsAggregationBuilder boolQueryBuilder = AggregationBuilders.terms("ageGroup").field("age");
        searchSourceBuilder.aggregation(boolQueryBuilder);


//        searchSourceBuilder.query(boolQueryBuilder);
        request.source(searchSourceBuilder);
        //若返回total中relation不是eq，则表示大约数，将trackTotalHits设置为true可返回精确数量
        request.source().trackTotalHits(true);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        System.out.println(response);

        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }

        esClient.close();

    }


}
