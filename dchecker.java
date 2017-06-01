import static compare.readfromsql.readfrom;
import static receive.receive.filereceive;
import static write.DocToTxt.Totxt;
import static write.TxtReader.readandwrite;
import static compare.compare.compare;

import java.io.IOException;

/**
 * Created by zxy on 5/31/17.
 */
public class dchecker {
    public static void main(String[] args) throws IOException {
        while (true) {
            filereceive();
            Totxt();
            readandwrite();
            readfrom();
            compare();
        }
    }
}
