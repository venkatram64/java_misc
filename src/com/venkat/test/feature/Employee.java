package com.venkat.test.feature;

import java.util.*;

/**
 * Created by Venkatram on 6/11/2017.
 */
public class Employee extends Human {

    private String empNo;
    private String designation;

    public Employee(String name, int age, String empNo, String designation){
        super(name,age);
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



    public static void main(String[] args){

        List<Employee> empList = new ArrayList<Employee>();

        List<Employee> linkedList = new LinkedList<Employee>();


        Employee emp = new Employee("Akhil", 24, "123422", "Software developer");
        empList.add(emp);
        linkedList.add(emp);

        emp = new Employee("Nikhil", 22, "1234", "Software developer");
        empList.add(emp);
        linkedList.add(emp);

        emp = new Employee("Aaryaa", 12, "1234545", "Software developer");
        empList.add(emp);
        linkedList.add(emp);


        /*List empList = new ArrayList();

        Employee emp = new Employee("Akhil", 24, "123422", "Software developer");
        empList.add(emp);

        emp = new Employee("Nikhil", 22, "1234", "Software developer");
        empList.add(emp);

        emp = new Employee("Aaryaa", 12, "1234545", "Software developer");
        empList.add(emp);
         Collections.sort(empList, new EmployeeComp());

        for(Object obj: empList){
            Employee e = (Employee)obj;
            System.out.println(" Employee name and age " + e.getName() + " " + e.getAge());

            System.out.println(" Employee emp no and designation " + e.getEmpNo() + " " + e.getDesignation());
        }
*/
        //String name = "Venkatram";

        //empList.add(name);

        Collections.sort(empList, new EmployeeComp());

        for(Employee e: empList){

            System.out.println(" Employee name and age " + e.getName() + " " + e.getAge());

            System.out.println(" Employee emp no and designation " + e.getEmpNo() + " " + e.getDesignation());
        }

        Iterator<Employee> iter = empList.iterator();

        while(iter.hasNext()){
            Employee e = iter.next();
            System.out.println("*** Employee name and age " + e.getName() + " " + e.getAge());

            System.out.println("*** Employee emp no and designation " + e.getEmpNo() + " " + e.getDesignation());
        }

        ListIterator<Employee> li = linkedList.listIterator();

        while(li.hasNext()){
            Employee e = li.next();
            System.out.println("linked list **** Employee name and age " + e.getName() + " " + e.getAge());

            System.out.println("linked list *** Employee emp no and designation " + e.getEmpNo() + " " + e.getDesignation());
        }

        emp.test();

        Map<String,String> map = new HashMap();
        map.put("Veerareddy", "Venkatram");
        map.put(null, "abc");
        map.put("lkjasdlfj", "iuiu");

        Set<String> set = map.keySet();

        Iterator<String> mapIter = set.iterator();

        while(mapIter.hasNext()){
            String key = mapIter.next();
            System.out.println("value is " + map.get(key));
        }



    }
}

class EmployeeComp implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

}

