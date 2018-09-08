//defines a pencil object with three parameters
//Parameters: length (how many times it may be sharpened)
//pointDurability (measure of how much the point can write)
//eraserDurability (how many characters the eraser can erase)
package kata;

public class Pencil {

    public int length;
    public int pointDurability;
    public int eraserDurability;
    public String stringWritten = "";

    public Pencil(int length, int pointDurability, int eraserDurability) {
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

    public String write(String text) {

        //iterates through string to count number of capital letters
        //and lower case letters
        int countUpperCase = 0;
        int countLowerCase = 0;
        int countSymbols = 0;

        for (int x = 0; x < text.length(); x++) {
            //first check to see if the character is a space
            //then check to see if it's a capital
            //if it's not a capital, it could be a number or a symbol, which also
            //decrease one from pointDurability
            //if pointDurability allows 
            if (!Character.isSpaceChar(text.charAt(x))) {
                if (Character.isUpperCase(text.charAt(x))) {
                    if (this.pointDurability > 1) {
                        this.stringWritten += text.charAt(x);
                        this.pointDurability -= 2;
                    }
                } else if (this.pointDurability > 0) {
                    countLowerCase++;
                    this.stringWritten += text.charAt(x);
                    this.pointDurability -= 1;
                }

            }else if(this.pointDurability > 0){
                this.stringWritten += text.charAt(x);
            }
        }

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

    public String getStringWritten() {
        return stringWritten;
    }

    public void setStringWritten(String stringWritten) {
        this.stringWritten = stringWritten;
    }

}
