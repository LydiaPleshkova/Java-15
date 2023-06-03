package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void shouldTestWhenPlayer1Wins() {
        Player John = new Player(1, "John", 100);
        Player Jack = new Player(1, "Jack", 80);
        Game game = new Game();

        game.register(John);
        game.register(Jack);
        int actual = game.round("John", "Jack");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenPlayer2Wins() {
        Player John = new Player(1, "John", 100);
        Player Jack = new Player(1, "Jack", 130);
        Game game = new Game();

        game.register(John);
        game.register(Jack);
        int actual = game.round("John", "Jack");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenPlayersEqual() {
        Player John = new Player(1, "John", 120);
        Player Jack = new Player(1, "Jack", 120);
        Game game = new Game();

        game.register(John);
        game.register(Jack);
        int actual = game.round("John", "Jack");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenPlayer1NotExist() {
        Player John = new Player(1, "John", 100);
        Player Jack = new Player(1, "Jack", 130);
        Game game = new Game();

        game.register(John);
        game.register(Jack);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Mark", "Jack")
        );
    }

    @Test
    public void shouldTestWhenPlayer2NotExist() {
        Player John = new Player(1, "John", 100);
        Player Jack = new Player(1, "Jack", 130);
        Game game = new Game();

        game.register(John);
        game.register(Jack);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("John", "Doug")
        );
    }

    @Test
    public void shouldTestWhenNoPlayers() {
        Player John = new Player(1, "John", 100);
        Player Jack = new Player(1, "Jack", 130);
        Game game = new Game();

        game.register(John);
        game.register(Jack);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Mark", "Doug")
        );
    }
}