package SDA_UAS_K10;

import UAS_SDA.Queue_PesananKue;

import java.util.Arrays;


    public class Queue {
        private int maxSize;
        private String[][] queArray;
        private int front;
        private int rear;
        private int nItems;
        int size;

        public Queue(int s) {
            maxSize = s;
            queArray = new String[s][4];
            front = 0;
            rear = -1;
            nItems = 0;
        }

        public void enque(String id, String hargakue, String namakue, String topping) {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queArray[++rear][0] = id;
            queArray[rear][1] = hargakue;
            queArray[rear][2] = namakue;
            queArray[rear][3] = topping;
            nItems++;
        }

        public Object[] deque() {
            Object id = queArray[front][0];
            Object hargakue = queArray[front][1];
            Object namakue = queArray[front][2];
            Object topping = queArray[front][3];
            if (front == maxSize) {
                front = 0;
            } else {
                queArray = Arrays.copyOfRange(queArray, 1, queArray.length);
            }
            Object[] data = new String[4];
            data[0] = id;
            data[1] = hargakue;
            data[2] = namakue;
            data[3] = topping;
            nItems--;
            return data;

        }

        public boolean isEmpty() {
            return (nItems == 0);
        }

        public boolean cariKue(int id) {
            String[][] tempArr = queArray;
            for (int i = 0; i < tempArr.length; i++)
                for (int j = i + 1; j < tempArr.length; j++)
                    if (Integer.parseInt(tempArr[i][0]) < Integer.parseInt(tempArr[j][0])) {
                        String tempid = tempArr[i][0];
                        String tempNama = tempArr[i][1];
                        String Harga = tempArr[i][2];
                        String Topping = tempArr[i][3];
                        tempArr[i][0] = tempArr[j][0];
                        tempArr[i][1] = tempArr[j][1];
                        tempArr[i][2] = tempArr[j][2];
                        tempArr[i][3] = tempArr[j][3];
                        tempArr[j][0] = tempid;
                        tempArr[j][1] = tempNama;
                        tempArr[j][2] = Harga;
                        tempArr[j][3] = Topping;
                    }
            String hasil = binarySearch(tempArr, 0, tempArr.length - 1, id);
            if (hasil == null) {
                System.out.println("Data kue tidak ditemukan");
            } else {
                System.out.println("Data kue ditemukan");
                System.out.println("No ID Nama Topping Harga\t");
                System.out.println(hasil);
            }
            for (int i = 0; i < tempArr.length; i++)
                for (int j = i + 1; j < tempArr.length; j++)
                    if (Integer.parseInt(tempArr[i][0]) > Integer.parseInt(tempArr[j][0])) {
                        String tempid = tempArr[i][0];
                        String tempNama = tempArr[i][1];
                        String Harga = tempArr[i][2];
                        String Topping = tempArr[i][3];
                        tempArr[i][0] = tempArr[j][0];
                        tempArr[i][1] = tempArr[j][1];
                        tempArr[i][2] = tempArr[j][2];
                        tempArr[i][3] = tempArr[j][3];
                        tempArr[j][0] = tempid;
                        tempArr[j][1] = tempNama;
                        tempArr[j][2] = Harga;
                        tempArr[j][3] = Topping;
                    }
            return false;
        }

        public static String binarySearch(String arr[][], int first, int last, int key) {
            if (last >= first) {
                int mid = first + (last - first) / 2;
                if (Integer.parseInt(arr[mid][0]) == key) {
                    return arr[mid][0] + " " + arr[mid][1] + " " + arr[mid][2] + " " + arr[mid][3];
                }
                if (Integer.parseInt(arr[mid][0]) < key) {
                    return binarySearch(arr, first, mid - 1, key);
                } else {
                    return binarySearch(arr, mid - 1, last, key);
                }
            }
            return null;
        }

        public void view() {
            System.out.println("Data : ");
            System.out.println("No ID Nama Topping Harga\t");
            for (int i = 0; i < queArray.length; i++) {
                System.out.print((i + 1) + ". ");
                for (int j = 0; j < queArray[i].length; j++) {
                    System.out.print(queArray[i][j] + " ");
                }
                System.out.println();
            }
        }
    }



