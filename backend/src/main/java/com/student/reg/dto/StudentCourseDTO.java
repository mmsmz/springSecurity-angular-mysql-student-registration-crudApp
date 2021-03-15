package com.student.reg.dto;

public class StudentCourseDTO {
    private int studentcourseID;
    private int userId;
    private int courseId;


    public int getStudentcourseID() {
        return studentcourseID;
    }

    public void setStudentcourseID(int studentcourseID) {
        this.studentcourseID = studentcourseID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
