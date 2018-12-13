package experiment.exp4;

import java.sql.ResultSet;

public class StudentManager {
    private DataBaseManager db;

    public StudentManager() {
        db = new DataBaseManager();
    }

    public void insert(String studentId, String studentName, String courseName, int remark) {
        try {
            String strSQL = "insert into studentBrowse" +
                    "(studentId,studentname,coursename,remark)" +
                    "values('" + studentId + "','" + studentName + "','" + courseName + "','" + remark + "')";
            if (db.updateSql(strSQL)) {
                System.out.println(studentName + "插入完成！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean queryCourse(String studentId) {
        ResultSet rs;
        try {
            String strSQL = "select studentId,studentname,coursename,remark from" +
                    " studentBrowse where studentId='" + studentId + "'";
            rs = db.getResult(strSQL);
            if (!rs.first()) {
                System.out.println("没有此学生");
                return false;
            } else {
                do {
                    System.out.println("学生学号：" + rs.getString("studentId"));
                    System.out.println("学生姓名：" + rs.getString("studentname"));
                    System.out.println("选课名称：" + rs.getString("coursename"));
                    System.out.println("选课成绩：" + rs.getInt("remark"));
                } while (rs.next());
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean queryRemark(String studentName) {
        ResultSet rs;
        try {
            String strSQL = "select studentId,studentname,coursename,remark from" +
                    " studentBrowse where studentname='" + studentName + "'";
            rs = db.getResult(strSQL);

            if (!rs.first()) {
                System.out.println("没有此学生");
                return false;
            } else {
                do {
                    System.out.println(studentName + "的选课成绩：" + rs.getString("remark"));
                } while (rs.next());
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void delete(String studentId) {
        try {
            String strSQL = "delete from studentBrowse where studentId='" + studentId + "'";
            if (db.updateSql(strSQL)) {
                System.out.println("删除完成！");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deleteAll() {
        try {
            String strSQL = "delete from studentBrowse";
            if (db.updateSql(strSQL)) {
                System.out.println("清空表中数据完成！");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

        sm.deleteAll();
        System.out.println("----------------------");
        sm.insert("B15011728", "小明", "English", 97);
        sm.insert("B15011729", "小刚", "Math", 95);
        sm.insert("B15011730", "小红", "PE", 98);
        System.out.println("----------------------");
        System.out.println("根据姓名查询");
        sm.queryRemark("小红");
        System.out.println("----------------------");
        System.out.println("根据学号查询");
        sm.queryCourse("B15011729");

        sm.db.closeConnection();

    }
}
