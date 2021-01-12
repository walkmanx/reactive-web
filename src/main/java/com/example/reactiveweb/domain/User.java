package com.example.reactiveweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    /**
     * 用户标识
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;

}
