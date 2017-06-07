package write;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zxy on 5/31/17.
 */
//写入数据库
public class write {
    public static void writein(String s,int i){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String databaseName = "test";// 已经在MySQL数据库中创建好的数据库。
            String userName = "root";// MySQL默认的root账户名
            String password = "zxy";// 默认的root账户密码为空
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, password);

            Statement stmt = conn.createStatement();
            String name = "a"+"201607042012";

            String sql = "CREATE TABLE " + name + "(uid varchar(32),name char(32))";

            // 创建数据库中的表，
            int result = stmt.executeUpdate(sql);

            if (result != -1) {
                System.out.println("创建数据表成功");

                sql = "INSERT INTO "+name+"(uid,name) VALUES('1',"+"'somebody1'"+")";
                result = stmt.executeUpdate(sql);

                sql = "INSERT INTO "+name+"(uid,name) VALUES('2','somebody2')";
                result = stmt.executeUpdate(sql);

                sql = "SELECT * FROM "+name;

                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("uid\t姓名");

                while (rs.next()) {
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("");
    }

}
