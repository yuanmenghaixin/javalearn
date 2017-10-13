package thread.lock.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Compare-And-Swap
 * Created by Peng.lv on 2017/8/1.
 */
public class UnsafeMain {
    private int flag = 100;

    private static long offset;

    private static Unsafe unsafe = null;

    static{

        try{

            unsafe= getUnsafeInstance();

            offset= unsafe.objectFieldOffset(UnsafeMain.class

                    .getDeclaredField("flag"));

        }catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws Exception {

        int expect = 100;

        int update = 101;

        UnsafeMain unsafeTest = new UnsafeMain();

        System.out.println("unsafeTest对象的flag字段的地址偏移量为："+offset);

        unsafeTest.doSwap(offset,expect, update);

        System.out.println("CAS操作后的flag值为：" +unsafeTest.getFlag());

    }

    private boolean doSwap(long offset, int expect, int update) {

        return unsafe.compareAndSwapInt(this, offset, expect, update);

    }

    public int getFlag() {

        return flag;

    }

    private static Unsafe getUnsafeInstance() throws SecurityException,

            NoSuchFieldException,IllegalArgumentException,

            IllegalAccessException{

        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");

        theUnsafeInstance.setAccessible(true);

        return(Unsafe) theUnsafeInstance.get(Unsafe.class);

    }
}
