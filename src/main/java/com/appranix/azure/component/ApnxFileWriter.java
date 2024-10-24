package com.appranix.azure.component;

import com.appranix.azure.entity.SampleData;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ApnxFileWriter {

    public void write (SampleData sampleData) {

//        String filePath1 = "F:\\f1\\example1.txt";
        String filePath1 = "/mnt/datadisk1/example1.txt";
//        String filePath1 = "/mnt/c/Users/suryaprasathj/tesst/eg1";
        String dataToAppend = sampleData.getName() + " has written data: " + sampleData.getText() + " at: " + sampleData.getNow() + "\n";
        appendDataToFile(filePath1, dataToAppend);

//        String filePath2 = "G:\\f2\\example2.txt";
        String filePath2 = "/mnt/datadisk2/example2.txt";
//        String filePath2 = "/mnt/c/Users/suryaprasathj/tesst/eg2";
        appendDataToFile(filePath2, dataToAppend);
    }

    public void appendDataToFile(String filePath, String data) {
        BufferedWriter writer = null;
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            writer = new BufferedWriter(fileWriter);
            writer.write(data);
            writer.newLine();

            System.out.println("Data successfully appended to the file in Path: " + filePath);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
