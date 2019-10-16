package org.academiadecodigo.splicegirls36.wordreader;

public class Main {

    public static final String FILE = "./resources/test.txt";

    public static void main(String[] args) {

        WordReader wordReader = new WordReader(FILE);

        wordReader.readFileByWord();

        for (String word : wordReader) {
            System.out.println(word);
        }
    }
}
