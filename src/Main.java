import ctroller.Manage;
import model.Address;
import model.Scores;
import model.Student;
import view.Client;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student student=new Student("1","Nguyễn Văn A", Student.Gender.Nam, LocalDate.of(1996,12,26),"0123456789",new Address("1A","HN","HN","HN"),"a@gmailk.com",new Scores(8,9,6));
//        Student student1=new Student("2","Hoàng Văn B", Student.Gender.Nam, LocalDate.of(1996,12,26),"123456789",new Address("1A","HN","HN","HN"),"a@gmailk.com",new Scores(1,2,3));
//        Student student2=new Student("3","Nguyễn Thị B", Student.Gender.Nữ, LocalDate.of(1996,12,26),"1234567890",new Address("1A","HN","HN","HN"),"a@gmailk.com",new Scores(1,2,3));
//////        System.out.println(student);
//////        System.out.println(student1);
//       Manage manage= new Manage();
//       manage.addStudent(student);
//        manage.addStudent(student1);
//        manage.addStudent(student2);
////        //manage.displayStudent();
//       //manage.studentClassification();
//        //manage.sortScores();
//       // manage.searchStudent("2");
//       manage.updateStudent("2",student2);
////        manage.deleteStudent("1");
        Scanner sc= new Scanner(System.in);
        int choice=0;
        do {
            System.out.println("""
                    | 0.Thoát chương trình.\n
                    | 1.Thêm sinh viên.\n
                    | 2.Xóa sinh viên.\n
                    | 3.Sửa thông tin sinh viên.\n
                    | 4.Hiển thị sinh viên theo tên.\n
                    | 5.Hiển thị sinh viên theo điểm .\n
                    | 6.Phân loại học lực sinh viên.\n
                    | 7.Tìm kiếm sinh viên theo mã sinh viên.\n
                    | 8.Tìm kiếm theo tên.\n
                    """);
            System.out.println();
            System.out.println("Vui lòng chọn chức năng !!!");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    Client.Add();
                    break;
                case 2:
                    Client.Delete();
                    break;
                case 3:
                    Client.Update();
                    break;
                case 4:
                    Client.displayName();
                    break;
                case 5:
                    Client.displayScores();
                    break;
                case 6:
                    Client.classificationOfAcademics();
                    break;
                case 7:
                    Client.search();
                    break;
                case 8:
                    Client.searchName();
                    break;
            }

        }while (choice!=0);

    }
}