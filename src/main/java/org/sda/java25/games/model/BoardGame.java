package org.sda.java25.games.model;

import java.math.BigDecimal;

public class BoardGame implements Comparable<BoardGame> {

    private String name;

    private double score;

    private BigDecimal price;

    private int minimalPlayers;

    private int maximumPlayers;

    public BoardGame() {
    }

    public BoardGame(String name, double score, BigDecimal price, int minimalPlayers, int maximumPlayers) {
        this.name = name;
        this.score = score;
        this.price = price;
        this.minimalPlayers = minimalPlayers;
        this.maximumPlayers = maximumPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getMinimalPlayers() {
        return minimalPlayers;
    }

    public void setMinimalPlayers(int minimalPlayers) {
        this.minimalPlayers = minimalPlayers;
    }

    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    public void setMaximumPlayers(int maximumPlayers) {
        this.maximumPlayers = maximumPlayers;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", price=" + price +
                ", minimalPlayers=" + minimalPlayers +
                ", maximumPlayers=" + maximumPlayers +
                '}';
    }

    @Override
    public int compareTo(BoardGame o) {
        int result = this.getPrice().compareTo(o.getPrice());
        if(result == 0){
            return Double.compare(this.getScore(), o.getScore());
        }
        return result;
    }
}
