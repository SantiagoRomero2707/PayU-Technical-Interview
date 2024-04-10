package org.PayUTechnical;

import org.PayUTechnical.logic.Criteria;
import org.PayUTechnical.logic.NetworkPrioritization;

//Technical Interview Johan Santiago Romero Duarte

public class Main {
    public static void main(String[] args) {

        int [] responseTimes= {20, 15, 100, 15, 50, 9};
        int [] cost = {50, 60, 30, 55, 40, 70};

        Criteria criteria = Criteria.RESPONSE_TIME;
        int [] orderByCriteria;

        NetworkPrioritization orderByCriteriaMethod = new NetworkPrioritization();
        orderByCriteria = orderByCriteriaMethod.prioritizeNetwork(responseTimes, cost, criteria);

        System.out.println("Response for " + criteria);
        for (Integer orderByCriterion : orderByCriteria) {
            System.out.print(orderByCriterion + "  ");
        }
    }
}