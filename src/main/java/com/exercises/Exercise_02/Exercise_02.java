package com.exercises.Exercise_02;

import com.exercises.Exercise_01.Student;
import com.exercises.ReadFileCsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_02 {

    //Câu 1: Regex = \b[a-zA-Z][\w\-\.]{0,63}\@(gmail|outlook).[a-zA-Z]{2,}(\.[a-zA-Z]{2,})?\b

    public static void main(String[] args) {

        //Câu 1: Regex = \b[a-zA-Z][\w\-\.]{0,63}\@(gmail|outlook).[a-zA-Z]{2,}(\.[a-zA-Z]{2,})?\b

        List<Student> listStudent = ReadFileCsv.getListStudents();

        //Xây dựng hàm liệt kê thông tin các sinh viên có email là gmail
        List<Student> listGmail = new ArrayList<>();
        System.out.println("2. Liệt kê thông tin các sinh viên có email là gmail");
        for (int i = 0; i < listStudent.size(); i++) {
            if (matchEmail(listStudent.get(i).getEmail())) {
                listGmail.add(listStudent.get(i));
            }
        }
        for (Student student : listGmail) {
            System.out.println(student);
        }
        //      Chuyển thông tin các sinh viên có email là outlook (II.2) vào tập
        //      tin outlook.bin, sử dụng kỹ thuật Serialization.
        System.out.println("3. Chuyển thông tin các sinh viên có email là outlook (II.2) vào tập tin outlook.bin, sử dụng kỹ thuật Serialization.");
        try {
            FileOutputStream fos = new FileOutputStream("outlook.bin");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            for (Student sv : listGmail) {
                dos.writeInt(sv.getId());
                dos.writeUTF(sv.getName());
                dos.writeUTF(sv.getEmail());
                dos.writeDouble(sv.getBonus());
                dos.writeDouble(sv.getReport());
                dos.writeDouble(sv.getApp());
                dos.writeDouble(sv.getLt());
                dos.writeDouble(sv.getFinalPoint());
            }
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//       4. Xây dựng hàm đọc thông tin các sinh viên ở II.3 lên màn hình console
        System.out.println("4. Xây dựng hàm đọc thông tin các sinh viên ở II.3 lên màn hình console");
        try {
            FileInputStream fis = new FileInputStream("outlook.bin");
            DataInputStream dataInput = new DataInputStream(fis);
            while (dataInput.available() > 0) {
                int Id = dataInput.readInt();
                String name = dataInput.readUTF();
                String email = dataInput.readUTF();
                double bonus = dataInput.readDouble();
                double report = dataInput.readDouble();
                double app = dataInput.readDouble();
                double lt = dataInput.readDouble();
                double finalPoint = dataInput.readDouble();
                Student listStudentOutlook = new Student(Id, name, email, bonus, report, app, lt, finalPoint);
                System.out.println(listStudentOutlook);
            }
            dataInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean matchEmail(String text) {
        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@gmail.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");
        Matcher matcher = pattern.matcher(text);
        return (matcher.find()) ? true : false;
    }

    public static boolean matchEmailOutlook(String text) {
        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@outlook.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");
        Matcher matcher = pattern.matcher(text);
        return (matcher.find()) ? true : false;
    }

    public static boolean matchEmailGmailOrOutlook(String text) {
        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@(gmail|outlook).[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");
        Matcher matcher = pattern.matcher(text);
        return (matcher.find()) ? true : false;
    }

}
