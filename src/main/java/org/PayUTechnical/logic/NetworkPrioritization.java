package org.PayUTechnical.logic;

import java.util.*;

public class NetworkPrioritization {

    public int [] prioritizeNetwork(int[] responseTimes, int[] cost, Criteria criteria)   {

        //Sort arrangement information in a HashMap
        HashMap<Integer, PaymentNetwork> networkPrioritizationMap = new HashMap<>();

        for(int i =0; i < responseTimes.length; i++){
            PaymentNetwork paymentObject = new PaymentNetwork();
            paymentObject.setCost(cost[i]);
            paymentObject.setResponseTimes(responseTimes[i]);
            networkPrioritizationMap.put(i,paymentObject);
        }

        //I create a list of PaymentNetwork objects with HashMap values
        List<PaymentNetwork> netWorkPriozationList = new ArrayList<>(networkPrioritizationMap.values());

        // Perform the ordering according to the criterion
        if(Criteria.RESPONSE_TIME.equals(criteria)){
            netWorkPriozationList.sort(
                    Comparator.comparing(PaymentNetwork::getResponseTimes)
                            .thenComparing(PaymentNetwork::getCost)
            );
        }
        else if(Criteria.COST.equals(criteria)){
            netWorkPriozationList.sort(
                    Comparator.comparing(PaymentNetwork::getCost)
                            .thenComparing(PaymentNetwork::getResponseTimes)
            );
        }

        List<Integer> listResponse = new ArrayList<>();

        // Get the key based on the ordered array values and then add it
        for(int j = 0; j<netWorkPriozationList.size(); j++){
            for(Map.Entry<Integer, PaymentNetwork> entryNetwork : networkPrioritizationMap.entrySet()){
                if(entryNetwork.getValue().equals(netWorkPriozationList.get(j))){
                    Integer originalKey = entryNetwork.getKey();
                    listResponse.add(originalKey);
                    break;
                }
            }
        }

        // Convert ArrayList Of Integer in an Array
        return ConvertArrayListToArray(listResponse);
    }


    public int[] ConvertArrayListToArray(List<Integer> arrayListInteger) {

        int[] arrayConvert = new int[arrayListInteger.size()];

        for (int i = 0; i < arrayListInteger.size(); i++) {
            arrayConvert[i] = arrayListInteger.get(i);
        }

        return arrayConvert;
    }
}
