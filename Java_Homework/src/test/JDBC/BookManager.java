package test.JDBC;

import java.sql.ResultSet;

public class BookManager {
    private DataBaseManager db;

    public BookManager() {
        db = new DataBaseManager();
    }

    public void borrow(String sno, String bno, String bdate, String rdate) {
        try {
            // 表名为 bookBrowse，表结构：学生名、书名、借阅日期、归还日期
            String strSQL = "insert into bookBrowse" +
                    "(studentname,bookname,borrowdate,returndate)" +
                    "values('" + sno + "','" + bno + "','" + bdate + "','" + rdate + "',')";
            if (db.updateSql(strSQL)) {
                System.out.println("借阅完成！");
                db.closeConnection();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean query(String sno) {
        ResultSet rs;
        try {
            String strSQL = "select studentname,bookname,borrowdate from" +
                    " bookBrowse where studentname='" + sno + "'";
            rs = db.getResult(strSQL);
            if (!rs.first()) {
                System.out.println("此学生没有借过书");
                db.closeConnection();
                return false;
            } else {
                while (rs.next()) {
                    System.out.println("学生姓名：" + rs.getString("studentname"));
                    System.out.println("图书名：" + rs.getString("bookname"));
                    System.out.println("借阅日期：" + rs.getString("borrowdate"));
                }
                db.closeConnection();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void delete(String sno) {
        try {
            String strSQL = "delete from bookBrowse where studentname='" + sno + "'";
            if (db.updateSql(strSQL)) {
                System.out.println("删除完成！");
                db.closeConnection();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void update(String sno, String bno) {
        try {
            String strSQL = "update bookBrowse set bno='" + bno + "' where " +
                    " studentname='" + sno + "'";
            if (db.updateSql(strSQL)) {
                System.out.println("修改完成！");
                db.closeConnection();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
