package com.exercises.tests;

import com.exercises.Exercise_01.Exercise_01;
import com.exercises.Exercise_01.Student;
import com.exercises.Exercise_02.Exercise_02;
import com.exercises.ReadFileCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitTest_Exercise_02 {
    @Test
    @DisplayName("Check hàm kiểm tra regex match với email là @gmail")
    public void shouleBeTrueGmailValid() {
        String email = "vunguyen1993@gmail.com";
        Assertions.assertTrue(Exercise_02.matchEmail(email));
    }

    @Test
    @DisplayName("Check hàm kiểm tra regex không match với email là @gmail")
    public void shouleBeFalseGmailValid() {
        String email = "vunguyen1993@yahoo.com";
        Assertions.assertFalse(Exercise_02.matchEmail(email));
    }

    @Test
    @DisplayName("Check hàm kiểm tra regex match với email là @outlook")
    public void shouleBeTrueOutlookValid() {
        String email = "vunguyen1993@outlook.com";
        Assertions.assertTrue(Exercise_02.matchEmailOutlook(email));
    }

    @Test
    @DisplayName("Check hàm kiểm tra regex không match với email là @outlook")
    public void shouleBeFalseOutlookValid() {
        String email = "vunguyen1993@yahoo.com";
        Assertions.assertFalse(Exercise_02.matchEmailOutlook(email));
    }

    @Test
    @DisplayName("Check hàm kiểm tra regex match với email là @gmail hoặc @outlook")
    public void shouleBeTrueGmailOrOutlookValid() {
        List<String> listEmail = Arrays.asList("vunguyen1993@outlook.com", "vunguyen1993@gmail.com", "vunguyen@gmail.com");
        for (String email : listEmail) {
            Assertions.assertTrue(Exercise_02.matchEmailGmailOrOutlook(email));
        }

    }

    @Test
    @DisplayName("Check hàm kiểm tra regex không match với email là @gmail hoặc @outlook")
    public void shouleBeFalseGmailOrOutlookValid() {
        List<String> listEmail = Arrays.asList("vunguyen1993@gg.com", "vunguyen1993@onemount.com", "vunguyen1993@yahoo.com");
        for (String email : listEmail) {
            Assertions.assertFalse(Exercise_02.matchEmailGmailOrOutlook(email));
        }
    }


}
