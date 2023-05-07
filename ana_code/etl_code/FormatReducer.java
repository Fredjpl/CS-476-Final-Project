import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FormatReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            String[] fields = value.toString().split(",");
            boolean hasMissingValues = false;
            for (String field : fields) {
                if (field.isEmpty()) {
                    hasMissingValues = true;
                    break;
                }
            }
            if (!hasMissingValues) {
                context.write(new Text(value), new Text(""));
            }
        }
    }
}