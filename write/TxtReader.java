package write;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zxy on 5/31/17.
 */
public class TxtReader{
    // 读取文件指定行。
    static void readAppointedLineNumber(File sourceFile)
            throws IOException {
        int nu = 0;
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        int lines = 0;
        while (s != null && lines < getTotalLines(sourceFile)) {
            lines++;
            s = reader.readLine();
            int len = s.length();
            if (len > 10) {
                s.replace(" ", "");
                nu++;
            }
        }
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

        reader.close();
        in.close();
    }
    // 文件内容的总行数。
    public static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    /**
     * 读取文件指定行。
     */
    public static void readandwrite() throws IOException {
        File sourceFile = new File("/home/zxy/test2/大学生毕业论文范文参考.txt");
        // 读取指定的行
        readAppointedLineNumber(sourceFile);
        // 获取文件的内容的总行数
    }
}
