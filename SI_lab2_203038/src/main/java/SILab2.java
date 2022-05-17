
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SILab2 {

    public static List<String> function(List<String> list) {    //1
        if (list.size() <= 0) { //2
            throw new IllegalArgumentException("List length should be greater than 0"); //3
        }
        int n = list.size();    //4
        int rootOfN = (int) Math.sqrt(n);   //4
        if (rootOfN * rootOfN  != n) {  //5
            throw new IllegalArgumentException("List length should be a perfect square"); //6
        }
        List<String> numMines = new ArrayList<>(); //7
        for (int i = 0; i < n; i++) {   //8
            if (!list.get(i).equals("#")) {     //9
                int num = 0; //10
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) {   //11
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){    //12
                        num += 2;   //13
                    }
                    else {  //14
                        num  += 1;
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){     //15
                    num++; //16
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){ //17
                    num++; //18
                }
                numMines.add(String.valueOf(num)); //19
            }
            else { // 20
                numMines.add(list.get(i));
            }
        }   //21
        return numMines; //22
    } //23


}

