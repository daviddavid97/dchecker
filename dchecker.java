import static compare.readfromsql.readfrom;
import static receive.receive.filereceive;
import static write.DocToTxt.Totxt;
import static write.TxtReader.readandwrite;
import static compare.compare.compare;


/**
 * Created by zxy on 5/31/17.
 */
public class dchecker {
    public static void main(String[] args) throws Exception {
            filereceive();//完成一半
            Totxt();    //完成
            readandwrite();//完成一半
            readfrom();//完成一半
            compare();//一半
        System.exit(0);
    }
}
