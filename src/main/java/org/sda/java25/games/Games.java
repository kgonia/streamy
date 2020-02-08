package org.sda.java25.games;

import org.sda.java25.games.comparators.BoardGameByPriceComparator;
import org.sda.java25.games.comparators.BoardGameByScoreComparator;
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
                }).sorted(new Comparator<BoardGame>() {
                    @Override
                    public int compare(BoardGame o1, BoardGame o2) {
                        BigDecimal price1 = o1.getPrice();
                        BigDecimal price2 = o2.getPrice();
                        return price1.compareTo(price2);
                    }
                })
                .sorted(new BoardGameByPriceComparator())
                .forEach(System.out::println);

        System.out.println();

        // 3. Wypisz najtańszą gry

        // sortujemy od najtanszej do najdrozszej i wybieramy pierwsza

        System.out.println("Wypisz najtańszą gry");
        GAMES.stream()
                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .limit(1)
                .forEach(System.out::println);


        // lub korzystamy z funkcji min
        System.out.println();
        BoardGame boardGameX = GAMES.stream()
                .min((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .get();

        System.out.println(boardGameX);

        Optional<BoardGame> optionalBoardGame = GAMES.stream()
                .min(Comparator.comparing(BoardGame::getPrice));

        GAMES.stream()
                .min((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .ifPresent(System.out::println);

        System.out.println();


        // 4. Wypisz najdroższą gre


        System.out.println("Wypisz najdroższą gre");
        // wybieramy najwiekszy element ze strumienia
        GAMES.stream()
                .max((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .ifPresent(System.out::println);

        // sortujemy malejaco i wyboeramy pierwszy element z strumienia
        // zwróc uwagę, że komparator jest podobny do tego z zadania nr. 3 ale obiekty sa porownywane na odwrot
        GAMES.stream()
                .sorted((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()))
                .limit(1)
                .forEach(System.out::println);

        // sortujemy malejaco i wyboeramy pierwszy element z strumienia
        GAMES.stream()
                .sorted(Comparator.comparing(BoardGame::getPrice).reversed())
                .limit(1)
                .forEach(System.out::println);


        // 5. Podaj średnią punktacje wszystkich gier

        double average = GAMES.stream().mapToDouble(BoardGame::getScore).average().getAsDouble();


        // 6. Wypisz kwotę do zapłaty za wszystkie gry po jednej sztuce (suma)

        // metoda reduce mówi jak mają byc redukowane elementy
        // mówimy jak z dwóch elementów danego typu stworzyc jeden obiekt np. poprzez dodawanie jesli sa to liczby
        System.out.println("Wypisz kwotę do zapłaty za wszystkie gry po jednej sztuce (suma)");
        GAMES.stream()
                .map(boardGame -> boardGame.getPrice())
                .reduce((bigDecimal, bigDecimal2) -> bigDecimal.add(bigDecimal2))
                .ifPresent(System.out::println);

        System.out.println();

        // w metodzie reduce mówimy jak zredukować dwa obiekty do jednego
        GAMES.stream()
                .map(BoardGame::getPrice)
                .reduce(BigDecimal::add)
                .ifPresent(System.out::println);

        System.out.println();


        // 7. Wypisz najdroższą grę wśród gier z ocena powyzej 8


        System.out.println("Wypisz najdroższą grę wśród gier z ocena powyzej 8");
        GAMES.stream()
                .filter(boardGame -> boardGame.getScore() > 8)
                .max((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .ifPresent(System.out::println);

        GAMES.stream()
                .filter(boardGame -> boardGame.getScore() > 8)
                .sorted(Comparator.comparing(BoardGame::getPrice).reversed())
                .limit(1)
                .forEach(System.out::println);

        // 8. Wypisz najtansza gre ze wszystkich gier dla maksymalnie 5 graczy

        System.out.println(" Wypisz najtansza gre ze wszystkich gier dla maksymalnie 5 graczy");
        GAMES.stream()
                .filter(boardGame -> boardGame.getMaximumPlayers() < 6)
                .min((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .ifPresent(System.out::println);
        // 9. Wypisz 3 gry ktore maja najgorsze oceny

        System.out.println("Najgorsze oceny");
        GAMES.stream()
//                .sorted(Comparator.comparing(BoardGame::getScore))
                .sorted(new BoardGameByScoreComparator())
                .limit(3)
                .forEach(System.out::println);

    }
}
