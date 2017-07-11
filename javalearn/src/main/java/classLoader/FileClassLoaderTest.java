package classLoader;

/**
 * Created by Peng.lv on 2017/6/28.
 */
public class FileClassLoaderTest {
    /*public static void main(String[] args) throws ClassNotFoundException {
        String rootDir="";
        FileClassLoader loader1 = new FileClassLoader(rootDir);

        System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());

        *//**
         输出结果:
         自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
         系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
         AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
         ExtClassLoader的父类加载器: null
         *//*
    }*/
        public static void main(String[] args) throws ClassNotFoundException {
            String rootDir="/Users/zejian/Downloads/Java8_Action/src/main/java/";
            //创建自定义文件类加载器
            FileClassLoader loader = new FileClassLoader(rootDir);
            try {
                //加载指定的class文件
                Class<?> object1=loader.loadClass("classLoader.DemoObj");
                System.out.println(object1.newInstance().toString());
                //输出结果:I am DemoObj
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
