package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WordTest {

    @Test
    void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("Z");
        assertScoreForGuess(score, INCORRECT);
    }

    @Test
    void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForGuess(score, CORRECT);
    }

    @Test
    void secondLetterWrongPosition() {
        var word = new Word("AR");
        var score = word.guess("ZA");
        assertScoreForGuess(score,
                INCORRECT,
                PART_CORRECT);
    }

    @Test
    void allScoreCombination() {
        var word = new Word("ARI");
        var score = word.guess("ZAI");

        assertScoreForGuess(score,
                INCORRECT,
                PART_CORRECT,
                CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expected) {
        for (int i = 0; i < expected.length; i++) {
            assertThat(score.letter(i)).isEqualTo(expected[i]);
        }
    }
}
