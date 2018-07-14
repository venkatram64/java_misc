package com.venkat.test.feature;

import com.venkat.test.Employee;
import com.venkat.test.Person;

/**
 * Created by Venkatram on 2/24/2017.
 */
public class EmployeeService {


    final StringBuffer s = new StringBuffer("Veerareddy ");

    public void test(){
        s.append("Venkatram");
        System.out.println(s.toString());
    }

    public static void main(String[] args){
        Employee p = new Employee();
        p.getPerson();

        new EmployeeService().test();
    }
}
