package com.john.sc.dao.mapper;


import com.john.sc.dao.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert({
            "insert into student(name,score) values(#{name},#{score})"
    })
    int insert(Student student);
    @Select({
            "select * from student"
    })
    @Results(id = "all_column",value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "name",property = "name" ),
            @Result(column = "score",property = "score" )

    })
    List<Student> selectAll();
}
