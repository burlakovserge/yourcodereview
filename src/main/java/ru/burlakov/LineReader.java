package ru.burlakov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LineReader implements CustomFileReader {
    private final LineCounter lineCounter;
    private String path;

    public LineReader(LineCounter lineCounter) {
        this.lineCounter = lineCounter;
    }

    public LineReader(String path, LineCounter lineCounter) {
        this.lineCounter = lineCounter;
        this.path = path;
    }

    @Override
    public void read() {
        try (BufferedReader br = new BufferedReader(new FileReader(path), 4096)) {
            String line;
            while (!Objects.equals(line = br.readLine(), null)) {
                lineCounter.count(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
