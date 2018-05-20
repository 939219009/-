package com.wym.B;

public class JavaCourse {
    Teacher teacher;
    public void setTeacher(Teacher teacher){
        this.teacher=teacher;
    }

    public void JavaCourse(){
        this.teacher.teach("我啥也不会！");
    }
}
