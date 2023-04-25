package ctroller;

import model.Address;
import model.Scores;
import model.Student;
import storage.ReadFile;
import storage.WriteFile;
import view.Check;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

public class Manage {
   // private static final Logger LOGGER =Logger.getLogger(String.valueOf(Manage.class));
    Scanner sc = new Scanner(System.in);
    private List<Student> studentList;
    private WriteFile<Student> writeFile;
    private ReadFile<Student> readFile;

    public Manage() {
        this.studentList = new ArrayList<>();
        writeFile =new WriteFile<>();
        readFile = new ReadFile<>();
        this.studentList =readFile.read();
    }

    public Manage(List<Student> studentList) {
        this.studentList = studentList;
    }

    //check id
    public boolean checkId(Student student) {
        boolean check = false;
        for (Student e : studentList) {
            if (e.getId().equals(student.getId())) {
                check = true;
            }
        }
        return check;
    }

    //thêm sinh viên
    public void addStudent(Student student) {
        if (checkId(student)) {
           System.out.println("\u001B[31m"+"Mã sinh viên này đã tồn tại !!!"+"\u001B[0m");
           // LOGGER.info("Mã sinh viên này đã tồn tại !!!");
            //System.out.println(student);
            int index =-1;
            for (Student student1 : studentList) {
                if(student.getId().equals(student1.getId())){
                    index= studentList.indexOf(student1);
                    break;
                }
            }
            byte confirm;
            do {
                System.out.println("\u001B[31m"+"Bạn có muốn sửa lại mã sinh viên này??? (OK [1]/ HUY[2]) !!!"+"\u001B[0m");
               // LOGGER.info("Bạn có muốn sửa lại mã sinh viên này??? (OK [1]/ HUY[2]) !!!");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                      studentList.set(index,student);
                       System.out.println("\u001B[31m"+"Sửa thành công !!!"+"\u001B[0m");
                       // LOGGER.info("Sửa thành công !!!");
                        break;
                    case 2:
                        System.out.println("\u001B[31m"+"Hủy thành công !!!"+"\u001B[0m");
                       // LOGGER.info("Hủy thành công !!!");
                        break;

                }
            }while (confirm!=1 && confirm!=2);

        } else {
            studentList.add(student);
            System.out.println("\u001B[31m"+"Thêm sinh viên thành công !!!"+"\u001B[0m");
           // LOGGER.info("Thêm sinh viên thành công !!!");
        }
        writeFile.write(studentList);
    }

    //xóa sinh viên
    public void deleteStudent(String id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                index = i;
            }
        }
        if (index != -1) {
            byte confirm;
            do {
                System.out.println("\u001B[31m"+"Bạn có chắc chắn muốn xóa (OK [1]/ HUY[2]) !!!"+"\u001B[0m");
               // LOGGER.info("Bạn có chắc chắn muốn xóa (OK [1]/ HUY[2]) !!!");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                        studentList.remove(studentList.get(index));
                        break;
                    case 2:
                        System.out.println("\u001B[31m"+"Hủy thành công !!!"+"\u001B[0m");
                      //  LOGGER.info("Hủy thành công !!!");
                        break;

                }
            }while (confirm!=1 && confirm!=2);
        }
        else {
            //LOGGER.info("Không tồn tại mã sinh viên này !!!");
            System.out.println("\u001B[31m"+"Không tồn tại mã sinh viên này !!!"+"\u001B[0m");
        }

            writeFile.write(studentList);

        }
        //update sinh viên
       public void updateStudent(String id){
           Check check =new Check();
        int index =-1;
           for (int i = 0; i < studentList.size(); i++) {
               if(studentList.get(i).getId().equals(id)){
                   System.out.println(studentList.get(i));
                   index=i;
               }
           }
           if(index != -1){

               Scanner sc=new Scanner(System.in);
               int choice;
               do {
                   System.out.println("\u001B[32m"+"""
              0.Thoát.
              1.Sửa họ và tên.
              2.Sửa giới tính.
              3.Sửa ngày tháng năm sinh.
              4.Sửa số điện thoại.
              5.Sửa địa chỉ.
              6.Sửa Email.
              7.Sửa điểm.      
           """+"\u001B[0m");
                   choice = sc.nextInt();
                   sc.nextLine();
                   switch (choice){
                       case 1:
                           System.out.println("\u001B[32m"+"Nhập họ và tên:"+"\u001B[0m");
                           String name = sc.nextLine();
                           while (!check.checkName(name)){
                              // LOGGER.info("Tên không đúng định dạng !!!");
                               System.out.println("\u001B[31m"+"Tên không đúng định dạng !!!"+"\u001B[0m");
                               name=sc.nextLine();
                           }
                           studentList.get(index).setName(name);
                           System.out.println("\u001B[31m"+"Cập nhập tên thành công !!!"+"\u001B[0m");
                          // LOGGER.info("Cập nhập tên thành công !!!");
                           break;
                       case 2:
                           System.out.println("\u001B[32m"+"Nhập giới tính:"+"\u001B[0m");
                           Student.Gender gender = null;
                           int choi;
                           do {
                               System.out.println("\u001B[32m"+"(1:Nam// 2:Nữ// 3:Khác)"+"\u001B[0m");
                               choi = sc.nextInt();
                               switch (choi) {
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
                           }while (choi!=1 && choi!=2 && choi!=3);
                           studentList.get(index).setGender(gender);
                          // LOGGER.info("Cập nhập giới tính thành công !!!");
                           System.out.println("\u001B[31m"+"Cập nhập giới tính thành công !!!"+"\u001B[0m");
                           break;
                       case 3:
                           LocalDate dateOfBrith= null;
                           boolean checkDate = false;
                           while (!checkDate){
                               try {
                                   System.out.println("\u001B[32m"+"Nhập ngày tháng năm sinh (yyyy-mm-dd):"+"\u001B[0m");
                                   dateOfBrith=LocalDate.parse(sc.nextLine());
                                   checkDate=true;
                               }catch (DateTimeException e){
                                   // System.out.println("Ngày tháng năm không hợp lệ !!!");
                                   System.out.println("\u001B[31m"+"Ngày tháng năm không hợp lệ !!!"+"\u001B[0m");
                               }
                           }
                           studentList.get(index).setDateOfBrith(dateOfBrith);
                           System.out.println("\u001B[31m"+"Cập nhập ngày tháng năm sinh thành công !!!"+"\u001B[0m");
                           //LOGGER.info("Cập nhập ngày tháng năm sinh thành công !!!");
                           break;
                       case 4:
                           System.out.println("\u001B[32m"+"Nhập số điện thoại (+84)-(xxxxxxxxx)"+"\u001B[0m");
                           String phone = sc.nextLine();
                           while (!check.checkPhone(phone)){
                               System.out.println("\u001B[31m"+"Số điện thoại không đúng,(+84)-(xxxxxxxxx)"+"\u001B[0m");
                               phone=sc.nextLine();
                           }
                           studentList.get(index).setPhoneNumber(phone);
                           System.out.println("\u001B[31m"+"Cập nhập số điện thoại thành công !!!"+"\u001B[0m");
                           break;
                       case 5:
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
                           studentList.get(index).setAddress(address);
                           System.out.println("\u001B[31m"+"Cập nhập địa chỉ thành công !!!"+"\u001B[0m");
                           break;
                       case 6:
                           System.out.println("\u001B[32m"+"Nhập Email:"+"\u001B[0m");
                           String email = sc.nextLine();
                           while(!check.checkEmail(email)){
                                System.out.println("\u001B[31m"+"Email không đúng định dạng, nhập lại Email:"+"\u001B[0m");
                               //LOGGER.info("Email không đúng định dạng, nhập lại Email !!!");
                               email=sc.nextLine();
                           }
                           studentList.get(index).setEmail(email);
                           System.out.println("\u001B[31m"+"Cập nhập Email thành công !!!"+"\u001B[0m");
                           //LOGGER.info("Cập nhập Email thành công !!!");
                           break;
                       case 7:
                           System.out.println("\u001B[32m"+"Nhập điểm:"+"\u001B[0m");
                           System.out.println("\u001B[32m"+"Điểm toán:"+"\u001B[0m");
                           double mathScores = sc.nextDouble();
                           System.out.println("\u001B[32m"+"Điểm lý:"+"\u001B[0m");
                           double  physicalScore = sc.nextDouble();
                           System.out.println("\u001B[32m"+"Điểm hóa:"+"\u001B[0m");
                           double chemistryScore=sc.nextDouble();
                           Scores scores=new Scores(mathScores,physicalScore,chemistryScore);
                           studentList.get(index).setScores(scores);
                           System.out.println("\u001B[31m"+"Cập nhập điểm thành công !!!"+"\u001B[0m");
                           break;
                   }
               }while (choice!=0);
           }
           else {
               System.out.println("\u001B[31m"+"Không tồn tại mã sinh viên này !!!"+"\u001B[0m");
           }
           writeFile.write(studentList);
       }

        //hiển thị danh sách
        public void displayStudent(){
             System.out.println("\u001B[32m"+"Danh sách sinh viên !!!"+"\u001B[0m");
           // LOGGER.info("Danh sách sinh viên !!!");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("STT "+(i+1)+" "+studentList.get(i));
            }
        }
         //sắp xếp theo tên
    public void sortName(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String o1Name= o1.getName().substring(o1.getName().lastIndexOf(" ")+1);
                String o2Name=o2.getName().substring(o2.getName().lastIndexOf(" ")+1);
                int nameCompare = o1Name.compareTo(o2Name);
                if(nameCompare != 0){
                    return nameCompare;
                }
                else {
                    String o1_name=o1.getName().substring(o1.getName().indexOf(" ")+1,o1.getName().lastIndexOf(" ")-1);
                    String o2_name=o2.getName().substring(o2.getName().indexOf(" ")+1,o2.getName().lastIndexOf(" ")-1);
                    int name_compare=o1_name.compareTo(o2_name);
                    if(name_compare!=0){
                        return name_compare;
                    }
                    else {
                        String o1_na_me =o1.getName().substring(0,o1.getName().indexOf(" "));
                        String o2_na_me =o2.getName().substring(0,o2.getName().indexOf(" "));
                        return o1_na_me.compareTo(o2_na_me);
                    }
                }
            }
        });
        displayStudent();
    }

    // sắp xếp theo điểm
    public void sortScores(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                 if(o1.averageOfSubject() > o2.averageOfSubject()) {
                     return 1;
                 } else if (o1.averageOfSubject() < o2.averageOfSubject()) {
                     return  -1;
                 }
                 return 0;
            }
        });
        displayStudent();
    }
    // phân loại học lực học sinh
      public void studentClassification(){
          System.out.println("\u001B[32m"+"Sinh viên học lực kém !!!"+"\u001B[0m");
          for (int i = 0; i < studentList.size(); i++) {
              if(studentList.get(i).averageOfSubject()>=0 && studentList.get(i).averageOfSubject()<4){
                  System.out.println(studentList.get(i));
              }
          }
             System.out.println("\u001B[32m"+"Sinh viên học lực yếu !!!"+"\u001B[0m");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=4 && studentList.get(i).averageOfSubject() < 5) {
                  System.out.println(studentList.get(i));
              }
          }
             System.out.println("\u001B[32m"+"Sinh viên học lực trung bình !!!"+"\u001B[31m");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=5 && studentList.get(i).averageOfSubject() < 7) {
                  System.out.println(studentList.get(i));
              }
          }
           System.out.println("\u001B[32m"+"Sinh viên học lực khá !!!"+"\u001B[31m");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=7 && studentList.get(i).averageOfSubject() < 8) {
                  System.out.println(studentList.get(i));
              }
          }
               System.out.println("\u001B[32m"+"Sinh viên học lực giỏi !!!"+"\u001B[0m");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=8 && studentList.get(i).averageOfSubject() <= 9) {
                  System.out.println(studentList.get(i));
              }
          }
          System.out.println("\u001B[32m"+"Sinh viên học lực xuất sắc !!!"+"\u001B[0m");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>9 && studentList.get(i).averageOfSubject() <= 10) {
                  System.out.println(studentList.get(i));
              }
          }
          }

          //tìm kiếm theo mã sinh viên
          public void searchStudent(String id){
             boolean check= false;
              for (int i = 0; i < studentList.size(); i++) {
                  if(studentList.get(i).getId().equals(id)){
                      System.out.println(studentList.get(i));
                      check =true;
                  }
              }
             if(!check){
                 //LOGGER.info("Không tồn tại mã sinh viên này !!!");
                 System.out.println("\u001B[31m"+"Không tồn tại mã sinh viên này !!!"+"\u001B[0m");
             }
          }

          // tìm kiếm theo tên
        public void searchNameStudent(String name){
        boolean check =false;
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(studentList.get(i));
                check=true;
            }
        }
        if(!check){
            //LOGGER.info("Không tồn tại tên này !!!");
            System.out.println("\u001B[31m"+"Không tồn tại tên này !!!"+"\u001B[0m");
        }
    }
      }



