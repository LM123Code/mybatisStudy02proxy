package com.mybatis02proxy.mapper;

import com.mybatis02proxy.entities.Student;
import java.util.List;
/**
 * @author LM_Code
 * @create 2019-03-31-16:30
 */
public interface StudentMapper {
    public Student selectStudentById(int id);
    public List<Student> selectStudentsByName(String name);
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudentById(int id);
}
