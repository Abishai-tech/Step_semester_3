import java.util.*;
public class ISBNNormalizerValidator {
 static String normalizeCode(String r){r=r.trim();return r.length()<3?r:r.substring(0,3).toUpperCase()+r.substring(3);}
 static String validateAndFormat(String c){if(c.length()!=13)return "Invalid: wrong length";for(int i=0;i<3;i++)if(!Character.isLetter(c.charAt(i)))return "Invalid: publisher code must be 3 letters";for(int i=3;i<13;i++)if(!Character.isDigit(c.charAt(i)))return "Invalid: body must be digits";return "["+c.substring(0,3)+"] YEAR: "+c.substring(3,7)+" | CATALOG: "+c.substring(7);}
 public static void main(String[] args){String c=normalizeCode(new Scanner(System.in).nextLine());System.out.println(validateAndFormat(c));}
}