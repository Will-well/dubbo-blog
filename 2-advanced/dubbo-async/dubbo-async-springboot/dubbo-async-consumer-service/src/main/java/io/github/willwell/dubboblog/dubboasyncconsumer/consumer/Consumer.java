package io.github.willwell.dubboblog.dubboasyncconsumer.consumer;

import io.github.willwell.dubboblog.dubboasyncprovider.dubbo.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
@Component
@Slf4j
public class Consumer implements CommandLineRunner {
    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {

        CompletableFuture future = RpcContext.getContext().asyncCall(() -> demoService.sayHello("async world"));
        log.warn("期待日志先出现：{}", future.isDone());
        log.info("获取结果：{}", future.get());

        // 同步定时调用
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            doConsume();
        }, 1, 2, TimeUnit.SECONDS);
    }

    private void doConsume() {
        String result = demoService.sayHello("world");
        log.info("Receive result ======> {}", result);
    }
}
