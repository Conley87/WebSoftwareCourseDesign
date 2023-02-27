package cn.hnie.service;

import cn.hnie.domain.Result;
import cn.hnie.domain.Student;
import cn.hnie.domain.StudentSubject;
import cn.hnie.domain.Subject;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.Test;

import java.util.List;

public class ManagerTest {
    @Test
    public void test() {
        List<Subject> subjects = StudentService.queryAllSubject();
        System.out.println(JSONObject.toJSONString(subjects));
//        subjects.forEach(System.out::println);
    }
    @Test
    public void  aaa() {
        String s="{\"name\":\"aaa\",\"password\":\"123\",\"studentId\":\"01234\"}";
        Student student = JSONObject.parseObject(s, Student.class);
//        Student student = new Student();
//        student.setStudentId("01234");
//        student.setPassword("123");
//        student.setName("aaa");
        System.out.println(JSONObject.toJSONString(student));
        ManagerService.insertStudent(student);
    }
    @Test
    public void bbb() {
        List<StudentSubject> list= TeacherService.queryStudent("0102");
        list.forEach(System.out::println);
    }
    @Test
    public void testAdjust() {
        ManagerService.adjust();
    }
    @Test
    public void testaaa() {
        Student student = StudentService.queryInfo("0101");
        System.out.println(student);
        Result result;
        result = new Result("200", List.of(student).toArray(), "学生查询成功");
        System.out.println(JSONObject.toJSONString(result));
    }
}
