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
}
