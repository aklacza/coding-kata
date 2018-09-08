package kata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PencilTest {

    //initialize a pencil to test
    Pencil pencil = new Pencil(10, 10000, 1000);

    public PencilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testingPencilToString() {
        //expected result
        String expectedResultString = "Pencil, length: 10, point durability: 10000, eraser durability: 1000";

        //testing it
        assertEquals(expectedResultString, pencil.toString());

    }

    @Test
    public void testingWriting() {
        String inputString = "The quick brown fox";
        
        assertEquals(inputString, pencil.write(inputString));
    }
    
    @Test
    public void testingPointDurabilityDecreaseWhenWriting(){
        String inputString = "this_string_is_33_characters_long";
        pencil.write(inputString);
        
        assertEquals(9967, pencil.getPointDurability());
        
    }
    
    @Test
    public void testingPointDurabilityDecreaseWhenWritingCapitalAndLowerCase(){
        String inputString = "This";
        pencil.write(inputString);
        
        assertEquals(9995, pencil.getPointDurability());
        
    }

}
