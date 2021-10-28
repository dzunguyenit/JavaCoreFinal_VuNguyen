package com.exercises;

import com.exercises.Exercise_01.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFileCsv {
    public static List<Student> getListStudents() {
        List<Student> result = new ArrayList<>();
        File file = new File(System.getProperty("user.dir") + "/data.csv");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(line);
            //Skip header
            if (line.contains("ID,Name,Email,Bonus,Report,App,LT"))
                continue;
            else {
                List<String> data = Arrays.asList(line.split(","));
                Student s = new Student();
                s.setId(Integer.parseInt(data.get(0)));
                s.setName(data.get(1));
                s.setEmail(data.get(2));
                s.setBonus(Float.parseFloat(data.get(3)));
                s.setReport(Float.parseFloat(data.get(4)));
                s.setApp(Float.parseFloat(data.get(5)));
                s.setLt(Float.parseFloat(data.get(6)));
                result.add(s);
            }
        }
        return result;
    }
}
