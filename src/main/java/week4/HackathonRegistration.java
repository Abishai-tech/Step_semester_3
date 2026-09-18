public class HackathonRegistration {
 static class Participant{String name,teamName;boolean registered;Participant(String n,String t){name=n;teamName=t;registered=true;}Participant(String n){this(n,"Unassigned");}void printStatus(){System.out.println(name+" | "+teamName+" | Registered: "+registered);}}
 public static void main(String[] args){String[] n={"Ravi","Meera","Karthik","Divya"},t={"ByteBusters","","CodeCrafters",""};for(int i=0;i<n.length;i++)(t[i].isEmpty()?new Participant(n[i]):new Participant(n[i],t[i])).printStatus();}
}