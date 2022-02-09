/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Statics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Can
 */
public class EthStats {

    public static void main(String[] args) {

        System.out.println( getEthStats().keySet());

    }

    public static HashMap<String,String> getEthStats() {
         String res="";
        try {
            String cryptocomparekey = "cb9e6d83058ad506754d04bc5f7335f23d78a66dc6fb363e207c89a62799271d";
            String URL = "https://min-api.cryptocompare.com/data/blockchain/mining/calculator?fsyms=ETH&tsyms=USD&api_key={" + cryptocomparekey + "}";
            URL url = new URL(URL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            res = response.toString();

           

            in.close();
           
        } catch (IOException ex) {
            Logger.getLogger(EthStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getDataFromJSON(res);
    }

    public static HashMap<String,String> getDataFromJSON(String res) {
        HashMap<String,String> coininfos=new HashMap<>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(res);
            JSONObject data = (JSONObject) json.get("Data");
            JSONObject eth = (JSONObject) data.get("ETH");
            JSONObject usd = (JSONObject) eth.get("Price");
            String ethPrice = String.valueOf(usd.get("USD"));

            JSONObject coinInfo = (JSONObject) eth.get("CoinInfo");

            String blocktime = String.valueOf(coinInfo.get("BlockTime"));
            String blockreward = String.valueOf(coinInfo.get("BlockReward"));
            String hasrate = String.valueOf(coinInfo.get("NetHashesPerSecond"));
             

           
            coininfos.put("hasrate",hasrate);
            coininfos.put("blockreward", blockreward);
            coininfos.put("blocktime", blocktime);
            coininfos.put("ethPrice", ethPrice);
           
        } catch (ParseException ex) {
            Logger.getLogger(EthStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coininfos;
    }

}
