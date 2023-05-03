package com.kuafu.springes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author juanwang
 * @create 2023/5/3 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "product",shards = 3,replicas = 1)
public class Product {

    /**
     *  商品唯一标识
     */
    @Id
    private Long id;

    /**
     *  商品名称
     */
    @Field(type = FieldType.Text)
    private String title;

    /**
     *  分类名称
     */
    @Field(type = FieldType.Keyword)
    private String category;

    /**
     *  商品价格
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     *  图片地址,不作为索引关联
     */
    @Field(type = FieldType.Keyword,index = false)
    private String images;

}
