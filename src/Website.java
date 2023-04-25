import java.util.Scanner;

public class Website {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choice;
        do {
            System.out.println("\u001B[32m"+"""
                  <><><><><><><><><><><><><><><><><><><><>  
                  <>                                    <> 
                  <>    0.Thoát !!!                     <>
                  <>                                    <>
                  <>    1.Đăng kí tài khoản !!!         <>
                  <>                                    <>
                  <>    2.Đăng Nhập !!!                 <>
                  <>                                    <>
                  <><><><><><><><><><><><><><><><><><><><>
                    """+"\u001B[0m");
            System.out.println();
            System.out.println("\u001B[32m" +"Mời chọn chức năng !!!" + "\u001B[0m");
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
