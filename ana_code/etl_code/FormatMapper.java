import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import java.io.StringReader;
import java.util.*;

import com.opencsv.exceptions.CsvMalformedLineException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FormatMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        try (CSVReader reader = new CSVReader(new StringReader(value.toString()))) {
            if (key.get() != 0){
                String[] row = reader.readNext();

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    if (i == 2 || i == 3 || i == 5) {
                        sb.append(row[i].trim().toUpperCase()).append(",");
                    }
                    else if (i != 17) { // ignore column 18
                        sb.append(row[i].trim()).append(",");
                    }
                }

                sb.deleteCharAt(sb.length() - 1); // remove trailing comma

                context.write(new Text(key.toString()), new Text(sb.toString()));
            }
        } catch (CsvValidationException | CsvMalformedLineException e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("unterminated quoted field")){
                System.err.println(e);
            }
        }
    }
}