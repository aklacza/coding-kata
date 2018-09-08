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
    
    public String write(String text){

        //iterates through string to count number of capital letters
        //and lower case letters
        int countUpperCase = 0;
        int countLowerCase = 0;
        
        for(int x = 0; x<text.length(); x++){
            if(Character.isUpperCase(text.charAt(x))){
                countUpperCase++;
            }
            if(Character.isLowerCase(text.charAt(x))){
                countLowerCase++;
            }
        }
        this.pointDurability -= ((countUpperCase *2 ) + (countLowerCase));

        
        return text;
    }

    public int getLength() {
        return length;
    }

    public int getPointDurability() {
        return pointDurability;
    }

    public int getEraserDurability() {
        return eraserDurability;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPointDurability(int pointDurability) {
        this.pointDurability = pointDurability;
    }

    public void setEraserDurability(int eraserDurability) {
        this.eraserDurability = eraserDurability;
    }
    
    
}


