package com.neuedu.Test;

import com.neuedu.pojo.Student;
import com.neuedu.util.JdbcPer;
import com.neuedu.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private Scanner input=new Scanner(System.in);
    //权限管理  如果是学生 只能修改自己的信息 和修改
    // 老师 查看
    public  void  login(){
        System.out.println("请登录");
        System.out.println("username");
        String name=input.next();
        System.out.println("请输入密码");
        String psw=input.next();
        showMenu();
    }

    public  void showMenu(){
        System.out.println("欢迎使用****学生管理系统");

        System.out.println("1 增");
        System.out.println("2 删");
        System.out.println("3 改");
        System.out.println("4 查");
        System.out.println("5 退出");
        System.out.println("输入编号选择功能");
       int Key=input.nextInt();
       switch (Key){
           case 1:
 //              增
               add();
               break;
           case 2:
//               删
               delete();
               break;
           case 3:
//               改
               update();
               break;
           case 4:
//               查
               select();
               break;
           case 5:
//               退出
               break;
       }

    }
    public void add(){
        Student student=new Student(4,201704,"王五",147,"20","男",10,20,"2000-01-01",1);
        JdbcPer.executUpate("insert into student(id,sno,sname,spaw,sage,ssex,sheight,sweight,sbirthday,sflag) values (?,?,?,?,?,?,?,?,?,?)",student.getId(),student.getSno(),student.getSname(),student.getSpaw(),student.getSage(),student.getSsex(),student.getSheight(),student.getSweight(),student.getSbirthday(),student.getSflag());
    }
    public void delete() {
      Student student=new Student();
      JdbcPer.executUpate("delete from student where id=?",2);
    }
    public void  update(){
        Student student=new Student();
        JdbcPer.executUpate("Update student set sno=201711 where id=?",1);
    }
    public  void select(){
        List<Student> lsits=JdbcPer.executeQuery("select * from student where id=?", new RowMap<Student>() {
            @Override
            public Student rowMapping(ResultSet rs) {
                Student student=new Student();
                try {
                    int id= rs.getInt("id");
                    int sno=rs.getInt("sno");
                    String sname=rs.getString("sname");
                    int spaw=rs.getInt("spaw");
                    String sage=rs.getString("sage");
                    String ssex=rs.getString("ssex");
                   double sheight=rs.getDouble("sheight");
                   double sweight=rs.getDouble("sweight");
                   String sbirthday=rs.getString("sbirthday");
                   int sflag=rs.getInt("sflag");
                    student.setId(id);
                    student.setSno(sno);
                    student.setSname(sname);
                    student.setSpaw(spaw);
                    student.setSage(sage);
                    student.setSsex(ssex);
                    student.setSheight(sheight);
                    student.setSweight(sweight);
                    student.setSbirthday(sbirthday);
                    student.setSflag(sflag);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return student;
            }
        },1);
        for (Student s:lsits
             ) {
            System.out.println(s);
        }
    }
}
