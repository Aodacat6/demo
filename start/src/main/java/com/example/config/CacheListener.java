package com.example.config;

import com.example.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author ：songdalin
 * @date ：2020-11-24 上午 10:51
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class CacheListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @EventListener//(condition = "#{student != null}")
    public void handleEvent(String str) throws IOException {
        if (StringUtils.isEmpty(str)) {
            System.out.println("not black");
        }
        Student student = objectMapper.readValue(str, Student.class);

    }
}
