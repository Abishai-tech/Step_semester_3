import java.util.*;
public class ProductInventoryCSVParser {
 static void parseInventoryRecord(String s){String[] a=s.split(",");if(a.length!=3)System.out.println("Invalid Record");else System.out.println("Product: "+a[0]+" | SKU: "+a[1]+" | Qty: "+a[2]);}
 public static void main(String[] args){parseInventoryRecord(new Scanner(System.in).nextLine());}
}