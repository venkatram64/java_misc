package com.venkat.work.factory;

import com.venkat.work.plan.CommercialPlan;
import com.venkat.work.plan.DomesticPlan;
import com.venkat.work.plan.InstitutionalPlan;
import com.venkat.work.plan.Plan;


/**
 * Created by Venkatram on 2/25/2017.
 */
public class PlanFactory {

    public Plan getPlan(PlanType planType){
        String name = planType.getName();

        if(planType == PlanType.DOMESTIC_PLAN){
            return new DomesticPlan();
        }else if(planType == PlanType.COMMERCIAL_PLAN){
            return new CommercialPlan();
        }else if(planType == PlanType.INSTITUTIONAL_PLAN){
            return new InstitutionalPlan();
        }
        return null;
    }

    public static void main(String[] args){
        PlanFactory pf = new PlanFactory();
        Plan dp = pf.getPlan(PlanType.DOMESTIC_PLAN);
        dp.getRate();
        System.out.println(dp.calculateBill(67));
    }
}
