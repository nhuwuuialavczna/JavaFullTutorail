package Test.IOAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileInJava8 {
    public String readFileWithStream(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());
        } catch (Exception ex) {
        }
        return String.join(" ", list);
    }

    public String readFileWithBufferedReaderAndStream(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            list = reader.lines().collect(Collectors.toList());
        } catch (Exception ex) {
            return "";
        }
        return String.join(" ", list);
    }

    public String bufferedReaderAndScanner(String fileName) {
        String result = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (Exception ex) {

        }
        return result;
    }

    public String readFileWithScanner(String fileName) {
        String result = "";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()){
                result += scanner.nextLine();
            }
        } catch (Exception exyuu) {
            return null;
        }

        return result;
    }

    public static void main(String[] args) {
        ReadFileInJava8 fileInJava8 = new ReadFileInJava8();
        System.out.println(fileInJava8.readFileWithScanner("read.txt"));
    }
}
