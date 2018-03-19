package IOAPI;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileInJava8 {
    public void writeToFile(String fileName, String text) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
        } catch (Exception ex) {

        }
    }

    public void writeWithFiles(String fileName, String text) {
        try {
            Files.write(Paths.get(fileName),text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriteFileInJava8 writeFileInJava8 = new WriteFileInJava8();
        writeFileInJava8.writeWithFiles("write.txt", "Nguyen Tan Hau");

    }
}
