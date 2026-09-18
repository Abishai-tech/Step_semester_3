public class EmployeeConstructors {
 static class Employee{String empId,empName;double salary;boolean isIntern;Employee(String i,String n,double s){empId=i;empName=n;salary=s;isIntern=false;}Employee(String i,String n){this(i,n,0);isIntern=true;}void printProfile(){System.out.println(empId+" | "+empName+" | Rs "+salary+" | Intern: "+isIntern);}}
 public static void main(String[] args){new Employee("E-101","Divya",65000).printProfile();new Employee("E-102","Arjun").printProfile();}
}