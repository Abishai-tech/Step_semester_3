import java.util.*;
public class TypingAccuracyChecker {
 static void checkTypingAccuracy(String o,String t){int n=Math.min(o.length(),t.length()),m=0,first=-1;for(int i=0;i<n;i++){if(o.charAt(i)==t.charAt(i))m++;else if(first==-1)first=i;}double acc=n==0?100.0:(m*100.0/Math.max(o.length(),t.length()));System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n",m,Math.max(o.length(),t.length()),acc);if(first==-1&&o.length()==t.length())System.out.println("No Mismatches");else if(first!=-1)System.out.println("First Mismatch at position "+(first+1)+" ('"+o.charAt(first)+"' vs '"+t.charAt(first)+"')");else System.out.println("Length mismatch");}
 public static void main(String[] args){Scanner s=new Scanner(System.in);String o=s.nextLine(),t=s.nextLine();checkTypingAccuracy(o,t);}
}