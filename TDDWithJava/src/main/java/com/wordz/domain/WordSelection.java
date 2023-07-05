package com.wordz.domain;

public class WordSelection {
    public WordSelection(WordRepository repository, RandomNumber random) {
    }

    public String chooseRandomWord() {

        try {
           return " ";
        } catch (WordRepositoryException ex) {
            throw new WordSelectionException("Could not select word", ex);
        }
    }
}
