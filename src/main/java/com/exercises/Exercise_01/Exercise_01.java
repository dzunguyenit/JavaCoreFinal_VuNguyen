package com.exercises.Exercise_01;

import com.exercises.ReadFileCsv;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise_01 {
    public static void main(String[] args) {
        // Câu 1
        List<Student> listStudent = ReadFileCsv.getListStudents();

        // Câu 2
        List<Student> listTopTenLT = getListTopTenLtStudent(listStudent);
        for (Student student : listTopTenLT) {
            System.out.println(student);
        }


        // Câu 4

        // Set finalPoint
        for (Student student : listStudent) {
            student.setFinalPoint(student.getFinalPoint());
        }

        //3. Tính điểm tổng kết cho từng sinh viên theo công thức: bonus 10%,
        //report 30%, app 15%, lý thuyết 45%; điểm tổng kết được làm tròn đến
        //0.5 (ví dụ: 7.37 -> 7.5, 6.2 -> 6.0)
        for (Student student : listStudent) {
            System.out.println(student);
        }

        System.out.println("3. Calculate final points for all list students");
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i));
        }

//4. Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất lên giao diện
//console
        System.out.println("4.  Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất lên giao diện");
        List<Student> listFinalPointAscending = getListMinFinalPoint(listStudent);
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i));
        }

//5.
        try {
            FileOutputStream fos = new FileOutputStream("output.csv");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            for (Student sv : listStudent) {
                dos.writeInt(sv.getId());
                dos.writeUTF(sv.getName());
                dos.writeUTF(sv.getEmail());
                dos.writeDouble(sv.getBonus());
                dos.writeDouble(sv.getReport());
                dos.writeDouble(sv.getApp());
                dos.writeDouble(sv.getLt());
            }
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Student> getListTopTenLtStudent(List<Student> listStudents) {
        List<Student> listTopTenLT = new ArrayList<>();
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
        for (int i = 1; i <= 10; i++) {
            listTopTenLT.add(listStudents.get(i));
        }
        return listTopTenLT;
    }

    public static List<Student> getListMinFinalPoint(List<Student> listStudent) {
        List<Student> listFinalPointAscending = new ArrayList<>();
        int n = listStudent.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (listStudent.get(j - 1).getFinalPoint() > listStudent.get(j).getFinalPoint()) {
                    temp = listStudent.get(j - 1);
                    listStudent.set(j - 1, listStudent.get(j));
                    listStudent.set(j, temp);
                }
            }
        }
        for (int i = 1; i <= 10; i++) {
            listFinalPointAscending.add(listStudent.get(i));
        }
        return listFinalPointAscending;
    }

}
