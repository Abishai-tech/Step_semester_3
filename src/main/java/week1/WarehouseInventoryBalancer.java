import java.util.*;
public class WarehouseInventoryBalancer {
 static void analyzeInventory(int[] a,int[] b){int sa=0,sb=0,max=Integer.MIN_VALUE,sec=0,idx=0;for(int i=0;i<a.length;i++){sa+=a[i];if(a[i]>max){max=a[i];sec=1;idx=i+1;} }for(int i=0;i<b.length;i++){sb+=b[i];if(b[i]>max){max=b[i];sec=2;idx=i+1;}}System.out.print("Section A Total: "+sa+" | Section B Total: "+sb+" | Status: "+(sa==sb?"Balanced":"Not Balanced")+" | Highest Quantity: "+max+" (Section "+(sec==1?"A":"B")+", Item "+idx+")");}
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();int[] a=new int[n],b=new int[n];for(int i=0;i<n;i++)a[i]=s.nextInt();for(int i=0;i<n;i++)b[i]=s.nextInt();analyzeInventory(a,b);}
}