package com.exercises.tests;

import com.exercises.Exercise_01.Exercise_01;
import com.exercises.Exercise_01.Student;
import com.exercises.Exercise_02.Exercise_02;
import com.exercises.ReadFileCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UnitTest_Exercise_02 {
    @Test
    @DisplayName("Check hàm kiểm tra regex match với email là @gmail")
    public void shouleBeTrueEmailValid() {
        String email = "vunguyen1993@gmail.com";
        Assertions.assertTrue(Exercise_02.matchEmail(email));
    }

    @Test
    @DisplayName("Check hàm kiểm tra regex match với email là @gmail")
    public void shouleBeFalseEmailValid() {
        String email = "vunguyen1993@yahoo.com";
        Assertions.assertFalse(Exercise_02.matchEmail(email));
    }


}
