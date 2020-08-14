package com.example.reactiveweb;

import com.example.reactiveweb.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 * org.springframework.test.web.reactive.server.WebTestClient 可以测试 WebFlux 服务器
 */
public class UserControllerTest {

    private final WebTestClient client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();

    @Test
    public void testCreateUser() throws Exception {
        final User user = new User();
        user.setId("123");
        user.setName("Test123");
        user.setEmail("test123@example.org");
        client.post().uri("/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("name").isEqualTo("Test123");
    }
}