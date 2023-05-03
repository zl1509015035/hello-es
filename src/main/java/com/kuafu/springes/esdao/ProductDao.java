package com.kuafu.springes.esdao;

import com.kuafu.springes.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author juanwang
 * @create 2023/5/3 14:24
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {
}
