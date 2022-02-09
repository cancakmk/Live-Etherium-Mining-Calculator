/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import static Model.MiningInputs.getPerMinuteEth;
import static Model.MiningInputs.printPowerConsUSD;
import static Model.MiningInputs.printminedEth;
import static Model.MiningInputs.printminedUSD;
import static Model.MiningInputs.printprofitUSD;
import Statics.EthStats;
import java.util.HashMap;

/**
 *
 * @author Can
 */
public class MiningCalculator {

    private final String mh;
    private final String numberofequipment;
    private final String totalNetworkHasrate;
    private final String blockReward;
    private final String blockTime;
    private final String ethPrice;
    private final String watt;
    private final String costperKwh;
    private final double minedperminute;
    
    
    private static final int hour=60;
    private static final int day=24;
    private static final int week=7;
    private static final int month=30;
    private static final int year=365;
    
   
    

    public MiningCalculator(String mh, String numberofequipment, String watt, String costperKwh) {
        HashMap<String, String> stats = EthStats.getEthStats();
        this.mh = mh;
        this.numberofequipment = numberofequipment;
        this.totalNetworkHasrate = stats.get("hasrate");
        this.blockReward = stats.get("blockreward");
        this.blockTime = stats.get("blocktime");
        this.ethPrice = stats.get("ethPrice");
        this.watt = watt;
        this.costperKwh = costperKwh;
        this.minedperminute=getPerMinuteEth(this);
        createMiningTable();
         
    }

    public void createMiningTable() {
        
        System.out.println("Mh: "+this.mh);
        System.out.println("Number of Equpment: "+this.numberofequipment);
        System.out.println("Watt Per Hour: "+this.watt);
        System.out.println("Cost per KWh: "+this.costperKwh);
        System.out.println("--------------------------------------");
        System.out.println("Total Network Hasrate: "+this.totalNetworkHasrate);
        System.out.println("Block Reward: "+this.blockReward);
        System.out.println("Block Time: "+this.blockTime);
        System.out.println("Etherium Price: $"+this.ethPrice);
        System.out.println("Mined Per Minute: "+this.minedperminute);
       
        
        
        System.out.println("--------------------------------------");
        printminedEth(this);
        System.out.println("--------------------------------------");
        printminedUSD(this);
        System.out.println("--------------------------------------");
        printPowerConsUSD(this);
        System.out.println("--------------------------------------");
        printprofitUSD(this);
        System.out.println("--------------------------------------");
    }

    public double getMinedperminute() {
        return minedperminute;
    }
    
    public String getWatt() {
        return watt;
    }

    public String getCostperKwh() {
        return costperKwh;
    }

    public String getMh() {
        return mh;
    }

    public String getNumberofequipment() {
        return numberofequipment;
    }

    public String getTotalNetworkHasrate() {
        return totalNetworkHasrate;
    }

    public String getBlockReward() {
        return blockReward;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public String getEthPrice() {
        return ethPrice;
    }
     public double getMinedEthPerMinute() {
        return this.minedperminute;
    }

    public double getMinedEthPerHour() {
        return getMinedEthPerMinute()*hour;
    }

    public double getMinedEthPerDay() {
        return getMinedEthPerHour()*day;
    }

    public double getMinedEthPerWeek() {
        return getMinedEthPerDay()*week;
    }

    public double getMinedEthPerMonth() {
        return getMinedEthPerDay()*month;
    }

    public double getMinedEthPerYear() {
        return getMinedEthPerDay()*year;
    }

    public double getEarnedPerMinuteUSD() {
        return getMinedEthPerMinute()*Double.parseDouble(this.ethPrice);
    }

    public double getEarnedPerHourUSD() {
        return getEarnedPerMinuteUSD()*hour;
    }

    public double getEarnedPerDayUSD() {
        return getEarnedPerHourUSD()*day;
    }

    public double getEarnedPerWeekUSD() {
        return getEarnedPerDayUSD()*week;
    }

    public double getEarnedPerMonthUSD() {
        return getEarnedPerDayUSD()*month;
    }

    public double getEarnedPerYearUSD() {
        return getEarnedPerDayUSD()*year;
    }
     public double getPowerConsumptionPerMinute() {
        double kw = Double.parseDouble(this.watt) / 1000;
        double costkhw = Double.parseDouble(this.costperKwh);
        double PowerConsumptionPerMinute = kw * costkhw/60;
        return PowerConsumptionPerMinute;
    }

    public double getPowerConsumptionPerHour() {
        return getPowerConsumptionPerMinute()*hour;
    }

    public double getPowerConsumptionPerDay() {
        return getPowerConsumptionPerHour()*day;
    }

    public double getPowerConsumptionPerWeek() {
        return  getPowerConsumptionPerDay()*week;
    }

    public double getPowerConsumptionPerMonth() {
        return  getPowerConsumptionPerDay()*month;
    }

    public double getPowerConsumptionPerYear() {
        return  getPowerConsumptionPerDay()*year;
    }

    public double getProfitPerMinuteUSD() {
        return getEarnedPerMinuteUSD()-getPowerConsumptionPerMinute();
    }

    public double getProfitPerHourUSD() {
        return getEarnedPerHourUSD()-getPowerConsumptionPerHour();
    }

    public double getProfitPerDayUSD() {
        return getEarnedPerDayUSD()-getPowerConsumptionPerDay();
    }

    public double getProfitPerWeekUSD() {
        return getEarnedPerWeekUSD()-getPowerConsumptionPerWeek();
    }

    public double getProfitPerMonthUSD() {
        return getEarnedPerMonthUSD()-getPowerConsumptionPerMonth();
    }

    public double getProfitPerYearUSD() {
        return getEarnedPerYearUSD()-getPowerConsumptionPerYear();
    }

   

}
