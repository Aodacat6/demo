package com.example.mongodb.controller;

import com.example.mongodb.entity.ClassRoom;
import com.example.mongodb.service.MongoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author ：songdalin
 * @date ：2020-11-30 下午 06:10
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/mongo")
public class MongodbController {

    @Autowired
    private MongoTestService service;

    @GetMapping("/add/{id}")
    public String add(@PathParam("id") Integer id) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(id);
        classRoom.setName("和利时");
        service.save(classRoom);
        return "ok";
    }

    @GetMapping("/update/{id}")
    public String update(@PathParam("id") Integer id) {
        service.update(id);
        return "ok";
    }

    @GetMapping("/get/{id}")
    public String get(@PathParam("id") Integer id) {
        ClassRoom classRoom = service.findById(id);
        return classRoom.toString();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathParam("id") Integer id) {
        service.deleteById(id);
        return "ok";
    }
}
