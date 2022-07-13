package main.other.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Overview {
    public static void main(String[] args) {
        Overview overview = new Overview();
        try {
            overview.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class clazz = Person.class;
        //1.通过反射，调用构造方法创建Person类对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("tom", 12);
        Person p = (Person) obj;
        System.out.println(p);

        //2.通过反射，调用对象的指定属性
        Field age = clazz.getDeclaredField("age");
        //赋予权限，允许访问私有属性
        age.setAccessible(true);
        age.set(p,10);
        System.out.println(p);

        //3.通过反射，调用对象的指定方法
        Method show = clazz.getDeclaredMethod("show");
        //赋予权限，允许访问私有方法
        show.setAccessible(true);
        show.invoke(p);
    }

    public void test2() throws ClassNotFoundException {
        //方式1：调用运行时类的属性：.class
        Class clazz = Person.class;
        System.out.println(clazz);

        //方式2：通过运行时类的对象，调用getClass
        Person person = new Person();
        Class clazz1 = person.getClass();
        System.out.println(clazz1);

        //方式3：调用class的静态方法：forName
        Class clazz2 = Class.forName("main.other.reflection.Person");
        System.out.println(clazz2);

        //方式4：使用类加载器classloader
        ClassLoader classLoader = Overview.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("main.other.reflection.Person");
        System.out.println(clazz3);

    }
}
