import ctroller.Manage;
import view.Check;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Register {
    public static void register() {
        Check check = new Check();
        // Logger LOGGER =Logger.getLogger(String.valueOf(Register.class));
        // Nhập thông tin đăng ký từ người dùng
        Scanner input = new Scanner(System.in);

        System.out.println("\u001B[32m"+"Nhập Email:"+"\u001B[0m");
        String email = input.nextLine();
        while (!check.checkEmail(email)) {
            System.out.println("\u001B[31m"+"Email không đúng định dạng, nhập lại Email:"+"\u001B[0m");
             //LOGGER.info("Email không đúng định dạng, nhập lại Email !!!");
            email = input.nextLine();
        }


        System.out.println("\u001B[32m"+"Nhập mật khẩu: "+"\u001B[0m");
        String password = input.nextLine();
        while (!check.checkPassword(password)) {
            System.out.println("\u001B[31m"+"Phải chứa ít nhất 1 ký tự số từ 0 – 9,ít nhất chữ thường ,ít nhất 1 ký tự chữ hoa, ít nhất 1 ký tự đặc biệt."+"\u001B[0m");
           // LOGGER.info("Phải chứa ít nhất 1 ký tự số từ 0 – 9,ít nhất chữ thường ,ít nhất 1 ký tự chữ hoa, ít nhất 1 ký tự đặc biệt.");
            password = input.nextLine();
        }

        boolean isPassword = false;
        while (!isPassword) {
            System.out.println("\u001B[32m"+"Nhập lại mật khẩu !!! "+"\u001B[0m");
            String password1 = input.nextLine();

            if (password1.equals(password)) {
                try {
                    // Lưu thông tin người dùng vào tệp
                    FileWriter writer = new FileWriter("users.txt", false);
                    writer.write(email + "," + password1 + "\n");
                    writer.close();
                    System.out.println("\u001B[32m"+"Đăng ký thành công!"+"\u001B[0m");
                    isPassword=true;  // điều kiện thoát vòng lặp
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("\u001B[31m"+"Mật khẩu không đúng !!!"+"\u001B[0m");
                //LOGGER.info("Mật khẩu không đúng !!!");
            }
        }
    }
}