package org.sda.java25.games.comparators;

import org.sda.java25.games.model.BoardGame;

import java.util.Comparator;

public class BoardGameByPriceComparator implements Comparator<BoardGame> {

    // zwracamy liczbe dodatnia jesli o1 jest wieksze od o2
    // zwracamy 0 jesli o1 jest rowne o2
    // zrwacamy liczbe ujemna jezeli o1 jest mniejsze od o2
    @Override
    public int compare(BoardGame o1, BoardGame o2) {

        /*
        BigDecimal price1 = o1.getPrice();
        BigDecimal price2 = o2.getPrice();
        price1.compareTo(price2);
        */

        return o1.getPrice().compareTo(o2.getPrice());
    }
}
