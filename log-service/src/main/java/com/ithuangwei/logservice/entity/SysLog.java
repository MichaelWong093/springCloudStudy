package com.ithuangwei.logservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/20 10:30
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SysLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //用户名
    @Column
    private String username;
    //用户操作
    @Column
    private String operation;
    //请求方法
    @Column
    private String method;
    //请求参数
    @Column
    private String params;
    //IP地址
    @Column
    private String ip;
    //创建时间
    @Column
    private Date createDate;
}
