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
    public boolean eraserUsed;

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
                    //if pointDurability has reached zero, still make a space
                } else if (this.pointDurability > 0) {
                    //write character and decrement pointDurability
                    this.stringWritten += text.charAt(x);
                    this.pointDurability -= 1;
                } else if (this.pointDurability == 0) {
                    this.stringWritten += " ";
                }

            } else { //adds a space 
                this.stringWritten += text.charAt(x);
            }
        }

        return text;
    }

    //returns pointDurability to maximum and decreases length, if length is greater than zero
    public void sharpen() {
        if (this.length > 0) {
            this.length--;
            this.setPointDurability(maxPointDurability);
        }

    }

    //erases characters from end of stringWritten assuming there is enough eraser durability
    public void erase(String stringToErase) {

        int stringToEraseLength = stringToErase.length();
        StringBuilder newStringWritten = new StringBuilder(this.stringWritten);

        //tries to erase while there are still instances of the word to erase
        while (newStringWritten.toString().contains(stringToErase)) {

            //exits loop if eraserDurability is exhausted
            if (eraserDurability == 0) {
                break;
            }
            //finds the right most instance of the word
            //finds start of last occurence of the string, then adds the length of the string to erase
            //and subtracts one to account for the zero index of StringBuilder object
            int indexOfEraseStart = this.stringWritten.lastIndexOf(stringToErase) + stringToEraseLength - 1;
            //erases the word from right to left
            for (int x = indexOfEraseStart; x > (indexOfEraseStart - stringToEraseLength); x--) {
                //checks eraserDurability and erases if it is not zero
                //also decrements the durability
                //sets eraserUsed boolean as true in order to allow edits
                if (this.eraserDurability > 0) {
                    newStringWritten.setCharAt(x, ' ');
                    this.setStringWritten(newStringWritten.toString());
                    this.setEraserDurability(this.getEraserDurability() - 1);
                    this.setEraserUsed(true);
                    
                }
            }
        }
    }

    //allows editing of writing if there has been an erase previously performed
    //input is new string of text and the position to begin at; index begins at zero
    public void edit(String stringToInsert, int position) {
        if (this.isEraserUsed()) {

            //creates new objects to better manipulate text
            StringBuilder newStringWritten = new StringBuilder(this.stringWritten);
            StringBuilder stringToInsertBuilder = new StringBuilder(stringToInsert);

            //if StringBuilder is not long enough for new text it expands
            if (newStringWritten.length() < (position + stringToInsert.length())) {
                newStringWritten.setLength(position + stringToInsert.length());
            }

            //iterates through both StringBuilders to insert edit
            for (int x = position; x < (position + stringToInsert.length()); x++) {

                //checks if character is a space or null
                if (newStringWritten.charAt(x) == ' ' || newStringWritten.charAt(x) == '\0') {

                    //replaces a blank with a blank
                    if (stringToInsertBuilder.charAt(x - position) == ' ') {
                        newStringWritten.setCharAt(x, stringToInsertBuilder.charAt(x - position));
                        this.setStringWritten(newStringWritten.toString());

                        //checks point durability to write a capital letter                    
                        //writes upper case, updates stringWritten String and decreases point durability by 2
                    } else if (this.getPointDurability() > 1 && Character.isUpperCase(stringToInsertBuilder.charAt(x - position))) {
                        newStringWritten.setCharAt(x, stringToInsertBuilder.charAt(x - position));
                        this.setStringWritten(newStringWritten.toString());
                        this.pointDurability -= 2;

                        //checks point durability first, then
                        //writes lower case and symbols , decreases point durability by 1
                    } else if (this.getPointDurability() > 0) {
                        newStringWritten.setCharAt(x, stringToInsertBuilder.charAt(x - position));
                        this.setStringWritten(newStringWritten.toString());
                        this.pointDurability--;
                    }

                    //do nothing if the character is the same
                } else if (newStringWritten.charAt(x) == stringToInsertBuilder.charAt(x - position)) {
                    //do nothing
                    //else (existing character is not a space or the same character)
                } else { //writes a @ as symbol for writing on top of existing letter
                    //checks durability, writes upper case, decreases durability
                    if (this.getPointDurability() > 1 && Character.isUpperCase(stringToInsertBuilder.charAt(x - position))) {
                        newStringWritten.setCharAt(x, '@');
                        this.setStringWritten(newStringWritten.toString());
                        this.pointDurability -= 2;

                        //checks durability, replaces lower case, decreases point durability by 1
                    } else if (this.getPointDurability() > 0 && Character.isLowerCase(stringToInsertBuilder.charAt(x - position))) {
                        newStringWritten.setCharAt(x, '@');
                        this.setStringWritten(newStringWritten.toString());
                        this.pointDurability--;
                    }
                }
            }
        }
    }

    //getters and setters
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

    public boolean isEraserUsed() {
        return eraserUsed;
    }

    public void setEraserUsed(boolean eraserUsed) {
        this.eraserUsed = eraserUsed;
    }

}
