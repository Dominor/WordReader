package org.academiadecodigo.splicegirls36.wordreader;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WordReader implements Iterable<String> {

    private String file;
    private List<String> fileContent;

    WordReader(String file) {

        this.file = file;
        this.fileContent = new LinkedList<>();
    }

    public void readFileByWord () {

        String line;
        List<String> filteredWords;
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(file));

            while ((line = fileReader.readLine()) != null) {

                filteredWords = filterWords(line);
                fileContent.addAll(filteredWords);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        finally {
            cleanUp(fileReader);
        }
    }

    private void cleanUp(BufferedReader input) {
        try {
            input.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private List<String> filterWords (String line) {

        List<String> result = new LinkedList<>();
        final String regex = "\\W+";

        Collections.addAll(result, line.split(regex));
        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return fileContent.iterator();
    }
}
