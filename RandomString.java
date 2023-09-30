import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(" <num_entries> <output_file>");
            return;
        }

        int Entries = Integer.parseInt(args[0]);
        String opFile = args[1];

        try {
            long start = System.currentTimeMillis();
            generateEntriesToFile(Entries, opFile);
            long end = System.currentTimeMillis();
            long exetime = end - start;

            System.out.println("Entries generated successfully.");
            System.out.println("Execution time: " + exetime + " ms");

        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
        }
    }
    static class ThroughputCalculator {
        public static void main(String[] args) {
            if (args.length != 2) {
                System.out.println("Usage: java ThroughputCalculator <total_data_size_MiB> <execution_time_ms>");
                return;
            }

            double totalsizeofdataMiB = Double.parseDouble(args[0]);
            double exetimeMs = Double.parseDouble(args[1]);
            double throughput = (totalsizeofdataMiB / (exetimeMs / 1000.0));

            System.out.println("Throughput: " + throughput + " MiB/s");
        }
    }

    public static void generateEntriesToFile(int Entries, String opFile) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int c = 0; c < Entries; c++) {
                int randomInt = random.nextInt(100000000);
                String randomIntStr = String.format("%08d", randomInt);
                String sequenceNumber = String.format("%010d", k);
                StringBuilder randomString = new StringBuilder(46);
                for (int d = 0; d < 45; d++) {
                    char randomChar = (char) (random.nextInt(26) + 'a');
                    randomString.append(randomChar);
                }
                randomString.append('\n');
                writer.write(randomIntStr + "_" + sequenceNumber + "_" + randomString.toString());
            }}}}
