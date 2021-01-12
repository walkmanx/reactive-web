package com.example.reactiveweb.service;

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
public interface UserService {

    /**
     * 查询用户列表
     *
     * @return
     */
    Flux<User> list();

    /**
     * 根据用户ids查询用户列表
     * @param ids
     * @return
     */
    Flux<User> getById(final Flux<Integer> ids);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Mono<User> getById(final Integer id);

    /**
     * 保存或更新用户
     * @param user
     * @return
     */
    Mono<User> createOrUpdate(final  User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Mono<Void> delete(final Integer id);


}
