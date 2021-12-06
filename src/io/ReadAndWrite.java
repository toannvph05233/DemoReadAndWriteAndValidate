package io;

import modules.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<NhanVien> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("nhanvien.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<NhanVien> list = (List<NhanVien>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void write(List<NhanVien> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("nhanvien.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
