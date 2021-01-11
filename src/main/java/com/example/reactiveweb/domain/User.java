package com.example.reactiveweb.domain;

import lombok.Data;

/**
 * <p>Title: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2020/8/14 上午 11:22
 */
@Data
public class User {

    /**
     * 用户标识
     */
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;

}
