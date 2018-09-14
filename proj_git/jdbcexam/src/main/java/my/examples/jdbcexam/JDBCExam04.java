package my.examples.jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExam04 {
    public static  void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.driver");
            String sql = "select * from EMPLOYEE limit 5";
            conn = DriverManager.getConnection("jdbc:mysql//192.168.232.3:3306/test", "root", "root");
            ps = conn.prepareStatement(sql);

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try{
                conn.close();;
            }catch(Exception ex) {}
                try {
                    ps.close();;
                }catch (Exception ex) {}
                try {
                    rs.close();
                } catch (Exception ex) {}
        }
    }
}
