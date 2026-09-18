import java.util.*;
public class StopWordFrequencyReport {
 static void printFilteredWordFrequency(String s){Set<String> stop=new HashSet<>(Arrays.asList("the","was","and","a","is","of","in"));Map<String,Integer> m=new HashMap<>();for(String w:s.toLowerCase().replace(".","").replace(",","").split("\\s+"))if(!stop.contains(w))m.put(w,m.getOrDefault(w,0)+1);m.entrySet().stream().sorted((x,y)->y.getValue()-x.getValue()).forEach(e->System.out.println(e.getKey()+": "+e.getValue()));}
 public static void main(String[] args){printFilteredWordFrequency(new Scanner(System.in).nextLine());}
}