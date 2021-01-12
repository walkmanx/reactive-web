package com.example.reactiveweb.service.impl;

import com.example.reactiveweb.common.exception.ServiceException;
import com.example.reactiveweb.domain.User;
import com.example.reactiveweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl {

    private final Map<String, User> data = new ConcurrentHashMap<>();

    @Autowired
    private UserRepository userRepository;

    public Flux<User> list(){
        return userRepository.findAll();
    }

    public Flux<User> getById(final Flux<Integer> ids){
        return userRepository.findAllById(ids);
    }

    public Mono<User> getById(final Integer id){
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new ServiceException()));
    }

    public Mono<User> createOrUpdate(final  User user){
        return userRepository.save(user);
    }

    public Mono<Void> delete(final Integer id){
        return userRepository.deleteById(id);
    }


}
