package kata;
//@author Andy
//Pencil Durability Kata: https://github.com/PillarTechnology/kata-pencil-durability
//Created 9/8/18

public class Kata {

    public static void main(String[] args) {
        System.out.println("Hello world!!");
        Pencil pencil = new Pencil(10, 10000, 1000);
        String pencilToString = pencil.toString();
        System.out.println(pencilToString);
    }

}
