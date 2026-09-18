import java.util.*;
public class TrafficSignalStreakAnalyzer {
 static void findLongestStreak(String x){if(x.isEmpty())return;char best=x.charAt(0),cur=x.charAt(0);int len=1,bestLen=1;for(int i=1;i<x.length();i++){if(x.charAt(i)==cur)len++;else{cur=x.charAt(i);len=1;}if(len>bestLen){bestLen=len;best=cur;}}System.out.println("Longest Streak: '"+best+"' repeated "+bestLen+" times");}
 public static void main(String[] args){findLongestStreak(new Scanner(System.in).nextLine());}
}