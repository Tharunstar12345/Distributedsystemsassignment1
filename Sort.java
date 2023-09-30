import java.io.*;
import java.util.*;

public class Sort{

    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("Sort <input_file> <temp_dir> <output_file>");
            return;
        }

        String input = args[0];
        String tempDir = args[1];
        String output = args[2];
        long input1 = getFileSize(input);
        long start = System.currentTimeMillis();
        List<String> inputLines = readLines(input);
        Collections.sort(inputLines, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] p1 = s1.split("_");
                String[] p2 = s2.split("_");
                return Integer.compare(Integer.parseInt(p1[0]), Integer.parseInt(p2[0]));
            }
        });
        String temp = tempDir + "/sorted_data.txt";
        writeLines(inputLines, temp);
        File tempFile = new File(temp);
        File out = new File(output);
        tempFile.renameTo(out);
        long output1 = getFileSize(output);
        long total = output1 - input1;
        long end = System.currentTimeMillis();
        long exetime = end - start;
        double throughput = (total / (exetime / 1000.0)) / (1024 * 1024); // Convert to MiB/s
        System.out.println("Execution time: " + exetime + " ms");
        System.out.println("Throughput: " + throughput + " MiB/s");
        System.out.println("Sorted data written to " + output);
    }
    static List<String> readLines(String file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
    static void writeLines(List<String> lines, String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        }
    }

    static long getFileSize(String filePath) {
        File file = new File(filePath);
        return file.length();
    }
}