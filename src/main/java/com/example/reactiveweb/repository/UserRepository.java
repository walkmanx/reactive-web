package com.example.reactiveweb.repository;

import com.example.reactiveweb.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * <p>Title: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2021/1/11 下午 17:34
 */
public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
