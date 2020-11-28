package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author ：songdalin
 * @date ：2020-11-17 下午 09:50
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByNo(int no);

    @Query("delete from Student a where a.no = :no")
    @Modifying
    int deleteByNo(@Param("no") int no);
}
