package SDA_UAS_K10;

public class Node {
    public String id;
    public String harga;
    public String nama;
    public String topping;
    public Node leftChild;
    public Node rightChild;

    public Node(String id, String harga, String nama, String topping) {
        this.id = id;
        this.harga = harga;
        this.nama = nama;
        this.topping = topping;
        leftChild = null;
        rightChild = null;
    }

    public void displayNode(){
        System.out.println("ID Kue : "+id+"\n" +
                "Nama Kue : "+nama+"\n" +
                "Topping Kue : "+topping+"\n" +
                "Harga Kue : "+harga+"\n\n");
    }
}
