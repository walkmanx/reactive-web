package com.example.reactiveweb.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * 实现接口 org.springframework.web.reactive.socket.WebSocketHandler 来处理 WebSocket 通讯
 */
@Component
@Slf4j
public class EchoHandler implements WebSocketHandler {

    /**
     *
     * @param session WebSocketSession 的对象，可以用来获取客户端信息、接送消息和发送消息
     * @return
     */
    @Override
    public Mono<Void> handle(final WebSocketSession session) {
        log.info("有客户端连接到服务器");
        return session.send(
                session.receive()
                        .map(msg -> {
                            log.info("收到客户端发送的消息");
                            return session.textMessage("ECHO -> " + msg.getPayloadAsText());
                        }));
    }
}