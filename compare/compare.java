package compare;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

import static write.TxtReader.getTotalLines;
import static compare.MyLevenshtein.levenshtein;

/**
 * Created by zxy on 17-6-1.
 */
public class compare {
    public static void compare() throws Exception{
        String dest = "/home/zxy/test2/大学生毕业论文范文参考.txt";
        File file = new File(dest);
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        String s2 = "";
        int lines = 0;
        while (s != null && lines < getTotalLines(file)) {
            lines++;
            s = reader.readLine();
            s2 = s;
            levenshtein(s , s2);
        }
        reader.close();
        in.close();
    }
    // 文件内容的总行数。

}
