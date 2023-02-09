package cn.hnie.domain;

public class Adjust {
    String stuId=null;
    String name=null;
    String subId=null;
    String title=null;
    String teaName =null;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Override
    public String toString() {
        return "Adjust{" +
                "stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                ", subId='" + subId + '\'' +
                ", title='" + title + '\'' +
                ", teaName='" + teaName + '\'' +
                '}';
    }
}
