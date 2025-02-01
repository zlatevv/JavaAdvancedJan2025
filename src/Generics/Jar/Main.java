package Generics.Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<Integer>();

        jar.add(2);
        jar.add(3);
        jar.add(4);
        System.out.println(jar.remove());
    }
}
