package com.example.librarymanagmentsystem.RequestDocs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyPhoneNoRequest {

    private Integer studentId;
    private Integer newPhoneNo;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getNewPhoneNo() {
        return newPhoneNo;
    }

    public void setNewPhoneNo(Integer newPhoneNo) {
        this.newPhoneNo = newPhoneNo;
    }
}
