public class StaticEmployeeDemo {
 static class Employee{String empName;double salary;static String companyName="Bright Horizon Technologies";static int employeeCount;Employee(String n,double s){empName=n;salary=s;employeeCount++;}static void printCompanyInfo(){System.out.println(companyName);System.out.println("Employees on record: "+employeeCount);}}
 public static void main(String[] args){new Employee("A",1);new Employee("B",2);new Employee("C",3);Employee.printCompanyInfo();}
}