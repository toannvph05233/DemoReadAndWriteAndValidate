import io.ReadAndWrite;
import modules.NhanVien;
import modules.validate.ValidateNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<NhanVien> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        list = ReadAndWrite.read();
        while (true) {
            System.out.println("1. show");
            System.out.println("2. Thêm");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    for (NhanVien nv : list) {
                        System.out.println(nv);
                    }
                    break;
                case 2:
                    list.add(createNhanVien(list));
                    ReadAndWrite.write(list);
                    break;
            }
        }
    }

    public static NhanVien createNhanVien(List<NhanVien> list) {
        int id = ValidateNhanVien.validateId(list);
        String name = ValidateNhanVien.validateName();
        return new NhanVien(id, name);
    }


}
