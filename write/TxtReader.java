package write;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import static write.write.writein;

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
                writein(s,nu);
                nu++;
            }
        }
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
