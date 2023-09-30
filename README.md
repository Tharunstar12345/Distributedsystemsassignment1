# Distributedsystemsassignment1
# RandomString Java program
This Java program generates random entries and writes them to a file. Additionally, it includes a throughput calculator to measure data generation speed.

## Usage

1)Open a terminal.
2)Navigate to the directory containing the Java files.
3)Compile the program:javac RandomString.java
4)Run the program:
To generate random entries:java RandomString <num_entries> <output_file>
To calculate throughput:java ThroughputCalculator <total_data_size_MiB> <execution_time_ms>
example:java RandomString 65563 output.txt
java ThroughputCalculator 65563 0.837

# Sort Java Program

This Java program sorts data from an input file based on the first column and writes the sorted data to an output file.

## Usage

- <input_file>: Path to the input file.
- <temp_dir>: Path to the temporary directory.
- <output_file>: Path to the output file.

## How It Works

1. Reads data from the input file.
2. Sorts the data based on the first column.
3. Writes the sorted data to a temporary file.
4. Renames the temporary file to the output file.
5. Prints execution time and throughput.

## Example

```cmd
java Sort input.txt temp output_sorted.txt
