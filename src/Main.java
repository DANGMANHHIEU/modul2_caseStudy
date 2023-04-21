import ctroller.Manage;
import model.Address;
import model.Scores;
import model.Student;
import view.Client;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student student=new Student("SV000001","Nguyễn Văn Anh", Student.Gender.Nam, LocalDate.of(1994,12,20),"(+84)-(012345678)",new Address("1A","Tam Trinh","Hoàng Mai","Hà Nội"),"a@gmailk.com",new Scores(8,9,6));
//        Student student1=new Student("SV000002","Đặng Văn Hoàng", Student.Gender.Nam, LocalDate.of(1993,12,12),"(+84)-(555555555)",new Address("2B","Đình Thôn","Mỹ Đình","Hà Nội"),"b@gmailk.com",new Scores(4,2,5));
//        Student student2=new Student("SV000003","Nguyễn Thị Hồng", Student.Gender.Nữ, LocalDate.of(1996,12,15),"(+84)-(666666666)",new Address("3","Từ Liêm","Mỹ ĐÌnh","Hà Nam"),"c@gmailk.com",new Scores(1,2,3));
//        Student student3=new Student("SV000004","Trần Hoa Hồng", Student.Gender.Nữ, LocalDate.of(1992,12,15),"(+84)-(888888888)",new Address("5A","Từ Liêm","Mỹ ĐÌnh","Hà Nam"),"c@gmailk.com",new Scores(8,9,10));
//       Manage manage= new Manage();
//       manage.addStudent(student);
//        manage.addStudent(student1);
//        manage.addStudent(student2);
//        manage.addStudent(student3);
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
                    ***************************************************
                    ***************************************************
                    **                                               **
                    **     0.Thoát chương trình.                     **
                    **     1.Thêm sinh viên.                         **
                    **     2.Xóa sinh viên.                          **
                    **     3.Sửa thông tin sinh viên.                **
                    **     4.Hiển thị sinh viên theo tên.            **
                    **     5.Hiển thị sinh viên theo điểm .          **
                    **     6.Phân loại học lực sinh viên.            **
                    **     7.Tìm kiếm sinh viên theo mã sinh viên.   **
                    **     8.Tìm kiếm theo tên.                      **
                    **                                               **
                    ***************************************************
                    ***************************************************
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