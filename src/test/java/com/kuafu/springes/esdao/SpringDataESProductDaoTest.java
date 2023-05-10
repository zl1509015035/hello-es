package com.kuafu.springes.esdao;

import com.kuafu.springes.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    public void saveTest() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(4999.0);
        product.setImages("http://www.huawei/hw.jpg");
        productDao.save(product);
    }


    @Test
    public void updateTest() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("小米手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.xiaomi/xm.jpg");
        productDao.save(product);
    }

    @Test
    public void findByIdTest() {
        Product product = productDao.findById(11L).orElse(null);
        System.out.println(product);
    }


    @Test
    public void findAll() {
        Iterable<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void deleteTest() {
        Product product = new Product();
        product.setId(1L);
        productDao.delete(product);
    }

    @Test
    public void saveAllTest() {
        List<Product> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setTitle("[" + i + "]小米手机");
            product.setCategory("手机");
            product.setPrice(3999.9);
            product.setImages("http://www.xiaomi/xm.jpg");
            list.add(product);
        }
        productDao.saveAll(list);
    }

    @Test
    public void findByPageableTest(){
        //设置排序(排序方式，正序/倒序，排序的id)
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        //当前页，第一页从0开始，1表示第二页
        int from = 0;
        //每页显示多少条
        int size = 5;

        //设置查询分页
        PageRequest pageRequest = PageRequest.of(from, size, sort);

        //分页查询
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product product : productPage.getContent()){
            System.out.println(product);
        }

    }
}
