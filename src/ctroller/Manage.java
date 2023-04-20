package ctroller;

import model.Scores;
import model.Student;
import storage.ReadFile;
import storage.WriteFile;

import java.util.*;
import java.util.logging.Logger;

public class Manage {
    private static final Logger LOGGER =Logger.getLogger(String.valueOf(Manage.class));
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
//            System.out.println("Mã sinh viên này đã tồn tại !!!");
            LOGGER.info("Mã sinh viên này đã tồn tại !!!");
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
                //System.out.println("Bạn có muốn sửa lại mã sinh viên này??? (OK [1]/ HUY[2]) !!!");
                LOGGER.info("Bạn có muốn sửa lại mã sinh viên này??? (OK [1]/ HUY[2]) !!!");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                      studentList.set(index,student);
                      // System.out.println("Sửa thành công !!!")
                        LOGGER.info("Sửa thành công !!!");
                        break;
                    case 2:
                       // System.out.println("Hủy thành công !!!");
                        LOGGER.info("Hủy thành công !!!");
                        break;

                }
            }while (confirm!=1 && confirm!=2);

        } else {
            studentList.add(student);
           // System.out.println("Thêm sinh viên thành công !!!");
            LOGGER.info("Thêm sinh viên thành công !!!");
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
                //System.out.println("Bạn có chắc chắn muốn xóa (OK [1]/ HUY[2]) !!!");
                LOGGER.info("Bạn có chắc chắn muốn xóa (OK [1]/ HUY[2]) !!!");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                        studentList.remove(studentList.get(index));
                        break;
                    case 2:
                       // System.out.println("Hủy thành công !!!");
                        LOGGER.info("Hủy thành công !!!");
                        break;

                }
            }while (confirm!=1 && confirm!=2);
        }
        else {
            LOGGER.info("Không tồn tại mã sinh viên này !!!");
        }

            writeFile.write(studentList);

        }
        //update sinh viên
       public void updateStudent(String id,Student student){
        int index =-1;
           for (int i = 0; i < studentList.size(); i++) {
               if(studentList.get(i).getId().equals(id)){
                   index=i;
               }
           }
           if(index != -1){
               studentList.set(index,student);
               displayStudent();
           }
           else {
               LOGGER.info("Không tồn tại mã sinh viên này !!!");
           }
           writeFile.write(studentList);
       }

        //hiển thị danh sách
        public void displayStudent(){
             System.out.println("Danh sách sinh viên !!!");
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
                return o1.getName().compareTo(o2.getName());
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
          System.out.println("Sinh viên học lực kém !!!");
          for (int i = 0; i < studentList.size(); i++) {
              if(studentList.get(i).averageOfSubject()>=0 && studentList.get(i).averageOfSubject()<4){
                  System.out.println(studentList.get(i));
              }
          }
             System.out.println("Sinh viên học lực yếu !!!");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=4 && studentList.get(i).averageOfSubject() < 5) {
                  System.out.println(studentList.get(i));
              }
          }
             System.out.println("Sinh viên học lực trung bình !!!");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=5 && studentList.get(i).averageOfSubject() < 7) {
                  System.out.println(studentList.get(i));
              }
          }
           System.out.println("Sinh viên học lực khá !!!");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=7 && studentList.get(i).averageOfSubject() < 8) {
                  System.out.println(studentList.get(i));
              }
          }
               System.out.println("Sinh viên học lực giỏi !!!");
          for (int i = 0; i < studentList.size(); i++) {
              if (studentList.get(i).averageOfSubject()>=8 && studentList.get(i).averageOfSubject() <= 9) {
                  System.out.println(studentList.get(i));
              }
          }
          System.out.println("Sinh viên học lực xuất sắc !!!");
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
                 LOGGER.info("Không tồn tại mã sinh viên này !!!");
             }
          }


      }



