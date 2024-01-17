package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class how_to_read_csv {
    // This function read a given file path of a CSV file and read it line by line.
    public static void readCSV(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);

                // if the line is delimited by comma, we can split the line by comma and store it in an array.
                String[] data = line.split(",");
                System.out.println(data[0]);


                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }

    //This function will write to a CSV file given a file path.
    public static void writeCSV(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.append("Name");
            writer.append(",");
            writer.append("Age");
            writer.append("\n");

            writer.append("John");
            writer.append(",");
            writer.append("25");
            writer.append("\n");

            writer.append("Jane");
            writer.append(",");
            writer.append("30");
            writer.append("\n");

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e);
        }
    }

    public static void main(String[] args) {
        String filePath = "Java/test.csv";
        readCSV(filePath);
    }    
}
