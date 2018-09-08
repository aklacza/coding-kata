package kata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PencilTest {

    //initialize a pencil to test
    Pencil pencil = new Pencil(10, 10000, 10000, 1000);

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
    
    @Test
    public void testingPointDurabilityWithSpaces(){
        String inputString = "This string has spaces";
        pencil.write(inputString);
        
        assertEquals(9980, pencil.getPointDurability());
        
    }
    
    @Test
    public void testingPointDurabilityWithSpacesAndSymbols(){
        String inputString = "This string has spaces and symbols!!";
        pencil.write(inputString);
        
        assertEquals(9968, pencil.getPointDurability());
        
    }
    

    @Test
    public void testingWritingMultipleStrings(){
        String inputString1 =  "The swallows fly";
        String inputString2 = " at midnight";
        
        pencil.write(inputString1);
        pencil.write(inputString2);
        
        assertEquals("The swallows fly at midnight", pencil.getStringWritten());
        
    }
    
    @Test
    public void testingStopWritingWhenPointDurabilityIsZero(){
        pencil.setPointDurability(10);
        String inputString = "The cicadas";
        pencil.write(inputString);
        
        assertEquals("The cicada ", pencil.getStringWritten());
    }
    
    @Test
    public void testingStopWritingWhenPointDurabilityIsZeroButStillWriteSpaces(){
        pencil.setPointDurability(10);
        String inputString = "The cicadas sing at night";
        pencil.write(inputString);
        
        assertEquals("The cicada               ", pencil.getStringWritten());
    }
    
    @Test
    public void testingWritingThenSharpeningThePencil(){
        pencil.write("The sky is a wonderful shade of blue!");
        pencil.sharpen();
        assertEquals(10000, pencil.getPointDurability());
    }

}
