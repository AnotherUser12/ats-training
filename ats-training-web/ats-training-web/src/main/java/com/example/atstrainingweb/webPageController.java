package com.example.atstrainingweb;
import java.util.Map;
import ats.training.data.Department;
import ats.training.data.Employee;
import ats.training.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class webPageController {

    @GetMapping("/webPage")
    public String map(Model model) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //Call ats-core
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(4, "Mohammad", "a@a.com", 100000, new Department(1,"Food")));
        employees.add(new Employee(5, "Mahmoud", "a@a.com", 1000, new Department(3,"Management")));
        employees.add(new Employee(7, "khalid", "a@a.com", 20000, new Department(1,"Food")));
        EmployeeService service = new EmployeeService();
        String sEmployees = (String) employees.stream().map(e-> "<div class=\"employee\">" + (employees.indexOf(e)+1) + " - " + e.toString() + "</div>").collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "").replaceAll(",", " ");
        String sEmployeeMap ="";
        for (Map.Entry<Integer, ArrayList<Employee>> entry : service.convertToMap(employees).entrySet()) {
            int key = entry.getKey();
            ArrayList<Employee> value = entry.getValue();
            sEmployeeMap += "<div class=\"convertToMap-key\">" + value.get(0).getDepartment().getName() + " Department:</div>";
            for (Employee e : value) {
                sEmployeeMap += "<div class=\"employee\">" + (value.indexOf(e) + 1) + " - " + e.toString() + "</div>";
            }
        }
        String sSortedEmployees = service.sortEmployees(employees).stream().map(e-> "<div class=\"employee\">" + (service.sortEmployees(employees).indexOf(e)+1) + " - " + e.toString() + "</div>").collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "").replaceAll(",", " ");

        String sFindMOH = service.findMOH(employees).size() > 0?service.findMOH(employees).toString().replaceAll("[\\[\\]]", "") : "None";
        System.out.println();
        String sDuplicateIDs = service.findDuplicateIDs(employees).size() > 0? service.findDuplicateIDs(employees).toString().replaceAll("[\\[\\]]", ""): "None";

        model.addAttribute("employees", sEmployees);
        model.addAttribute("convertToMap", sEmployeeMap);
        model.addAttribute("findAhmadIbrahim", service.findAhmadIbrahim(employees));
        model.addAttribute("findDuplicateIDs", sDuplicateIDs);
        model.addAttribute("findMOH", sFindMOH);
        model.addAttribute("sortEmployees", sSortedEmployees);
        model.addAttribute("sumSalaries", "$" + service.sumSalaries(employees));
        return "webPage";
    }

}