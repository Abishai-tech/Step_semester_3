import java.util.*;
public class SeatDuplicationChecker {
 static void checkDuplicateSeats(int[] a){boolean found=false;for(int i=0;i<a.length;i++)for(int j=i+1;j<a.length;j++)if(a[i]==a[j]){System.out.println("Duplicate Seat Number Found: "+a[i]);found=true;break;}if(!found)System.out.println("No Duplicate Seats Found");}
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt(),a[]=new int[n];for(int i=0;i<n;i++)a[i]=s.nextInt();checkDuplicateSeats(a);}
}