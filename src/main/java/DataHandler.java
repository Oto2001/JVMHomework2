import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class DataHandler {
    private static final Logger logger = LoggerFactory.getLogger(DataHandler.class);

    public static void calculateAverage() {
        try {
            // Read from file
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String line = reader.readLine();
            int sum = Integer.parseInt(line);
            int count = 1;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                sum += Integer.parseInt(line);
                count++;
            }
            reader.close();

            // Write result in file
            double average = (float) sum/count;
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data.txt", true));
            writer.write("\r\n");
            writer.write("" + average);
            writer.close();

            logger.debug("Sum: " + sum);
            logger.debug("Count: " + count);
            logger.debug("Average: " + average);

        } catch (IOException ex) {
            logger.error("Error during reading from file.", ex);
        } catch (NumberFormatException ex) {
            logger.error("Error during converting string to int.", ex);
        }

    }
}
