package com.example.reactiveweb.service.impl;

import com.example.reactiveweb.common.exception.ServiceException;
import com.example.reactiveweb.domain.User;
import com.example.reactiveweb.service.UserService;
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
public class UserMapServiceImpl implements UserService {

    private final Map<Integer, User> data = new ConcurrentHashMap<>();

    @Override
    public Flux<User> list(){
        return Flux.fromIterable(this.data.values());
    }

    @Override
    public Flux<User> getById(Flux<Integer> ids){
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    @Override
    public Mono<User> getById(Integer id) {
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new ServiceException()));
    }

    @Override
    public Mono<User> createOrUpdate(User user){
        if(user != null){
            this.data.put(user.getId(),user);
        }
        return Mono.just(user);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        this.data.remove(id);
        return Mono.justOrEmpty(null);
    }



}
