package skew.heap;

/**
 * Created by yaros on 13.04.18.
 */
public class MainSkewHeap {

    public static void main(String[] Args) {

        SkewHeap sw = new SkewHeap(8);
        sw.add(2);
        sw.add(4);
        sw.add(6);
        sw.deleteMin();
        sw.deleteMin();
        sw.deleteMin();
        sw.deleteMin();
        System.out.println(SkewHeap.buffer);

    }
}
