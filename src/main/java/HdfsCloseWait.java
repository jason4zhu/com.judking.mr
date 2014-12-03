import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jasonzhu on 20/11/14.
 */
public class HdfsCloseWait {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path pt=new Path("hdfs://ns1/user/supertool/zhudi/input/blk_1073752163");
        FileSystem fs = FileSystem.get(new Configuration());
        BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
        String line;
        line=br.readLine();
        System.out.println("sleep at phase 1");
        Thread.sleep(1*30*1000);
        while (line != null) {
            System.out.println(line);
            line = br.readLine();

        }
        System.out.println("sleep at phase 2");
        Thread.sleep(1*30*1000);
        IOUtils.closeStream(br);
        fs.close();
        System.out.println("sleep at phase 3");
        Thread.sleep(10*30*1000);
        System.out.println("done=["+pt.toString()+"]");
    }
}
