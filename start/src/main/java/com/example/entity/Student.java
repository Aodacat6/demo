package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ：songdalin
 * @date ：2020-11-17 下午 09:37
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Entity
@Table(name = "student")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -3841645618250374000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "no")
    private Integer no;

    public String outName() {
        System.out.println("=================" + this.name);
        return name;
    }
}
