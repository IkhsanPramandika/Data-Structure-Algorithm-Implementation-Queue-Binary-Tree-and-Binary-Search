package UAS_SDA;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class treePesananKue {
    public nodePesananKue root;
    int jumlah, leave;
    static int id;
    static int harga ;
    static String nama;

    public treePesananKue() {
        root = null;
    }

    public void sisipdtNode(int dtSisip) {
        if (root == null) {
            root = new nodePesananKue(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
        jumlah++;
    }




    public int getJumlah() {
        return jumlah;
    }


    public nodePesananKue find(int data) {
        nodePesananKue current = root;
        while (current.data !=data){
            if(data<current.data){
                current = current.nodeKiri;
            } else {
                current = current.nodeKanan;
            }
            if(current==null){
                return null;
            }
        }
        return current;
    }

    //CODINGAN PREORDER TRAVERSAL
    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(nodePesananKue node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.data);
        preorder(node.nodeKiri);
        preorder(node.nodeKanan);
    }

    public void getDaun(nodePesananKue node) {
        if (node.nodeKanan == null) {
            if (node.nodeKiri == null) {
                leave++;
            } else {
                getDaun(node.nodeKiri);
            }
        } else if (node.nodeKiri == null) {
            if (node.nodeKanan == null) {
                leave++;
            } else {
                getDaun(node.nodeKanan);
            }
        } else if (node.nodeKanan != null && node.nodeKiri != null) {
            getDaun(node.nodeKiri);
            getDaun(node.nodeKanan);
        }
    }

    private int ceklevel(nodePesananKue node) {
        if (node != null) {
            int a = ceklevel(node.nodeKiri);
            int b = ceklevel(node.nodeKanan);
            if (a > b) {
                return a = a + 1;
            } else {
                return b = b + 1;
            }
        } else {
            return -1;
        }
    }

    public int Level() {
        return ceklevel(root);
    }

    public void cekDaun() {
        getDaun(root);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(nodePesananKue node) {
        if (node == null) {
            return;
        }
        inorder(node.nodeKiri);
        System.out.printf("%d ", node.data);
        inorder(node.nodeKanan);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(nodePesananKue node) {
        if (node == null) {
            return;
        }
        postorder(node.nodeKiri);
        postorder(node.nodeKanan);
        System.out.printf("%d ", node.data);
    }

    //CODINGAN DELETE
    public boolean delete(int data) {
        nodePesananKue current = root;
        nodePesananKue parent = root;
        boolean isLeftChild = true;
        while (current.data != data) {
            parent = current;
            if (data < current.data) {
                isLeftChild = true;
                current = current.nodeKiri;
            } else {
                isLeftChild = false;
                current = current.nodeKanan;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.nodeKiri == null && current.nodeKanan == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                isLeftChild = false;
                current = current.nodeKanan;
            } else {
                parent.nodeKanan = null;
            }
        } else if (current.nodeKanan == null) {
            if (current == root) {
                root = current.nodeKiri;
            } else if (isLeftChild) {
                parent.nodeKiri = current.nodeKanan;
            } else {
                parent.nodeKanan = current.nodeKanan;
            }
        } else if (current.nodeKiri == null) {
            if (current == root) {
                root = current.nodeKanan;
            } else if (isLeftChild) {
                parent.nodeKiri = current.nodeKanan;
            } else {
                parent.nodeKanan = current.nodeKanan;
            }
        } else {
            nodePesananKue successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.nodeKiri = successor;
            } else {
                parent.nodeKanan = successor;
            }
            successor.nodeKiri = current.nodeKiri;
        }
        return true;

    }
    private nodePesananKue getSuccessor (nodePesananKue delNode){
        nodePesananKue sucessorParent = delNode;
        nodePesananKue successor = delNode;
        nodePesananKue current = delNode.nodeKanan;
        while (current != null){
            sucessorParent = successor;
            successor = current;
            current = current.nodeKiri;
        }
        if (successor != delNode.nodeKanan){
            sucessorParent.nodeKiri = successor.nodeKanan;
            successor.nodeKanan = delNode.nodeKanan;
        }
        return successor;
    }


    //TEST
    public static void main(String[] args) throws IOException {
        treePesananKue Tree = new treePesananKue();
        Scanner sc = new Scanner(System.in);

        String tanyafitur = "";
        int menu = 0;
        System.out.println();

        System.out.println("Apakah anda ingin menggunakan program ? (Y/N)");
        tanyafitur = sc.nextLine();
        while (tanyafitur.equalsIgnoreCase("Y")) {

            //FITUR MENGINPUTKAN DATA YAITU ID KUE , NAMA KUE DAN HARGA KUE
            System.out.println("");
            System.out.println("----------------------------------------------------");
            System.out.println("------------------Fitur Input-----------------------");
            System.out.println("Berapa data pesanan kue yang akan di input? : ");
            int totaldata = sc.nextInt();
            int data[] = new int[totaldata];



            for (int i = 0; i < data.length; i++) {
                System.out.print("Masukkan id kue ke " + (i+1) + " : ");
                data[i] = sc.nextInt();
                Tree.sisipdtNode(data[i]);
                System.out.print("Masukkan nama kue: ");
                nama = sc.next();
                System.out.print("Masukkan harga kue : ");
                harga = sc.nextInt();


            }
            System.out.println("");


            //FITUR MELIHAT DATA
            System.out.println("Apakah anda ingin melihat data? (Y/N)");
            String tanyalihat = sc.next();
            if (tanyalihat.equalsIgnoreCase("y")) {
                System.out.println("-----------------------------------------------------");
                System.out.println("------------------Fitur Lihat------------------------");
                System.out.println("Data saat ini : ");
                for (int i = 0; i < data.length; i++) {
                    System.out.print("ID Kue : " + data[i] + "\t" + "Nama Kue : " + nama + "\t" + "Harga Kue : " + harga + ". ");
                    System.out.println("\t");
                }
            }
            System.out.println(" ");


            //FITUR MENGHAPUS DATA
            System.out.println("\nApakah anda ingin menghapus data? (Y/N) ");
            String tanyahapus = sc.next();
            if (tanyahapus.equalsIgnoreCase("y")) {
                System.out.println("-----------------------------------------------------");
                System.out.println("------------------Fitur Hapus------------------------");
                System.out.println("\nMasukkan nilai data yang akan dihapus\t: ");
                int datah = sc.nextInt();
                Tree.delete(datah);
            }

            // FITUR MENCARI DATA
            System.out.println("Apakah anda ingin mencari data? (Y/N)");
            String find = sc.next();
            if (find.equalsIgnoreCase("y")) {
                System.out.println("-----------------------------------------------------");
                System.out.println("------------------Fitur mencari------------------------");
                System.out.println("Masukkan ID data kue yang ingin dicari : ");
                int datah = sc.nextInt();
                Tree.find(datah);
                if (find != null) {
                    System.out.println("Ditemukan data kue dengan rincian"
                            + "\n" + "ID Kue : " + datah + "\t" + "Nama Kue : " + nama + "\t" + "Harga Kue : " + harga + ". ");
                    Tree.find(datah);
                    System.out.println("\n");
                } else {
                    System.out.println("Data kue " + data + "tidak ditemuukan");
                }

            }


            System.out.println(" ");
            System.out.println("-----------------------------------------------------");
            System.out.println("------------------Fitur Traversal Otomatis------------------------");
            System.out.println("\nPreOrder Traversal");
            Tree.preorderTraversal();
            System.out.println("\nInOrder Traversal");
            Tree.inorderTraversal();
            System.out.println("\nPostOrder Traversal");
            Tree.postorderTraversal();

            System.out.println("\n\nJumlah node pada binary tree adalah :");
            System.out.println(Tree.getJumlah());
            Tree.cekDaun();
            System.out.println("\nJumlah daun    : " + Tree.leave);
            System.out.println("Root             : " + data[0]);
            System.out.println("\nJumlah level   : " + Tree.Level());

            System.out.println("");

            System.out.println("Apakah anda ingin ke fitur lagi? (Y/N)");
            tanyafitur = sc.next();

            System.out.println("============== T E R I M A K A S I H ==============");
            System.out.println("==================Bakery Shop Systema==================");

        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
