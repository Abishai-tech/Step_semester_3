public class CanteenInventory {
 static class Item{String itemName;int stock;Item(String itemName,int stock){this.itemName=itemName;this.stock=stock;}void restock(int stock){this.stock+=stock;}}
 public static void main(String[] args){Item[] a={new Item("Samosa",15),new Item("Tea Powder",40),new Item("Bread",8),new Item("Biscuit Packs",25)};for(Item x:a){x.restock(20);System.out.println(x.itemName+" | Final Stock: "+x.stock);}}
}