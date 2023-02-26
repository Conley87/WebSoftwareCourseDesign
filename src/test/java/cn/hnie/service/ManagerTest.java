package cn.hnie.service;

import cn.hnie.domain.Result;
import cn.hnie.domain.Student;
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
}
