package com.wordz.domain;

public class WordSelection {
    private final WordRepository repository;
    private final RandomNumber random;

    public WordSelection(WordRepository repository, RandomNumber random) {
        this.repository = repository;
        this.random = random;
    }

    public String chooseRandomWord() {

        try {
            int wordNumber = random.next(repository.highestWordNumber());
            return repository.fetchWordByNumber(wordNumber);
        } catch (WordRepositoryException ex) {
            throw new WordSelectionException("Could not select word", ex);
        }
    }
}
