package com.wym.A;

public class JavaCource {
     private Teacher teacher;

     public void setTeacher(Teacher teacher){
         this.teacher=teacher;
}
     public void JavaCource(){
         this.teacher.teach("Spring IOC");
     }
}
