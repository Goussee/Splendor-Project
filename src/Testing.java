import java.util.Scanner;

public class Testing{
    public static void main(String[] args) throws Exception {
        System.out.println("hdfeifgkajefbkhsfbe");
        String x = "10w01111 10w01211 10w00221 10w30011 10w02001 10w00022 10w00030 11w00400 10r10111 10r20111 10r20102 10r11003 10r00120 10r22000 10r30000 11r40000 10g11011 10g11012 10g02012 10g10130 10g20010 10g02020 10g03000 11g00004 10b11101 10b12101 10b12200 10b01310 10b10002 10b00202 10b00003 11b04000 10k11110 10k11120 10k21020 10k30101 10k01200 10k20200 10k00300 11k00040 21w02302 21w23030 22w04102 22w05003 22w05000 23w60000 21r22003 21r02033 22r10240 22r30005 22r00005 23r06000 21g33200 21g20032 22g40021 22g00350 22g00500 23g00600 21b03220 21b00323 22b50030 22b21004 22b00050 23b00060 21k30220 21k30302 22k02410 22k03500 22k50000 23k00006 33w05333 34w00007 34w33006 35w30007 33r30353 34r00700 34r03630 35r03700 33g53033 34g00070 34g30360 35g00370 33b33305 34b70000 34b60033 35b70030 33k03530 34k07000 34k06303 35k07003";       Scanner sc = new Scanner(x);
        while(sc.hasNext()){
            Card c = new Card(sc.next());
            if(c.getImage()== null){
                System.out.println(c + "not working");
            }
        }
    }
}