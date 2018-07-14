package com.venkat.test.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Venkatram on 6/11/2017.
 */
public class Emp implements Comparable<Emp>{

    private String empNo;
    private String designation;

    //private Human human;

    public Emp(String name, int age, String empNo, String designation){
        //human = new Human(name, age);
        this.empNo = empNo;
        this.designation = designation;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public int compareTo(Emp o) {
        return this.getEmpNo().compareTo(o.getEmpNo());
    }

    /* public Human getHuman(){
        return human;
    }*/

    public static void main(String[] args){
        List<Emp> empList = new ArrayList<Emp>();

        Emp emp = new Emp("Akhil", 24, "1234", "Software developer");
        empList.add(emp);
        emp = new Emp("Nikhil", 22, "123", "Software engineer");
        empList.add(emp);

        Collections.sort(empList);

        for(Emp e: empList){
            System.out.println(" Employee emp no and designation " + e.getEmpNo() + " " + e.getDesignation());
        }

        //System.out.println(" Employee name and age " + emp.getHuman().getName() + " " + emp.getHuman().getAge());

       // System.out.println(" Employee emp no and designation " + emp.getEmpNo() + " " + emp.getDesignation());



    }
}
