public class HallTicketReferenceDemo {
 static class HallTicket{String studentName;int seatNumber;HallTicket(String n,int s){studentName=n;seatNumber=s;}}
 public static void main(String[] args){HallTicket priya=new HallTicket("Priya",0),copy=priya;copy.seatNumber=45;HallTicket separate=new HallTicket("Priya",45);System.out.println("Priya's seatNumber (via first variable): "+priya.seatNumber);System.out.println("copy == priya: "+(copy==priya));System.out.println("separate == priya: "+(separate==priya));}
}