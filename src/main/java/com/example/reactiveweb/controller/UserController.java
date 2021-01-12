package com.example.reactiveweb.controller;

import com.example.reactiveweb.common.exception.ServiceException;
import com.example.reactiveweb.domain.User;
import com.example.reactiveweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * <p>Title: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2020/8/14 上午 11:31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Resource not found")
    @ExceptionHandler(ServiceException.class)
    public void notFound(){

    }

    @GetMapping("/list")
    public Flux<User> list(){
        return this.userService.list();
    }

    public Mono<User> getById(@PathVariable("id") Integer id){
        return this.userService.getById(id);
    }

    @PostMapping("/save")
    public Mono<User> save(@RequestBody User user){
        return this.userService.createOrUpdate(user);
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") Integer id,@RequestBody User user){
        Objects.requireNonNull(user);
        user.setId(id);
        return this.userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        return this.userService.delete(id);
    }

}
