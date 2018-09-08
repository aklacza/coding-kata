//defines a pencil object with three parameters
//Parameters: length (how many times it may be sharpened)
//pointDurability (measure of how much the point can write)
//eraserDurability (how many characters the eraser can erase)
package kata;

public class Pencil {

    public int length;
    public int pointDurability;
    public int maxPointDurability;
    public int eraserDurability;
    public String stringWritten = "";

    public Pencil(int length, int pointDurability, int maxPointDurability, int eraserDurability) {
        this.length = length;
        this.pointDurability = pointDurability;
        this.maxPointDurability = maxPointDurability;
        this.eraserDurability = eraserDurability;
    }

    @Override
    public String toString() {
        return "Pencil, " + "length: " + length
                + ", point durability: " + pointDurability
                + ", eraser durability: " + eraserDurability;
    }

    public String write(String text) {

        //iterate through text string one character at a time
        for (int x = 0; x < text.length(); x++) {

            //check for space
            if (!Character.isSpaceChar(text.charAt(x))) {
                //check for capital, then pointDurability 
                if (Character.isUpperCase(text.charAt(x))) {
                    if (this.pointDurability > 1) {
                        //write character and decrement pointDurability
                        this.stringWritten += text.charAt(x);
                        this.pointDurability -= 2;
                    }
                    //if pointDurability has reached zero, still write a space
                } else if (this.pointDurability > 0) {
                    //write character and decrement pointDurability
                    this.stringWritten += text.charAt(x);
                    this.pointDurability -= 1;
                } else if (this.pointDurability == 0) {
                    this.stringWritten += " ";
                }

            } else {
                this.stringWritten += text.charAt(x);
            }
        }

        return text;
    }

    public void sharpen() {
        if (this.length > 0) {
            this.length--;
            this.setPointDurability(maxPointDurability);
        }

    }

    public void erase(String stringToErase) {
        int sizeOfErasure = stringToErase.length();
        String stringOfSpaces = "";
        for (int x = 0; x < sizeOfErasure; x++) {
            stringOfSpaces = stringOfSpaces.concat(" ");
        }

        if (this.stringWritten.contains(stringToErase)) {

            this.setStringWritten(stringWritten.replaceAll(stringToErase, stringOfSpaces));
        }
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

    public int getMaxPointDurability() {
        return maxPointDurability;
    }

    public void setMaxPointDurability(int maxPointDurability) {
        this.maxPointDurability = maxPointDurability;
    }

}
