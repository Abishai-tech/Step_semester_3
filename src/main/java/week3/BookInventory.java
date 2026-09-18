import java.util.*;
public class BookInventory {
 String title,author;int copiesAvailable;
 BookInventory(String t,String a,int c){title=t;author=a;copiesAvailable=c;}
 void printEntry(){System.out.println(title+" by "+author+" - "+copiesAvailable+" copies available");}
 public static void main(String[] args){BookInventory[] b={new BookInventory("Clean Code","Robert C. Martin",3),new BookInventory("Effective Java","Joshua Bloch",5),new BookInventory("Refactoring","Martin Fowler",0),new BookInventory("Design Patterns","GoF",2)};for(BookInventory x:b)x.printEntry();}
}