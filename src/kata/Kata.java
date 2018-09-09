package kata;
//@author Andy
//Pencil Durability Kata: https://github.com/PillarTechnology/kata-pencil-durability
//Created 9/8/18

public class Kata {

    public static void main(String[] args) {
        System.out.println("Hello world!!");
        Pencil pencil = new Pencil(10, 10000, 10000, 1000);
        String pencilToString = pencil.toString();
        System.out.println(pencilToString);
        pencil.setPointDurability(100);
        pencil.write("The cicadas sing");
        System.out.println(pencil.getStringWritten());
        pencil.erase("sing");
        //pencil.setEraserDurability(1);
        System.out.println(pencil.getStringWritten());
        System.out.println("durability main: " + pencil.eraserDurability);
    }

}
