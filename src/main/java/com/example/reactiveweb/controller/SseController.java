package com.example.reactiveweb.controller;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>Title: 服务器推送事件示例</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2020/8/14 上午 11:53
 */
@RestController
@RequestMapping("/sse")
public class SseController {

    @RequestMapping("/random")
    public Flux<ServerSentEvent<Integer>> randomNumber(){
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data -> ServerSentEvent.<Integer>builder()
                    .event("random")
                    .id(Long.toString(data.getT1()))
                    .data(data.getT2())
                    .build());
    }
}
