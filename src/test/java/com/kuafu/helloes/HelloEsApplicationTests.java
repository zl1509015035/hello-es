package com.kuafu.helloes;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HelloEsApplicationTests {

    @Test
    public void testConnect() throws IOException {
        RestHighLevelClient client = EsClient.getHighLevelClient();
        System.out.println(client);
        client.close();
    }

}
