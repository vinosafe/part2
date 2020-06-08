package com.playsafetest.roulette;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private List<BettingActivity> bettingActivities = new ArrayList();

  public Player (String name){
    this.name = name;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<BettingActivity> getBettingActivities (){
    return bettingActivities;
  }

  public void setBettingActivities (BettingActivity bettingActivity){
    bettingActivities.add(bettingActivity);
  }
}
