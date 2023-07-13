package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
 class NewGameTest {
    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private Wordz wordz;

    @Test
    void startsNewGame() {

        var player = new Player();
        wordz.newGame(player);

        var gameArgument = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository)
                .create(gameArgument.capture());

        var game = gameArgument.getValue();

        assertThat(game.getWord()).isEqualTo("ARISE");
        assertThat(game.attemptNumber()).isZero();
        assertThat(game.getPlayer()).isSameAs(player);
    }
}
