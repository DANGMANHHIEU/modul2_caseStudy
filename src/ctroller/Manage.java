package ctroller;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    private List<Student> studentList;

    public Manage() {
        this.studentList = new ArrayList<>();
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
            System.out.println("Mã sinh viên này đã tồn tại !!!");
            System.out.println(student);
            //Todo chưa hoàn thành cần thêm phần add chèn nếu muốn
        } else {
            studentList.add(student);
            System.out.println("Thêm sinh viên thành công !!!");
        }
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
                System.out.println("Bạn có chắc chắn muốn xóa (OK [1]/ HUY[2]) !!!");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                        studentList.remove(studentList.get(index));
                        break;
                    case 2:
                        System.out.println("Hủy thành công !!!");
                        break;

                }
            }while (confirm!=1 && confirm!=2);
        }
        }
        //update sinh viên


    }
