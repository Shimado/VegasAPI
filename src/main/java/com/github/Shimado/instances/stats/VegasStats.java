package com.github.Shimado.instances.stats;

public class VegasStats {

    private int gamesPlayed = 0;
    private int victories = 0;
    private int bonuses = 0;
    private int defeats = 0;
    private int draws = 0;
    private int jackpots = 0;
    private double wonMoney = 0.0;
    private double lostMoney = 0.0;


    public VegasStats(){}

    public VegasStats(int gamesPlayed, int victories, int bonuses, int defeats, int draws, int jackpots, double wonMoney, double lostMoney){
        this.gamesPlayed = gamesPlayed;
        this.victories = victories;
        this.bonuses = bonuses;
        this.defeats = defeats;
        this.draws = draws;
        this.jackpots = jackpots;
        this.wonMoney = wonMoney;
        this.lostMoney = lostMoney;
    }


    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void addGamesPlayed() {
        gamesPlayed++;
    }


    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public void addVictory() {
        victories++;
    }


    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }

    public void addBonus() {
        bonuses++;
    }


    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void addDefeat() {
        defeats++;
    }


    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void addDraws() {
        draws++;
    }


    public int getJackpots() {
        return jackpots;
    }

    public void setJackpots(int jackpots) {
        this.jackpots = jackpots;
    }

    public void addJackpot() {
        jackpots++;
    }


    public double getWonMoney() {
        return wonMoney;
    }

    public void setWonMoney(double wonMoney) {
        this.wonMoney = wonMoney;
    }

    public void addWonMoney(double wonMoney) {
        this.wonMoney += wonMoney;
    }


    public double getLostMoney() {
        return lostMoney;
    }

    public void setLostMoney(double lostMoney) {
        this.lostMoney = lostMoney;
    }

    public void addLostMoney(double lostMoney) {
        this.lostMoney += lostMoney;
    }

}
