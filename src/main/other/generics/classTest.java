package main.other.generics;

public class classTest {
    public static void main(String[] args) {
        new person<String>();

        //person person = new person();
        //person<Object> person1 = new person();
        printArray(1);
    }
    public static <E,T> void printArray(E t){
        System.out.println(t);
    }
}

class person<E> {
    E s;



    public E getS() {
        return s;
    }
}
interface pers<T>{

}