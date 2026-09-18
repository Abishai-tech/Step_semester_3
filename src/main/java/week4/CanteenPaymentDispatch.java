public class CanteenPaymentDispatch {
 static class Payment{double pay(double a){System.out.println("Paid (cash): Rs "+a);return a;}}
 static class CardPayment extends Payment{double payWithProcessingFee(double a){double x=a*1.02;System.out.println("Charged (card, incl. fee): Rs "+x);return x;}}
 static double processTransaction(Payment p,double a){if(p instanceof CardPayment)return ((CardPayment)p).payWithProcessingFee(a);return p.pay(a);}
 public static void main(String[] args){Payment[] p={new CardPayment(),new Payment(),new CardPayment(),new Payment(),new CardPayment()};double[] a={100,50,200,75,120};double t=0;for(int i=0;i<p.length;i++)t+=processTransaction(p[i],a[i]);System.out.println("Total Collected: Rs "+t);}
}