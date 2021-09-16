package ats.training.service;

import ats.training.data.Department;
import ats.training.data.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    //testing
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(4, "Mohammad", "a@a.com", 100000, new Department(1,"Food")));
        employees.add(new Employee(5, "Mahmoud", "a@a.com", 1000, new Department(3,"Management")));
        employees.add(new Employee(7, "khalid", "a@a.com", 20000, new Department(1,"Food")));
        EmployeeService service = new EmployeeService();
        service.sumSalaries(employees);
    }
    public List<Employee> sortEmployees(ArrayList<Employee> employees) {
//        for (int i = 0; i < employees.size() - 1; i++) {
//            int highestSalary = i;
//            for (int j = i + 1; j < employees.size(); j++) {
//                if (employees.get(j).getSalary() > employees.get(highestSalary).getSalary()) {
//                    highestSalary = j;
//                }
//            }
//            Employee temp = employees.get(i);
//            employees.set(i, employees.get(highestSalary));
//            employees.set(highestSalary, temp);
//        }
        return (employees.stream().sorted((e1,e2)->
        {
            if(e2.getSalary()>e1.getSalary()){
                return 1;
            }else{
                return-1;
            }
        }).collect(Collectors.toList()));
    }

    public List<String> findMOH(ArrayList<Employee> employees){
        return (employees.stream().filter(e->(e.getName().toUpperCase().contains("MOH"))).map(e->e.getName()).collect(Collectors.toList()));
//        for(Employee employee: employees){
//            if (employee.getName().toUpperCase().indexOf("MOH") != -1) {
//                System.out.println(employee.getName());
//            }
//        }
    }

    public String findAhmadIbrahim(ArrayList<Employee> employees){
        //flag that represents whether Ahmad Ibrahim's record is found
        //boolean ahmadFound = false;
        List<String> ahmadIbrahims = employees.stream().filter(e->(e.getName().equals("Ahmad Ibrahim")&&e.getSalary()==1000)).map(e->e.toString()).collect(Collectors.toList());
        if(ahmadIbrahims.isEmpty()){
            return "No Match";
        }else{
            return "Ahmad Ibrahims: " + ahmadIbrahims;
        }
//        for(Employee employee: employees){
//            if (employee.getName().equals("Ahmad Ibrahim") && employee.getSalary() == 1000) {
//                System.out.println("ID: " + employee.getID() + "; Email: " + employee.getEmail() + "; Name: Ahmad Ibrahim; Salary: 1000 JD; Department: " + employee.getDepartment().getName());
//                ahmadFound = true;
//            }
//        }
//        if (!ahmadFound) {
//            System.out.println("No Match");
//        }
    }

    public ArrayList<Integer> findDuplicateIDs(ArrayList<Employee> employees){
//        //List of duplicate IDs
//        ArrayList<Integer> duplicateIDs = new ArrayList<Integer>();
//        outerLoop:
//        for (int i = 0; i < employees.size() - 1; i++) {
//            if(duplicateIDs.indexOf(employees.get(i).getID()) == -1){
//                continue;
//            }
//            for (int j = i + 1; j < employees.size(); j++) {
//                if (employees.get(i).getID() == employees.get(j).getID()) {
//                    System.out.println("Duplicated ID: " + employees.get(i).getID());
//                    duplicateIDs.add(employees.get(i).getID());
//                    continue outerLoop;
//                }
//            }
//        }
        ArrayList<Integer> printedDuplicates = new ArrayList<Integer>();
        List<Integer> IDs = employees.stream().map(e->e.getID()).collect(Collectors.toList());
        IDs.stream().filter(i -> Collections.frequency(IDs, i) > 1).forEach(id-> {
            if(printedDuplicates.indexOf(id) == -1){
                printedDuplicates.add(id);
            }
        });
        return printedDuplicates;
    }

    public HashMap<Integer, ArrayList<Employee>> convertToMap(ArrayList<Employee> employees){
        //map of employees by department
        HashMap<Integer, ArrayList<Employee>> depMap = new HashMap<Integer, ArrayList<Employee>>();
//        for(Employee employee: employees){
//            if (depMap.containsKey(employee.getDepartment().getID())) {
//                depMap.get(employee.getDepartment().getID()).add(employee);
//            } else {
//                depMap.put(employee.getDepartment().getID(), new ArrayList<Employee>());
//                depMap.get(employee.getDepartment().getID()).add(employee);
//            }
//        }
//        return depMap;
        employees.stream().forEach(e->{
            if(depMap.containsKey(e.getDepartment().getID())){
                depMap.get(e.getDepartment().getID()).add(e);
            } else {
                depMap.put(e.getDepartment().getID(), new ArrayList<Employee>());
                depMap.get(e.getDepartment().getID()).add(e);
            }
        });
        return depMap;
    }

    public double sumSalaries(ArrayList<Employee> employees){
//        double salarySum = 0;
//        for (Employee employee : employees) {
//            salarySum += employee.getSalary();
//        }
        double salarySum = employees.stream().map(e->e.getSalary()).reduce(0.0, Double::sum);
        return salarySum;
    }
}
