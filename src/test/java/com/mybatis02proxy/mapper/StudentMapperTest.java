package com.mybatis02proxy.mapper;

import com.mybatis02proxy.entities.Student;
import com.mybatis02proxy.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-03-31-16:46
 */
public class StudentMapperTest {
    StudentMapper studentMapper = null;
    SqlSession sqlSession = null;
    StudentMapper mapper;
    @Before
    public void before(){
        sqlSession = SqlSessionFactoryUtil.openSession(true);
        mapper = sqlSession.getMapper(StudentMapper.class);
    }
    @After
    public void after(){
        SqlSessionFactoryUtil.closeSession(sqlSession);
    }
    @Test
    public void testSelectStudentById() throws Exception {
        Student student = mapper.selectStudentById(1);
        System.out.println(student);
        Assert.assertNotNull(student);
    }
    @Test
    public void testSelectStudentsByName(){
        List<Student> students = mapper.selectStudentsByName("o");
        System.out.println(students);
        Assert.assertNotNull(students);
    }
    @Test
    public void testInsertStudent(){
        Student student = new Student();
        student.setName("yangluo");
        Assert.assertEquals(1, mapper.insertStudent(student));
        System.out.println(student);
    }
    @Test
    public void testUpdateStudent(){
        Student student = new Student();
        student.setId(17);
        student.setName("yangluo");
        student.setName("boy");
        Assert.assertEquals(1, mapper.updateStudent(student));
    }
    @Test
    public void testDeleteStudent(){
        Assert.assertEquals(1, mapper.deleteStudentById(17));
    }
}
