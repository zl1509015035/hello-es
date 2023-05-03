package com.kuafu.springes.esdao;

import com.kuafu.springes.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author juanwang
 * @create 2023/5/3 14:39
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESProductDaoTest {

    @Autowired
    private ProductDao productDao;

    /**
     * 新增商品
     */
    @Test
    public void saveTest(){
        Product product = new Product();
        product.setId(1L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(4999.0);
        product.setImages("http://www.huawei/hw.jpg");
        productDao.save(product);
    }
}
