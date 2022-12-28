package cn.hnie.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    String login(String id);
}
