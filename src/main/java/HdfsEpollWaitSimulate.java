import org.apache.hadoop.conf.Configuration;
        import org.apache.hadoop.fs.FileSystem;
        import org.apache.hadoop.fs.Path;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

/**
 * Created by jasonzhu on 21/11/14.
 */
public class HdfsEpollWaitSimulate {
    public static void main(String[] args) throws IOException, InterruptedException {
        String pth = "hdfs://ns1/user/supertool/zhudi/input/blk_merge_"+args[0];
        Path pt=new Path(pth);
        FileSystem fs = FileSystem.get(new Configuration());
        BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
        String line;
        long t1 = System.currentTimeMillis();
        line=br.readLine();
        while (line != null) {
            line = br.readLine();
        }
        long t2 = System.currentTimeMillis();
        br.close();
        fs.close();
        System.out.println("done. readTime=["+((t2-t1)/1000)+"]");
    }


}
