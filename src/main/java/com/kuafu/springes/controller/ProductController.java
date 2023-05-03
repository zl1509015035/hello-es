package com.kuafu.springes.controller;

import com.kuafu.springes.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author juanwang
 * @create 2023/5/3 14:28
 */
@RestController
@RequestMapping("/es")
public class ProductController {


    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @PostMapping("/删除索引")
    public String deleteIndex() {
        if (elasticsearchRestTemplate.deleteIndex(Product.class)) {
            return "删除成功";
        }
        return "删除失败";
    }




}
