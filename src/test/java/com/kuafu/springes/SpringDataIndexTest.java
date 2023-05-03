package com.kuafu.springes;

import com.kuafu.springes.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author juanwang
 * @create 2023/5/3 14:36
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataIndexTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void createIndex() {
        log.info("创建索引成功");
    }

    public void deleteIndex() {
        boolean b = elasticsearchRestTemplate.deleteIndex(Product.class);

        log.info("delete index status:{}", b == true ? "success" : "fail");
    }
}
