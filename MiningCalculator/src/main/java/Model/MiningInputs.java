/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.MiningCalculator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 *
 * @author Can
 */
public class MiningInputs {

    

    public static double getPerMinuteEth(MiningCalculator rig) {
        int scale = 30;

        
        BigDecimal minedEthPerMinute=new BigDecimal(rig.getBlockReward())
                .multiply(new BigDecimal(rig.getMh())).setScale(scale)
                .multiply(new BigDecimal(rig.getNumberofequipment())).setScale(scale)
                .multiply(new BigDecimal("60000000")).setScale(scale)
                .divide(new BigDecimal(rig.getBlockTime()),BigDecimal.ROUND_HALF_EVEN)
                .divide(new BigDecimal(rig.getTotalNetworkHasrate()),BigDecimal.ROUND_HALF_EVEN);

       
        
        


        return minedEthPerMinute.doubleValue();

    }
    public static void printminedEth(MiningCalculator rig){
        System.out.println("Mined Eth Per Minute: "+rig.getMinedEthPerMinute()); 
        System.out.println("Mined Eth Per Hour: "+rig.getMinedEthPerHour()); 
        System.out.println("Mined Eth Per Day: "+rig.getMinedEthPerDay()); 
        System.out.println("Mined Eth Per Week: "+rig.getMinedEthPerWeek()); 
        System.out.println("Mined Eth Per Month: "+rig.getMinedEthPerMonth()); 
        System.out.println("Mined Eth Per Year: "+rig.getMinedEthPerYear()); 
    }
    public static void printminedUSD(MiningCalculator rig ){
        System.out.println("Earned Per Minute USD: $" + rig.getEarnedPerMinuteUSD());
        System.out.println("Earned Per Hour USD: $" + rig.getEarnedPerHourUSD());
        System.out.println("Earned Per Day USD: $" + rig.getEarnedPerDayUSD());
        System.out.println("Earned Per Week USD: $" + rig.getEarnedPerWeekUSD());
        System.out.println("Earned Per Month USD: $" + rig.getEarnedPerMonthUSD());
        System.out.println("Earned Per Year USD: $" + rig.getEarnedPerYearUSD());
    }
    public static void printprofitUSD(MiningCalculator rig){
       
        
        System.out.println("Profit Per Minute USD: $" + rig.getProfitPerMinuteUSD());
        System.out.println("Profit Per Hour USD: $" + rig.getProfitPerHourUSD());
        System.out.println("Profit Per Day USD: $" + rig.getProfitPerDayUSD());
        System.out.println("Profit Per Week USD: $" + rig.getProfitPerWeekUSD());
        System.out.println("Profit Per Month USD: $" + rig.getProfitPerMonthUSD());
        System.out.println("Profit Per Year USD: $" + rig.getProfitPerYearUSD());
    } 
    public static void printPowerConsUSD(MiningCalculator rig){
        System.out.println("Power Consumption Per Minute: $"+rig.getPowerConsumptionPerMinute());
        System.out.println("Power Consumption Per Hour: $"+rig.getPowerConsumptionPerHour());
        System.out.println("Power Consumption Per Day: $"+rig.getPowerConsumptionPerDay());
        System.out.println("Power Consumption Per Week: $"+rig.getPowerConsumptionPerWeek());
        System.out.println("Power Consumption Per Month: $"+rig.getPowerConsumptionPerMonth());
        System.out.println("Power Consumption Per Year: $"+rig.getPowerConsumptionPerYear());
         
     }
}
