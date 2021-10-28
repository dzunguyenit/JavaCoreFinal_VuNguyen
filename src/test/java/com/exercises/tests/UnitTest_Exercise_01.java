package com.exercises.tests;

import com.exercises.Exercise_01.Exercise_01;
import com.exercises.Exercise_01.Student;
import com.exercises.ReadFileCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.exercises.Exercise_01.Exercise_01.getListTopTenLtStudent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest_Exercise_01 {
    @Test
    @DisplayName("Check size list = 10 sinh viên có điểm thi lý thuyết cao nhất")
    void checkSizeListTenStudent() {
        List<Student> listStudent = ReadFileCsv.getListStudents();
        List<Student> listTopTenLT = Exercise_01.getListTopTenLtStudent(listStudent);
        int size = listTopTenLT.size();
        Assertions.assertEquals(10, size);
    }

    @Test
    @DisplayName("Check hàm sắp sếp giảm dần của list top 10 sinh viên")
    void checkListTenDescending() {
        List<Student> listStudent = ReadFileCsv.getListStudents();
        List<Student> listTopTenLT = Exercise_01.getListTopTenLtStudent(listStudent);
        for (int i = 0; i < listTopTenLT.size() - 1; i++) {
            Assertions.assertTrue(listTopTenLT.get(i).getLt() >= listTopTenLT.get(i + 1).getLt());
        }

    }

    @Test
    @DisplayName("Check hàm tính điểm tổng kết")
    public void checkShouleBeEqualFuctionCalculateFinalPoint() {
        Student student = new Student();
        student.setBonus(5);
        student.setReport(6);
        student.setApp(7);
        student.setLt(8);
        Assertions.assertEquals(6.45, student.getFinalPoint());
    }

    @Test
    @DisplayName("Check hàm tính điểm tổng kết không bằng giá trị của hàm")
    public void checkShouleNotEqualFuctionCalculateFinalPoint() {
        Student student = new Student();
        student.setBonus(5);
        student.setReport(6);
        student.setApp(7);
        student.setLt(10);
        Assertions.assertNotEquals(6.40, student.getFinalPoint());
    }
}
