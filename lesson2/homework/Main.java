package lesson2.homework;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 2/23/2017.
 */
public class Main {
    private final int LENGTH=16;
    private int[][] ints;
    private static Random random = new Random();
    public static void main(String[] args) {
        Main main = new Main();
        main.set(10);
        System.out.println(main);
        main.build();
        System.out.println(main);
    }

    public Main(int[][] ints) {
        this.ints = ints;
    }

    public Main() {
    }

    public void set(int n){
        this.ints = new int[n][LENGTH];
        for (int i = 0; i <ints.length ; i++) {
            for (int j = 0; j <LENGTH ; j++) {
                ints[i][j]=random.nextInt(10);
            }
        }
    }

    public int[][] build(){
        for (int i = 0; i <ints.length ; i++) {
            ints[i] = fixLine(ints[i]);
        }
        return ints;
    }

    private int[] fixLine(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j=0; j < i ; j++) {
                if(arr[j]==arr[i]){
                    arr[i]+=3;
                    i=-1;j=-1;
                }
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", ", ", "");
        for (int i = 0; i <ints.length ; i++) {
            for (int j = 0; j <ints[i].length ; j++) {
                sj.add(((Integer)ints[i][j]).toString());
            }
            sj.add("\n");
        }
        return sj.toString();
    }
}
