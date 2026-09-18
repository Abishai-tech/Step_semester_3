import java.util.*;
public class MovieReviewProfiler {
 static void classifyWordLengths(String r){int sh=0,me=0,lo=0;for(String w:r.trim().split("\\s+")){w=w.replaceAll("[^A-Za-z]","");int n=w.length();if(n>=1&&n<=4)sh++;else if(n<=8)me++;else if(n>=9)lo++;}System.out.println("Short: "+sh+" | Medium: "+me+" | Long: "+lo);}
 public static void main(String[] args){classifyWordLengths(new Scanner(System.in).nextLine());}
}