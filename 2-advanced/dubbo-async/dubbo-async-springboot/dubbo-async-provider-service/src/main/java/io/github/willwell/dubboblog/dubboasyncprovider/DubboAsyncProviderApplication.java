package io.github.willwell.dubboblog.dubboasyncprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboAsyncProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboAsyncProviderApplication.class, args);
    }

}
