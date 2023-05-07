import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Format {
    public static void main(String args[]) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: Format <input path> <output path>");
            System.exit(-1);
        }

        Job job = new Job();
        job.addFileToClassPath(new Path("opencsv-5.7.1.jar"));
        job.setNumReduceTasks(1);
        job.setJarByClass(Format.class);
        job.setJobName("Format");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(FormatMapper.class);
        job.setReducerClass(FormatReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}