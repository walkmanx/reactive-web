package com.example.reactiveweb.service;

import com.example.reactiveweb.common.exception.ServiceException;
import com.example.reactiveweb.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2020/8/14 上午 11:24
 */
@Service
public class UserService {

    private final Map<String, User> data = new ConcurrentHashMap<>();

    public Flux<User> list(){
        return Flux.fromIterable(this.data.values());
    }

    public Flux<User> getById(final Flux<String> ids){
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    public Mono<User> getById(final String id){
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new ServiceException()));
    }

    public Mono<User> createOrUpdate(final  User user){
        if(user != null){
            this.data.put(user.getId(),user);
        }
        return Mono.just(user);
    }

    public Mono<User> delete(final String id){
        return Mono.justOrEmpty(this.data.remove(id));
    }


}
