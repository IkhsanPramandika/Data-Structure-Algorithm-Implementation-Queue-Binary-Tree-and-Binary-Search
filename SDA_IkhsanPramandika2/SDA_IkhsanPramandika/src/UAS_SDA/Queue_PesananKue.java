package UAS_SDA;


import java.util.Scanner;

public class Queue_PesananKue {
    int id, hargakue;
    String namakue, topping;
    Queue_PesananKue next;

    static Scanner input = new Scanner(System.in);

    public void input() {
        System.out.println("Masukkan ID Kue         : ");
        id = input.nextInt();
        System.out.println("Masukkan Harga Kue      : ");
        hargakue = input.nextInt();
        System.out.println("Masukkan Nama Kue       : ");
        namakue = input.next();
        System.out.println("Masukkan Topping Kue    : ");
        topping = input.next();
        next = null;
    }

    public void output() {
        System.out.println(id + "\t" + hargakue + "\t" + namakue + "\t" + topping + "\t");
    }

    public static void main(String[] args) {
       int menu = 0;
        Queue que = new Queue();
        String tanyafitur = " ";
        System.out.println("============ Selamat Datang Admin ============");
        System.out.println("============== Toko Kue Systema ==============");

        System.out.println("Apakah anda ingin memilih fitur ? (Ya/Tidak)");
        tanyafitur = input.nextLine();
        while ((tanyafitur.equalsIgnoreCase("Y"))) {
            System.out.println("Silahkan pilih fitur yang ingin digunakan : "
                    + "\n1. Menambah Data"
                    + "\n2. Mengurangi Data"
                    + "\n3. Menampilkan data"
                    + "\n4. Melihat Data Paling Awal"
                    + "\n5. Melihat Data Paling Akhir"
                    + "\n6. Keluar");
            System.out.println("-----------------");
            System.out.println("Masukkan fitur pilihan : ");
            menu = input.nextInt();
            if (menu == 1) {
                que.enque();
            } else if (menu == 2) {
                que.deque();
            } else if (menu == 3) {
                que.view();
            } else if (menu == 4) {
                que.viewFront();
            } else if (menu == 5) {
                que.viewRear();
            } else if (menu == 6) {
                System.out.println("- Keluar -");
            } else if (menu == 7) {
                que.sortingDesc();
            } else {
                System.out.println("Maaf menu yang anda pilih tidak tersedia");
            }
            System.out.println("");
            System.out.println("Apakah anda ingin memilih fitur lagi ? (Y/N)");
            tanyafitur = input.next();
        }
        System.out.println("============ TERIMA KASIH ============");
        System.out.println("============ Toko Kue Systema ============");
    }

    static class Queue {
        Queue_PesananKue front, rear;

        public Queue() {
            front = null;
            rear = null;

        }

        public void enque() {
            Queue_PesananKue baru = new Queue_PesananKue();
            baru.input();
            if (front == null) {
                front = baru;
            } else {
                rear.next = baru;
            }
            rear = baru;
        }


        public void deque() {
            if (front == null) {
                System.out.println("- Kosong -");
            } else {
                System.out.println("Kue " + front.namakue + " telah dihapus");
                front = front.next;
            }
        }

        public void view() {
            if (front == null) {
                System.out.println("- Tidak ada data pesanan -");
            } else {
                System.out.println("ID \t Harga Kue \t Nama Kue \t Topping Kue \t");
                for (Queue_PesananKue a = front; a != null; a = a.next) {
                    a.output();
                }
            }
        }

        public void viewFront() {
            if (front == null) {
                System.out.println("- Tidak ada data pesanan -");
            } else {
                System.out.println("Pesanan kue paling awal adalah " + front.namakue);
            }
        }

        public void viewRear() {
            if (rear == null) {
                System.out.println("- Tidak ada data pesanan -");
            } else {
                System.out.println("Pesanan kue paling akhir adalah " + rear.namakue);
            }
        }

        public void sortingDesc(){
            Queue_PesananKue sorting = new Queue_PesananKue();
            System.out.println(sorting.namakue);
        }
    }

}


