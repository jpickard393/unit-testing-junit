package com.practicalUnitTesting;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FootballTeamTest {
    private static final int THREE_GAMES_WON = 3;

    @Test
    void constructorShouldSetGAmesWon() {
           FootballTeam team = new FootballTeam(THREE_GAMES_WON);
           assertThat(team.getGamesWon()).as("number of games won").isEqualTo(THREE_GAMES_WON);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 10})
    void constructorShouldSetGamesWon(int nbOfGamesWon) {
        FootballTeam team = new FootballTeam(nbOfGamesWon);
        assertThat(team.getGamesWon()).as("number of games won").isEqualTo(nbOfGamesWon);
    }


}
