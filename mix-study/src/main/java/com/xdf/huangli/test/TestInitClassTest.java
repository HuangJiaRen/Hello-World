package com.xdf.huangli.test;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-10 16:18
 */
public class TestInitClassTest {
    public static void main(String[] args) {
        //获取一个类的class对象的三种方法
        try {
            //1
            Class<Student> aClass = (Class<Student>) Class.forName("com.xdf.huangli.test.Student");
            //2
            Class<Student> studentClass = Student.class;
//            Student student = studentClass.newInstance();
            //3
            Student student1 = new Student();
            Class<? extends Student> aClass1 = student1.getClass();
//            Student student = aClass1.newInstance();

            Student student = aClass.newInstance();
            System.out.println(student.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
