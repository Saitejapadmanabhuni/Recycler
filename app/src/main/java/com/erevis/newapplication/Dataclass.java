package com.erevis.newapplication;

public class Dataclass {

    public Dataclass(){

    }
    private String Name;

    public String getName() {
        return Name;
    }

    public String getCourse() {
        return Course;
    }

    public String getCollege() {
        return College;
    }

    private String Course;

    public void setName(String name) {
        Name = name;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public void setCollege(String college) {
        College = college;
    }

    private String College;



    public Dataclass(String name, String course, String college) {
        Name = name;
        Course = course;
        College = college;
    }


}
