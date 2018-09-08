//defines a pencil object with three parameters
//Parameters: length (how many times it may be sharpened)
//pointDurability (measure of how much the point can write)
//eraserDurability (how many characters the eraser can erase)

package kata;

public class Pencil {
    public int length;
    public int pointDurability;
    public int eraserDurability;
    
    public Pencil(int length, int pointDurability, int eraserDurability){
        this.length = length;
        this.pointDurability = pointDurability;
        this.eraserDurability = eraserDurability;
    }
    
    
    @Override
    public String toString() {
        return "Pencil, " + "length: " + length 
                + ", point durability: " + pointDurability 
                + ", eraser durability: " + eraserDurability;
    }
}


