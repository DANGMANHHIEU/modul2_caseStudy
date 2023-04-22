import java.util.Scanner;

public class Website {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                  <><><><><><><><><><><><><><><><><><><><>  
                  <>                                    <> 
                  <>    0.Thoát !!!                     <>
                  <>                                    <>
                  <>    1.Đăng kí tài khoản !!!         <>
                  <>                                    <>
                  <>    2.Đăng Nhập !!!                 <>
                  <>                                    <>
                  <><><><><><><><><><><><><><><><><><><><>
                    """);
            System.out.println();
            System.out.println("Mời chọn chức năng !!!");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Register.register();
                    break;
                case 2:
                    LogIn.logIn();
                    break;
            }

        }while (choice!=0);

    }
}
