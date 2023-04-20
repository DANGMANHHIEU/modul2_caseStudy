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
    private static final Logger LOGGER =Logger.getLogger(String.valueOf(Manage.class));

     //thêm sinh viên
    public static void Add(){
        Check check=new Check();
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập mã sinh viên (SV000000):");
        String id = sc.nextLine();
        while (!check.checkId(id)){
            LOGGER.info("Mã sinh viên không đúng(SV000000)!!!");
            id=sc.nextLine();
        }

        System.out.println("Nhập họ và tên:");
        String name = sc.nextLine();

        System.out.println("Nhập giới tính:");
        Student.Gender gender = null;
        int choice;
        do {
            System.out.println("(1:Nam// 2:Nữ// 3:Khác)");
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
                System.out.println("Nhập ngày tháng năm sinh (yyyy-mm-dd):");
                dateOfBrith=LocalDate.parse(sc.nextLine());
                checkDate=true;
            }catch (DateTimeException e){
               // System.out.println("Ngày tháng năm không hợp lệ !!!");
                LOGGER.info("Ngày tháng năm không hợp lệ !!!");
            }
        }

        System.out.println("Nhập địa chỉ:");
        System.out.println("Số nhà:");
        String homeNumber = sc.nextLine();
        System.out.println("Xã:");
        String social = sc.nextLine();
        System.out.println("Huyện:");
        String provincial= sc.nextLine();
        System.out.println("Tỉnh:");
        String districts= sc.nextLine();
        Address address=new Address(homeNumber,social,provincial,districts);


        System.out.println("Nhập Email:");
        String email = sc.nextLine();
         while(!check.checkEmail(email)){
            // System.out.println("Email không đúng định dạng, nhập lại Email:");
             LOGGER.info("Email không đúng định dạng, nhập lại Email !!!");
             email=sc.nextLine();
         }

        System.out.println("Nhập số điện thoại (+84)-(xxxxxxxxx)");
         String phone = sc.nextLine();
         while (!check.checkPhone(phone)){
             System.out.println("Số điện thoại không đúng,(+84)-(xxxxxxxxx)");
             phone=sc.nextLine();
         }

        System.out.println("Nhập điểm:");
        System.out.println("Điểm toán:");
        double mathScores = sc.nextDouble();
        System.out.println("Điểm lý:");
        double  physicalScore = sc.nextDouble();
        System.out.println("Điểm hóa:");
        double chemistryScore=sc.nextDouble();
        Scores scores=new Scores(mathScores,physicalScore,chemistryScore);
        Student student=new Student(id,name,gender,dateOfBrith,phone,address,email,scores);
        manage.addStudent(student);
    }

    //xóa sinh viên
    public static void Delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mã sinh viên:");
        String id = sc.nextLine();
        manage.deleteStudent(id);
    }

    //sửa sinh viên
    public static void Update(){
     Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mã sinh viên:");
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
        System.out.println("Nhập mã sinh viên:");
        String id = sc.nextLine();
       manage.searchStudent(id);
    }

    //tìm kiếm theo tên
      public static void searchName(){
        Scanner sc = new Scanner(System.in);
          System.out.println("Nhập tên:");
          String name=sc.nextLine();
          manage.searchNameStudent(name);
      }

    public static void main(String[] args) {
      Update();
    }
}