package lesson1.l1_3;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
public class SClass{
    @Save
    private int st = 255;
    private Integer a = 1;
    @Save
    private Integer sb = 3;
    String c = "fieldC";
    @Save
    protected boolean sflag = true;

    @Override
    public String toString() {
        return "{" +
                "st=" + st +
                ", a=" + a +
                ", sb=" + sb +
                ", c='" + c + '\'' +
                ", sflag=" + sflag +
                '}';
    }
    void set(int st, int a, int b, String c, boolean flag){
        this.st = st;
        this.a = a;
        this.sb = b;
        this.c = c;
        this.sflag = flag;
    }
}
