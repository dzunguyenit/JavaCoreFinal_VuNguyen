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

public class UnitTest_Exercise_02 {
    //    @ParameterizedTest
//    @ValueSource(strings = {"", "     "})
//    @DisplayName("Should return true for null or blank string")
//    void shouldReturnTrueForNullOrBlankString(String input) {
//        assertTrue(Params.isBlank(input));
//    }
//
//    @ParameterizedTest
//    @NullAndEmptySource
//    @DisplayName("Should return true for null input")
//    void shouldReturnTrueForNull(String input) {
//        assertTrue(Params.isBlank(input));
//    }
//
//    @ParameterizedTest
//    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
//    // @EnumSource(
//    // value = Month.class,
//    // names = { "APRIL", "JUNE" },
//    // mode = EnumSource.Mode.EXCLUDE)
//    @DisplayName("Should always between 1 and 12")
//    void shouldBetween1And12(Month month) {
//        int value = month.getValue();
//        assertTrue(value >= 1 && value <= 12);
//    }
    @Test
    @DisplayName("Check size list = 10 sinh viên có điểm thi lý thuyết cao nhất")
    void checkSizeListTenStudent() {
        List<Student> listStudent = ReadFileCsv.getListStudents();
        List<Student> listTopTenLT = Exercise_01.getListTopTenLtStudent(listStudent);
        int size = listTopTenLT.size();
        Assertions.assertEquals(10, size);
    }
}
