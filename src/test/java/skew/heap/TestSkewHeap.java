package skew.heap;

/**
 * Created by yaros on 13.04.18.
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class TestSkewHeap {

    @Test
    public void addTest(){
        SkewHeap expectedHeap = new SkewHeap(4, new SkewHeap(5), new SkewHeap(8));
        SkewHeap actualHeap = new SkewHeap(4);
        actualHeap.add(8);
        actualHeap.add(5);
        assertEquals(expectedHeap, actualHeap);
    }

    @Test
    public  void deleteTest(){
        SkewHeap expectedHeap = new SkewHeap(5, new SkewHeap(8), null);
        SkewHeap deletedHeap = new SkewHeap(4, new SkewHeap(5), new SkewHeap(8));
        deletedHeap.deleteMin();
        assertEquals(expectedHeap, deletedHeap);
    }

    @Test
    public void mergeWithOutSwap(){
        SkewHeap sw = new SkewHeap(1);
        sw.merge(new SkewHeap(2));
        assertTrue(sw.left.root == 2 && sw.root == 1);
    }

    @Test
    public void mergeWithSwap(){
        SkewHeap sw = new SkewHeap(2);
        sw.merge(new SkewHeap(1));
        assertTrue(sw.left.root == 2 && sw.root == 1);
    }


    @Test
    public void swapChildrenTest(){
        SkewHeap actualHeap = new SkewHeap(4, new SkewHeap(5), new SkewHeap(8));
        actualHeap.swapChildrens();
        assertEquals(8, actualHeap.left.root);
        assertEquals(5, actualHeap.right.root);

    }

    @Test
    public void swapTopRootTest(){
        SkewHeap expectedHeap = new SkewHeap(4, new SkewHeap(5), new SkewHeap(8));
        SkewHeap swapedHeap = new SkewHeap(1, new SkewHeap(2), null);
        SkewHeap swapedWithHeap = swapedHeap.swapTopRoot(expectedHeap);
        assertEquals(expectedHeap, swapedHeap);
        assertEquals(new SkewHeap(1, new SkewHeap(2), null), swapedWithHeap);
    }

    @Test
    public void equalsTest(){
        SkewHeap sw1 = new SkewHeap(4, new SkewHeap(6), new SkewHeap(8));
        SkewHeap sw2 = new SkewHeap(4, new SkewHeap(6), new SkewHeap(8));
        SkewHeap sw3 = new SkewHeap(4);
        sw3.add(8);
        sw3.add(6);
        assertTrue(sw1.equals(sw2));
        assertTrue(sw1.equals(sw3));
    }
    @Test
    public void noEqualsTest(){
        SkewHeap sw1 = new SkewHeap(4, new SkewHeap(6), new SkewHeap(8));
        SkewHeap sw2 = new SkewHeap(4, new SkewHeap(4), new SkewHeap(8));
        SkewHeap sw3 = new SkewHeap(4);
        sw3.add(8);
        sw3.add(6);
        sw3.add(30);
        assertFalse(sw1.equals(sw2));
        assertFalse(sw1.equals(sw3));
    }
    @Test
    public void statesTest(){
        SkewHeap.buffer ="";
        SkewHeap sw = new SkewHeap(8);
        sw.add(2);
        sw.add(4);
        sw.add(6);
        sw.deleteMin();
        sw.deleteMin();
        sw.deleteMin();
        sw.deleteMin();
        assertEquals("Merge 8 with 2: 8 \n" +
                "Swap 2 with 8: 2 \n" +
                "End of merge: 2 8 \n" +
                "Swap childrens of 2: 8 2 \n" +
                "Merge 22 with 4: 8 2 \n" +
                "End of merge: 8 2 4 \n" +
                "Swap childrens of 2: 4 2 8 \n" +
                "Merge 2 with 6: 4 2 8 \n" +
                "Right of 2 is not empty: 4 2 8 \n" +
                "Merge 8 with 6: 8 \n" +
                "Swap 6 with 8: 6 \n" +
                "End of merge: 6 8 \n" +
                "Swap childrens of 6: 8 6 \n" +
                "Swap childrens of 2: 8 6 2 4 \n" +
                "Delete min element: 8 6 2 4 \n" +
                "Right of 2 is less: 8 6 2 4 \n" +
                "Merge 4 with 6: 4 \n" +
                "End of merge: 4 8 6 \n" +
                "Swap childrens of 4: 8 6 4 \n" +
                "Delete min element: 8 6 4 \n" +
                "Right of previous root is empty, 6 is new root: 8 6 \n" +
                "Delete min element: 8 6 \n" +
                "Right of previous root is empty, 8 is new root: 8 \n" +
                "Delete min element: 8 \n" +
                "Heap is empty now: 0 \n", SkewHeap.buffer);
    }
}
