package com.example.mongodb.service;

import com.example.mongodb.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：songdalin
 * @date ：2020-11-28 下午 05:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
public class MongoTestService {

    @Autowired
    private MongoTemplate template;

    public void save (ClassRoom classRoom) {
        template.save(classRoom);
    }

    public ClassRoom findById (int id) {
        return template.findById(id, ClassRoom.class);
    }

    public void update (int id) {
        ClassRoom classRoom = template.findById(id, ClassRoom.class);
        classRoom.setName(classRoom.getName() + "21");
        template.save(classRoom);
    }

    public void deleteById(int id) {
        ClassRoom classRoom = template.findById(id, ClassRoom.class);
        template.remove(classRoom);
    }


}
