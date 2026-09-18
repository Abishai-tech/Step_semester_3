import java.util.*;
public class PayrollAccount {
 private double basicSalary,bonus;
 public PayrollAccount(double s){if(s<0){System.out.println("Invalid salary");s=0;}basicSalary=s;}
 public void creditBonus(double a){if(a<=0)System.out.println("Invalid bonus");else{bonus+=a;System.out.println("Bonus credited: Rs "+a);}}
 public void deductTax(double p){if(p<0||p>100)System.out.println("Invalid tax");else{basicSalary-=basicSalary*p/100;System.out.println("Tax deducted: "+p+"%");}}
 public double getNetSalary(){return basicSalary+bonus;}
 public static void main(String[] args){PayrollAccount p=new PayrollAccount(50000);p.creditBonus(5000);p.deductTax(10);System.out.println("Net salary: Rs "+p.getNetSalary());}
}