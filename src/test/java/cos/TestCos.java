package cos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by yaros on 13.04.18.
 */
public class TestCos {
    private final double DELTA = 1e-15;
    @Test
    public void bidValue(){assertEquals(0.936752127546788, Cos.cos(1000000), DELTA);
    }
    @Test
    public void testZero(){ assertEquals(1.,Cos.cos(0), Double.MIN_VALUE);}

    @Test
    public void testPd6(){
        assertEquals(Math.sqrt(3) / 2,Cos.cos(Math.PI / 6), DELTA);
    }

    @Test
    public void testPd4(){
        assertEquals(Math.sqrt(2) / 2,Cos.cos(Math.PI / 4), DELTA);
    }

    @Test
    public void testPd3(){
        assertEquals(1. / 2,Cos.cos(Math.PI / 3), DELTA);
    }

    @Test
    public void testPd2(){
        assertEquals(0.,Cos.cos(Math.PI / 2), DELTA);
    }

    @Test
    public void test5Pd6(){
        assertEquals(- Math.sqrt(3) / 2, Cos.cos(Math.PI * 5 / 6), DELTA );
    }

    @Test
    public void testP(){
        assertEquals(-1.,Cos.cos(Math.PI), DELTA);
    }

    @Test
    public void test4Pd3(){
        assertEquals(-1. / 2, Cos.cos(4* Math.PI / 3),DELTA );
    }

    @Test
    public void test3Pd2(){
        assertEquals(0.,Cos.cos(3 * Math.PI / 2), DELTA);
    }

    @Test
    public void test2Pd(){
        assertEquals(1.,Cos.cos(2 * Math.PI), DELTA);
    }

    @Test
    public void negInf(){
        assertEquals(Double.NaN, Cos.cos(-1./0), DELTA);
    }

    @Test
    public void posInf(){
        assertEquals(Double.NaN, Cos.cos(1./0), DELTA);
    }
    }
