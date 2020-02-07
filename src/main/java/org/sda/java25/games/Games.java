package org.sda.java25.games;

import org.sda.java25.games.comparators.BoardGameByPriceComparator;
import org.sda.java25.games.model.BoardGame;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Games {

    // zmienna GAMES to lista ze wszystkimi grami
    public final static List<BoardGame> GAMES = Arrays.asList(
            new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
            new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
            new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
            new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
            new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
            new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
            new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
            new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
            new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
            new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
    );

    public static void main(String[] args) {

        List<BoardGame> wybraneGry = new ArrayList<>();

        // Korzystając z pętli i intrukcji warunkowych wpisz do listy wybraneGry
        // wszystkie gry z listy GAMES które
        // pozwolają na grę w więcej niż 4 osoby,
        // mają ocenę wyższą niż 8,
        // kosztują mniej niż 150 zł

        for (BoardGame game : GAMES) {
            if (game.getMaximumPlayers() > 4 && game.getScore() > 8 && game.getPrice().compareTo(new BigDecimal("150")) < 0) {
                wybraneGry.add(game);
            }
        }

        for (BoardGame game : wybraneGry) {
            System.out.println(game.toString());
        }

        // Przykład od prowadzącego
        // tworzymy strumien
        List<BoardGame> games = GAMES.stream()
                .filter(boardGame -> boardGame.getMaximumPlayers() > 4) //filtrujemy obiekty w strumieniu
                .filter(boardGame -> boardGame.getScore() > 8)
                // cena gry w porównaniu do 150 musi byc mniejsza wiec comaparator ma zwrocic mniej niz 0
                .filter(boardGame -> boardGame.getPrice().compareTo(new BigDecimal("150")) < 0)
                .collect(Collectors.toList());

        System.out.println();
        for (BoardGame game : games) {
            System.out.println(game.toString());
        }

        // strumien mozemy zapisac w kilku etapach
        Stream<BoardGame> boardGameStream = GAMES.stream();
        Stream<BoardGame> onlyForMoteThan4Players = boardGameStream.filter(boardGame -> boardGame.getMaximumPlayers() > 4);
        System.out.println();
        // 1. wypisz wszystkie gry dla minimum dwóch graczy

        System.out.println("wypisz wszystkie gry dla minimum dwóch graczy");
        List<BoardGame> gamesFor2Players = GAMES.stream()
                .filter(boardGame -> boardGame.getMinimalPlayers() >= 2)
                .collect(Collectors.toList());

        for (BoardGame boardGame : gamesFor2Players) {
            System.out.println(boardGame);
        }

        System.out.println();
        GAMES.stream()
                .filter(boardGame -> boardGame.getMinimalPlayers() >= 2)
                .forEach(boardGame -> System.out.println(boardGame));

        System.out.println();
        GAMES.stream()
                .filter(boardGame -> boardGame.getMinimalPlayers() >= 2)
                .forEach(System.out::println);

        // 2. Posortuj gry wg ceny

        // wszystkie sposby daja nam ten sam efekt - porwanie gier po cenie
        // mozemy uzyc gotowego comparatora lub stworzyc go za pomoca lmbdy lub klasy anoniowej

        System.out.println();
        System.out.println("Posortuj gry wg ceny");
        GAMES.stream()
                .sorted(new BoardGameByPriceComparator())
                .forEach(System.out::println);

        System.out.println();
        GAMES.stream()
                .sorted(Comparator.comparing(BoardGame::getPrice))
                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .sorted((BoardGame o1, BoardGame o2) -> {
                    BigDecimal price1 = o1.getPrice();
                    BigDecimal price2 = o2.getPrice();
                    return price1.compareTo(price2);
                })
                .sorted(new BoardGameByPriceComparator())
                .forEach(System.out::println);

        System.out.println();

        // 3. Wypisz najtańszą gry


        // 4. Wypisz najdroższą gre


        // 5. Podaj średnią punktacje wszystkich gier


        // 6. Wypisz kwotę do zapłaty za wszystkie gry po jednej sztuce (suma)


        // 7. Wypisz najdroższą grę wśród gier z ocena powyzej 8


        // 8. Wypisz najtansza gre ze wszystkich gier dla maksymalnie 5 graczy



        // 9. Wypisz 3 gry ktore maja najgorsze oceny



    }
}
