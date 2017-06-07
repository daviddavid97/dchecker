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
            filereceive();//初步完成
            Totxt();    //初步完成
            readandwrite();//初步完成
            readfrom();//初步完成
            compare();//初步完成
        System.exit(0);
    }
}
