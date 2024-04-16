package Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ManipulationFile {

    private List<String> lines;
    private Path filePath;

    public ManipulationFile() {
        lines = new ArrayList<>();
    }

    public List<String> readFile(String filePath) {
        this.filePath = Paths.get(filePath);

        try {
            this.lines = Files.readAllLines(this.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
