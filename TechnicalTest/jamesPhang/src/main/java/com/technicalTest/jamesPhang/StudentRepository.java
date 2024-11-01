package com.technicalTest.jamesPhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.swing.tree.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.technicalTest.jamesPhang.Config;

class Student{

    public String name;
    public String gender;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
    }

    public void createStudent(String name, String gender) {
        template.update("INSERT INTO student(id, name, gender) VALUES (?,?,?)",null, name, gender);
    }
        public List<Student> findStudentByName(String nameStartsWith) {

        String sql = "SELECT name, gender FROM student WHERE name LIKE ?";
            List<Student> students = template.query(sql, new Object[]{nameStartsWith + "%"}, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    String name = rs.getString("name");
                    String gender = rs.getString("gender");
                    return new Student(name, gender);
                }
        });

        return students;
    }
}