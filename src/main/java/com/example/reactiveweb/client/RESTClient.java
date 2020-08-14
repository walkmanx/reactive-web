package com.example.reactiveweb.client;

import com.example.reactiveweb.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * <p>Title: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2020/8/14 下午 14:44
 */
public class RESTClient {

    public static void main(String[] args) {
        final User user = new User();
        user.setId("001");
        user.setName("Test");
        user.setEmail("test@example.org");

        final WebClient webClient = WebClient.create("http://localhost:8080/user/save");
        final Mono<User> createUser = webClient.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user),User.class)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));
        System.out.println(createUser.block());

    }



}
