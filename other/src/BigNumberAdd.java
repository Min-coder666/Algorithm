import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigNumberAdd {



    /*
    *  123456 7891011
    *   78910
    * */
    public static String bigNumberAdd(String n1, String n2){
        int len1 = n1.length();
        int len2 = n2.length();
        int p1 = len1-1;
        int p2 = len2-1;
        int k = 0;
        List<Character> retList = new ArrayList<>();
        while(p1>=0&&p2>=0){
            int num1 = n1.charAt(p1--) - '0';
            int num2 = n2.charAt(p2--) - '0';
            int sum = num1+num2+k;
            k = sum/10;
            retList.add((char)(sum%10+'0'));
        }

        while (p1>=0){
            retList.add((char)(n1.charAt(p1--)+k));
            k=0;
        }
        while (p2>=0){
            retList.add((char)(n2.charAt(p2--)+k));
            k=0;
        }
        Collections.reverse(retList);
        Character[] retArr = new Character[retList.size()];
        retList.toArray(retArr);
        String ret = "";
        for (Character character : retArr) {
            ret += character;
        }
        return ret;


    }


    public static void main(String[] args) {
        String ret = bigNumberAdd("123456","78910");
        System.out.println(ret);
    }
}
