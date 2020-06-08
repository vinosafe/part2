package com.playsafetest.roulette;

public class BettingActivity {
 private String betType;
 private String betOutcome;
 private Double winnings;

  public String getBetType() {
    return betType;
  }

  public void setBetType(String betType) {
    this.betType = betType;
  }

  public String getBetOutcome() {
    return betOutcome;
  }

  public void setBetOutcome(String betOutcome) {
    this.betOutcome = betOutcome;
  }

  public Double getWinnings() {
    return winnings;
  }

  public void setWinnings(Double winnings) {
    this.winnings = winnings;
  }
}
