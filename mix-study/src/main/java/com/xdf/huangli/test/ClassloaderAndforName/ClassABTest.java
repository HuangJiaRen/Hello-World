package com.xdf.huangli.test.ClassloaderAndforName;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-09-22 18:01
 */
public class ClassABTest {
//    public static void main(String[] args) {
//        String claNameA = "com.xdf.huangli.test.ClassloaderAndforName.ClassA";
//        String claNameB = "com.xdf.huangli.test.ClassloaderAndforName.ClassB";
//        ClassLoader loader = ClassLoader.getSystemClassLoader();
//        try {
//            System.out.println("Class.forName()加载ClassB");
//            Class<?> cla1 = Class.forName(claNameB);
//            System.out.println("ClassLoader对象loadClass()加载ClassA");
//            Class<?> cla2 = loader.loadClass(claNameA);
//            System.out.println("调用newInstance()");
//            cla2.newInstance();
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        String claNameA = "com.xdf.huangli.test.ClassloaderAndforName.ClassA";
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            System.out.println("Class.forName(name,initialize,loader)加载ClassA");
            Class.forName(claNameA, true, loader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
