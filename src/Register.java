import ctroller.Manage;
import view.Check;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Register {
    public static void main(String[] args) {
        Check check = new Check();
         Logger LOGGER =Logger.getLogger(String.valueOf(Register.class));
        // Nhập thông tin đăng ký từ người dùng
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập Email:");
        String email = input.nextLine();
        while (!check.checkEmail(email)) {
           // System.out.println("Email không đúng định dạng, nhập lại Email:");
             LOGGER.info("Email không đúng định dạng, nhập lại Email !!!");
            email = input.nextLine();
        }

        System.out.println("Nhập mật khẩu: ");
        String password = input.nextLine();
        while (!check.checkPassword(password)) {
           // System.out.println("Phải chứa ít nhất 1 ký tự số từ 0 – 9,ít nhất chữ thường ,ít nhất 1 ký tự chữ hoa, ít nhất 1 ký tự đặc biệt.");
            LOGGER.info("Phải chứa ít nhất 1 ký tự số từ 0 – 9,ít nhất chữ thường ,ít nhất 1 ký tự chữ hoa, ít nhất 1 ký tự đặc biệt.");
            password = input.nextLine();
        }

        boolean isPassword = false;
        while (!isPassword) {
            System.out.println("Nhập lại mật khẩu !!! ");
            String password1 = input.nextLine();

            if (password1.equals(password)) {
                try {
                    // Lưu thông tin người dùng vào tệp
                    FileWriter writer = new FileWriter("users.txt", true);
                    writer.write(email + "," + password + "\n");
                    writer.close();
                    System.out.println("Đăng ký thành công!");
                    isPassword=true;  // điều kiện thoát vòng lặp
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
              //  System.out.println("Mật khẩu không đúng !!!");
                LOGGER.info("Mật khẩu không đúng !!!");
            }
        }
    }
}