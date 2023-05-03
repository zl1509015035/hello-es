package com.kuafu.springes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author juanwang
 * @create 2023/5/3 14:14
 */
@SpringBootApplication(scanBasePackages = {"com.kuafu.springes"})
public class SpringDataElasticSearchMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataElasticSearchMainApplication.class,args );
    }
}
