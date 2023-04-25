package view;

import ctroller.Manage;
import model.Address;
import model.Scores;
import model.Student;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {
   // public static List<Student> studentList = new ArrayList<>();
   public static Manage manage = new Manage();
    //private static final Logger LOGGER =Logger.getLogger(String.valueOf(Manage.class));

     //thêm sinh viên
    public static void Add(){
        Check check=new Check();
        Scanner sc= new Scanner(System.in);
        System.out.println("\u001B[32m"+"Nhập mã sinh viên (SV000000):"+"\u001B[0m");
        String id = sc.nextLine();
        while (!check.checkId(id)){
            //LOGGER.info("Mã sinh viên không đúng(SV000000)!!!");
            System.out.println("\u001B[31m"+"Mã sinh viên không đúng(SV000000)!!!"+"\u001B[0m");
            id=sc.nextLine();
        }

        System.out.println("\u001B[32m"+"Nhập họ và tên:"+"\u001B[0m");
        String name = sc.nextLine();
        while (!check.checkName(name)){
            //LOGGER.info("Tên không đúng định dạng !!!");
            System.out.println("\u001B[31m"+"Tên không đúng định dạng !!!"+"\u001B[0m");
            name=sc.nextLine();
        }

        System.out.println("\u001B[32m"+"Nhập giới tính:"+"\u001B[0m");
        Student.Gender gender = null;
        int choice;
        do {
            System.out.println("\u001B[32m"+"(1:Nam// 2:Nữ// 3:Khác)"+"\u001B[0m");
          choice = sc.nextInt();

           switch (choice) {
               case 1:
                   gender = Student.Gender.Nam;
                   break;
               case 2:
                   gender = Student.Gender.Nữ;
                   break;
               case 3:
                   gender = Student.Gender.Khác;
                   break;
           }
       }while (choice!=1 && choice!=2 && choice!=3);
        sc.nextLine();

        LocalDate dateOfBrith= null;
        boolean checkDate = false;
        while (!checkDate){
            try {
                System.out.println("\u001B[32m"+"Nhập ngày tháng năm sinh (yyyy-mm-dd):"+"\u001B[0m");
                dateOfBrith=LocalDate.parse(sc.nextLine());
                checkDate=true;
            }catch (DateTimeException e){
                System.out.println("\u001B[31m"+"Ngày tháng năm không hợp lệ !!!"+"\u001B[0m");
                //LOGGER.info("Ngày tháng năm không hợp lệ !!!");
            }
        }

        System.out.println("\u001B[32m"+"Nhập địa chỉ:"+"\u001B[0m");
        System.out.println("\u001B[32m"+"Số nhà:"+"\u001B[0m");
        String homeNumber = sc.nextLine();
        System.out.println("\u001B[32m"+"Xã:"+"\u001B[0m");
        String social = sc.nextLine();
        System.out.println("\u001B[32m"+"Huyện:"+"\u001B[0m");
        String provincial= sc.nextLine();
        System.out.println("\u001B[32m"+"Tỉnh:"+"\u001B[0m");
        String districts= sc.nextLine();
        Address address=new Address(homeNumber,social,provincial,districts);


        System.out.println("\u001B[32m"+"Nhập Email:"+"\u001B[0m");
        String email = sc.nextLine();
         while(!check.checkEmail(email)){
             System.out.println("\u001B[31m"+"Email không đúng định dạng, nhập lại Email:"+"\u001B[0m");
             //LOGGER.info("Email không đúng định dạng, nhập lại Email !!!");
             email=sc.nextLine();
         }

        System.out.println("\u001B[32m"+"Nhập số điện thoại (+84)-(xxxxxxxxx)"+"\u001B[0m");
         String phone = sc.nextLine();
         while (!check.checkPhone(phone)){
             System.out.println("\u001B[31m"+"Số điện thoại không đúng,(+84)-(xxxxxxxxx)"+"\u001B[0m");
             phone=sc.nextLine();
         }

        System.out.println("\u001B[32m"+"Nhập điểm:"+"\u001B[0m");
        System.out.println("\u001B[32m"+"Điểm toán:"+"\u001B[0m");
        double mathScores = sc.nextDouble();
        System.out.println("\u001B[32m"+"Điểm lý:"+"\u001B[0m");
        double  physicalScore = sc.nextDouble();
        System.out.println("\u001B[32m"+"Điểm hóa:"+"\u001B[0m");
        double chemistryScore=sc.nextDouble();
        Scores scores=new Scores(mathScores,physicalScore,chemistryScore);
        Student student=new Student(id,name,gender,dateOfBrith,phone,address,email,scores);
        manage.addStudent(student);
    }

    //xóa sinh viên
    public static void Delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\u001B[32m"+"Nhập mã sinh viên:"+"\u001B[0m");
        String id = sc.nextLine();
        manage.deleteStudent(id);
        System.out.println("\u001B[32m"+"Xóa sinh viên thành công !!!"+"\u001B[0m");
    }

    //sửa sinh viên
    public static void Update(){
     Scanner sc=new Scanner(System.in);
        System.out.println("\u001B[32m"+"Nhập mã sinh viên:"+"\u001B[0m");
     String id =sc.nextLine();
     manage.updateStudent(id);
    }

    //hiển thị sinh viên theo tên
    public static void displayName(){
        manage.sortName();
    }

    //hiển thị theo điểm
    public static void displayScores(){
        manage.sortScores();
    }

    //phân loại học lực
    public static void classificationOfAcademics(){
        manage.studentClassification();
    }

    // tìm kiếm theo mã sinh viên
    public static void search(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\u001B[32m"+"Nhập mã sinh viên:"+"\u001B[0m");
        String id = sc.nextLine();
       manage.searchStudent(id);
    }

    //tìm kiếm theo tên
      public static void searchName(){
        Scanner sc = new Scanner(System.in);
          System.out.println("\u001B[32m"+"Nhập tên:"+"\u001B[0m");
          String name=sc.nextLine();
          manage.searchNameStudent(name);
      }

}