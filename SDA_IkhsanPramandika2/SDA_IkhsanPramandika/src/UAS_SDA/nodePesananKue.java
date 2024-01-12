package UAS_SDA;



    import java.util.Scanner;

    public class nodePesananKue {
        int data ,harga , id;
        String nama;
        nodePesananKue nodeKiri;
        nodePesananKue nodeKanan;



        public nodePesananKue(int dt) {
            data = dt;
            nodeKiri = nodeKanan = null;
        }



        public void displayNode1() {
            System.out.println(" ( " + id + " | " + nama + " | " + harga + " ) ");
        }
        public void sisipDt(int dtSisip) {
            if (dtSisip < data) {
                if (nodeKiri == null) {
                    nodeKiri = new nodePesananKue((dtSisip));
                } else {
                    nodeKiri.sisipDt(dtSisip);
                }
            } else if (dtSisip > data) {
                if (nodeKanan == null) {
                    nodeKanan = new nodePesananKue(dtSisip);
                } else {
                    nodeKanan.sisipDt(dtSisip);
                }
            }
        }
    }

