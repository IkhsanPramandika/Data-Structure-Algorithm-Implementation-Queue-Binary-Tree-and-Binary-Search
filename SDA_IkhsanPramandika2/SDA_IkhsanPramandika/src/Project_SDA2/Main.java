package Project_SDA2;
import java.util.Scanner;



    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Masukkan banyak data : ");
            int n = Integer.parseInt(in.nextLine());
            Queue q = new Queue(n);
            boolean ulang = true;
            int i = 1;
            System.out.println("SELAMAT DATANG!");
            while(ulang){
                System.out.print("\n\n1. Masukkan data\n" +
                        "2. Menampilkan data\n" +
                        "3. Mencari data\n" +
                        "4. Hapus data\n" +
                        "5. Keluar\n\n" +
                        "Masukkan pilihan : ");
                int pil = Integer.parseInt(in.nextLine());
                if(pil == 1){
                    if(i<=n){
                        System.out.print("Masukkan kode : ");
                        String kode = in.nextLine();
                        System.out.print("Masukkan nama : ");
                        String nama = in.nextLine();
                        System.out.print("Masukkan jenis : ");
                        String jenis = in.nextLine();
                        System.out.print("Masukkan harga : ");
                        String harga = in.nextLine();
                        q.insert(kode, nama, jenis, harga);
                        System.out.println("Data berhasil di masukkan! Sisa ruang untuk queue bersisa : "+(n-i));
                        i++;
                    }else{
                        System.out.println("Anda tidak bisa memasukkan data lagi karena Queue sudah penuh!");
                    }
                }else if(pil == 2){
                    q.tampil();
                }else if(pil == 3){
                    System.out.print("Masukkan ID yang ingin dicari : ");
                    String id = in.nextLine();
                    q.searchKode(Integer.parseInt(id));
                }else if(pil == 4){
                    if(q.isEmpty()){
                        System.out.println("Anda tidak bisa menghapus data lagi karena Queue sudah kosong!");
                    }else{
                        Object[] arr = q.remove();
                        System.out.println("Data berhasil dihapus!\nData yang dihapus adalah sebagai berikut : \n");
                        for(int j = 0; j < arr.length; j++){
                            System.out.print(arr[j]+" ");
                        }
                        i--;
                    }
                }else{
                    System.out.println("Terima Kasih! Selamat berjumpa kembali! :)");
                    ulang = false;
                }
            }
        }
    }

