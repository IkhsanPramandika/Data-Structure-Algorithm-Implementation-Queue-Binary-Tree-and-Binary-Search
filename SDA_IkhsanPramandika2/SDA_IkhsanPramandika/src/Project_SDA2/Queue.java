package Project_SDA2;
import java.util.Arrays;


public class Queue {
    private int maxSize;
    private String[][] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s){//sudah
        maxSize = s;
        queArray = new String[s][4];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(String kode, String nama, String jenis, String harga){//sudah
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear][0] = kode;
        queArray[rear][1] = nama;
        queArray[rear][2] = jenis;
        queArray[rear][3] = harga;
        nItems++;
    }

    public Object[] remove(){
        String kode = queArray[front][0];
        String nama = queArray[front][1];
        String jenis = queArray[front][2];
        String harga = queArray[front][3];
        if(front == maxSize){
            front=0;
        } else {
            queArray = Arrays.copyOfRange(queArray, 1, queArray.length);
        }

        String[] data = new String[4];
        data[0] = kode;
        data[1] = nama;
        data[2] = jenis;
        data[3] = harga;
        nItems--;
        return data;
    }

    public String[] peekFront(){ // sudah
        String[] data = new String[4];
        data[0] = queArray[front][0];
        data[1] = queArray[front][1];
        data[2] = queArray[front][2];
        data[3] = queArray[front][3];
        return data;
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }

    public int getnItems() {
        return nItems;
    }

    public int size(){
        return nItems;
    }

    public boolean searchKode(int kode){//sudah
        String[][] temparr = queArray;
        for (int i = 0; i < temparr.length; i++)
            for (int j = i+1; j < temparr.length; j++)
                if (Integer.parseInt(temparr[i][0]) < Integer.parseInt(temparr[j][0])) {
                    String tempid = temparr[i][0];
                    String tempNama = temparr[i][1];
                    String jenis = temparr[i][2];
                    String harga = temparr[i][3];
                    temparr[i][0] = temparr[j][0];
                    temparr[i][1] = temparr[j][1];
                    temparr[i][2] = temparr[j][2];
                    temparr[i][3] = temparr[j][3];
                    temparr[j][0] = tempid;
                    temparr[j][1] = tempNama;
                    temparr[j][2] = jenis;
                    temparr[j][3] = harga;
                }
        String hasil = binarySearch(temparr, 0, temparr.length-1, kode);
        if(hasil == null){
            System.out.println("Data tidak ditemukan!");
        }else{
            System.out.println("Data ditemukan!");
            System.out.println(hasil);
        }
        for (int i = 0; i < temparr.length; i++)
            for (int j = i+1; j < temparr.length; j++)
                if (Integer.parseInt(temparr[i][0]) > Integer.parseInt(temparr[j][0])) {
                    String tempid = temparr[i][0];
                    String tempNama = temparr[i][1];
                    String jenis = temparr[i][2];
                    String harga = temparr[i][3];
                    temparr[i][0] = temparr[j][0];
                    temparr[i][1] = temparr[j][1];
                    temparr[i][2] = temparr[j][2];
                    temparr[i][3] = temparr[j][3];
                    temparr[j][0] = tempid;
                    temparr[j][1] = tempNama;
                    temparr[j][2] = jenis;
                    temparr[j][3] = harga;
                }
        return false;
    }

    public static String binarySearch(String arr[][], int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;
            if (Integer.parseInt(arr[mid][0]) == key){
                return arr[mid][0]+" "+arr[mid][1]+" "+arr[mid][2]+" "+arr[mid][3];
            }
            if (Integer.parseInt(arr[mid][0]) < key){
                return binarySearch(arr, first, mid-1, key);
            }else{
                return binarySearch(arr, mid+1, last, key);
            }
        }
        return null;
    }
    public void tampil(){//sudah
        System.out.println("Data : ");
        for(int i = 0; i < queArray.length; i++){
            System.out.print((i+1)+". ");
            for(int j = 0; j < queArray[i].length; j++){
                System.out.print(queArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}

