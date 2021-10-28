package com.exercises.Exercise_01;

import com.exercises.ReadFileCsv;

import java.util.List;

public class Exercise_01 {
    public static void main(String[] args) {
        // Câu 1
        List<Student> listStudent = ReadFileCsv.getListStudents();

        // Câu 2
        printTopTenLtStudent(listStudent);

        // Câu 4

    }

    public static void printTopTenLtStudent(List<Student> listStudents) {
        int n = listStudents.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (listStudents.get(j - 1).getLt() < listStudents.get(j).getLt()) {
                    temp = listStudents.get(j - 1);
                    listStudents.set(j - 1, listStudents.get(j));
                    listStudents.set(j, temp);
                }
            }
        }
        System.out.println("Top ten student");
        for (int i = 1; i <= 10; i++) {
            System.out.println(listStudents.get(i));
        }

    }
}
