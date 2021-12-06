package modules.validate;

import modules.NhanVien;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNhanVien {
    static Scanner scanner = new Scanner(System.in);

    public static int validateId(List<NhanVien> list) {
        System.out.println("Nhập id");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            for (NhanVien nv : list) {
                if (nv.getId() == id) {
                    return validateId(list);
                }
            }
            return id;
        } catch (Exception e) {
            return validateId(list);
        }
    }

    public static String validateName() {
        int countName = 1;
        String regex = "^[A-Z][a-z]{2,}$";
        while (countName < 4) {
            System.out.println("Nhập name");
            String name = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                return name;
            }
            countName++;
        }
        return null;
    }
}
