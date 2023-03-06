package org.example.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    //DOC FILE
    public static List<String> readToFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) !=  null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    //GHI FILE
    public static <T> void writeToFile(String path, List<T> items) {
        try(PrintWriter printWriter = new PrintWriter(path)) {
            for (T item : items) {
                printWriter.println(item.toString());
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("File khong hop le!");
        }
    }
}
