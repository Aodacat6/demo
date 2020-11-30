package com.example.mongodb.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author ：songdalin
 * @date ：2020-11-28 下午 05:03
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
public class ClassRoom {

    @Id
    private int id;

    private String name;
}
