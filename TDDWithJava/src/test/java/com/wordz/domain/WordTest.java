package com.wordz.domain;

import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WordTest {

    @Test
    void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("Z");
        assertScoreForLetter(score, 0, Letter.INCORRECT);
    }

    @Test
    void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForLetter(score, 0, Letter.CORRECT);
    }

    @Test
    void secondLetterWrongPosition() {
        var word = new Word("AR");
        var score = word.guess("ZA");
        assertScoreForLetter(score, 1, Letter.PART_CORRECT);
    }

    @Test
    void allScoreCombination() {
        var word = new Word("ARI");
        var score = word.guess("ZAI");
        assertScoreForLetter(score, 0, Letter.INCORRECT);
        assertScoreForLetter(score, 1, Letter.PART_CORRECT);
        assertScoreForLetter(score, 2, Letter.CORRECT);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }
}
