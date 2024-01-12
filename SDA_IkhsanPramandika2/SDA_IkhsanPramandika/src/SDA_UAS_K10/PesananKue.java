package SDA_UAS_K10;


import java.util.Scanner;

    public class PesananKue {


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("================================================================");
            System.out.println("\t\t\t\t\tSELAMAT DATANG DI");
            System.out.println("\t\t\t\t\t TOKO KUE SYSTEMA");
            System.out.println("================================================================");
            System.out.print("Masukkan jumlah kue yang ingin dipesan : ");
            int n = Integer.parseInt(input.nextLine());
            Queue que = new Queue(n);
            Tree tr = new Tree();
            boolean ulang = true;
            int i = 1;
            while (ulang) {
                System.out.println("\nSilahkan pilih fitur yang ingin digunakan : "
                        + "\n1. Menambah Data"
                        + "\n2. Mengurangi Data"
                        + "\n3. Menampilkan Data"
                        + "\n4. Mencari Data Kue"
                        + "\n5. Keluar");

                System.out.println("-----------------");
                System.out.print("Masukkan fitur pilihan : ");
                int menu = Integer.parseInt(input.nextLine());

                if (menu == 1) {
                    if (i <= n) {
                        System.out.println("================================================================");
                        System.out.println("\t\t\t\t\tSELAMAT DATANG DI");
                        System.out.println("\t\t\t\t\t TOKO KUE SYSTEMA");
                        System.out.println("================================================================");
                        System.out.println("Silahkan input data kue");
                        System.out.print("Masukkan ID Kue         : ");
                        String id = input.nextLine();
                        System.out.print("Masukkan Nama Kue       : ");
                        String namakue = input.nextLine();
                        System.out.print("Masukkan Topping Kue    : ");
                        String topping = input.nextLine();
                        System.out.print("Masukkan Harga Kue      : ");
                        String hargakue = input.nextLine();

                        que.enque(id, namakue, topping, hargakue);
                        tr.insert(id, namakue, topping, hargakue);
                        System.out.println("Data kue berhasill dimasukan. Sisa ruang untuk kue bersisa : " + (n - i));
                        i++;
                    } else {
                        System.out.println("Data kue tidak bisa dimasukkan karena data sudah penuh");
                    }
                } else if (menu == 2) {

                    if (que.isEmpty()) {
                        System.out.println("Anda tidak bisa menghapus data kue karena data tidak ada");
                    } else {
                        Object[] arr = que.deque();
                        System.out.println("Data berhasil dihapus");
                        for (int j = 0; j < arr.length; j++) {
                            System.out.println(arr[j] + " ");
                        }
                        i--;
                        tr.delete(Integer.valueOf((String)arr[0]));
                    }
                } else if (menu == 3) {
                    que.view();
                    if(que.isEmpty()){
                        System.out.println("Data Kosong, silahkan inputkan data terlebih dahulu");
                        System.out.println("\t");
                    }else {
                        System.out.println("Silahkan pilih fitur : ");
                        System.out.println("\n1. PreOrder\n" +
                                "2. InOrder\n" +
                                "3. PostOrder\n" +
                                "4. Root \n" +
                                "5. Leaf\n" +
                                "Pilih : ");
                        int p = Integer.parseInt(input.nextLine());
                        if (p == 1) {
                            System.out.println("Menampilkan fitur Preorder");
                            tr.PreOrder();
                        } else if (p == 2) {
                            System.out.println("Menampilkan fitur  InOrder");
                            tr.InOrder();
                        } else if (p == 3) {
                            System.out.println("Menampilkan fitur  PostOrder");
                            tr.PostOrder();
                        }else if (p == 4) {
                            System.out.println("Menampilkan fitur  Root");
                            tr.printRootNodes();
                    } else if (p == 5) {
                        System.out.println("Menampilkan fitur  Leaf");
                        tr.printLeafNodes();
                    }}
                } else if (menu == 4) {
                    System.out.print("Masukkan ID kue yang ingin dicari : ");
                    String id = input.nextLine();
                    que.cariKue(Integer.parseInt(id));
                } else {
                    System.out.println("================================================================");
                    System.out.println("\t\t\t\tTERIMA KASIH TELAH MEMESAN KUE DI");
                    System.out.println("\t\t\t\t\t TOKO KUE SYSTEMA");
                    System.out.println("================================================================");
                    ulang = false;
                }
                System.out.println("");
            }


    }
        }







