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
    
    @Test
    public void testingLengthDecreaseWhenSharpening(){
        pencil.sharpen();
        assertEquals(9, pencil.getLength());
    }
    
    @Test
    public void testingPencilDurabilityShouldNotBeRestoredIfLengthIsZero(){
        pencil.setPointDurability(60);
        pencil.write("This pencil is short!");
        pencil.setLength(0);
        pencil.sharpen();
        assertEquals(41, pencil.getPointDurability());
        
    }
    
    //first step toward erasing
    @Test
    public void testingCheckingIfWhatIsWrittenContainsAString(){
        pencil.write("Yoga is the calming of the fluctuations of the mind.");
        String toErase = "mind";
        
        assertEquals(true, pencil.stringWritten.contains(toErase));
    }
    
    //this test was deprecated by the next
//    @Test
//    public void testingErasingStringFromWritingAndLeavingOneSpaceInstead(){
//        pencil.write("The first noble truth is that life is suffering.");
//        pencil.erase("suffering");
//        //if only it were that easy
//        
//        assertEquals("The first noble truth is that life is  .", pencil.getStringWritten());
//    }
    
    @Test
    public void testingErasingStringAndLeavingSpacesEqualToLengthOfErasedWord(){
        pencil.write("The second noble truth is that suffering is caused by desire.");
        pencil.erase("desire");
        assertEquals("The second noble truth is that suffering is caused by       .", pencil.getStringWritten());
    }
   
    //deprecated as additional funcationality added
//    @Test
//    public void testingEraserStartsFromRight(){
//        String text = "The third noble truth is that there is an end to suffering.";
//        pencil.write(text);
//        pencil.erase("is");
//        
//        assertEquals("The third noble truth is that there    an end to suffering.", pencil.getStringWritten());
//        
//    }
    
    @Test
    public void testingEraseStartsFromRightAndFindsAllInstancesOfWordToErase(){
        String text = "The third noble truth is that there is an end to suffering.";
        pencil.write(text);
        pencil.erase("is");
        
        assertEquals("The third noble truth    that there    an end to suffering.", pencil.getStringWritten());
        
    }
    
    @Test
    public void testingEraserDurabilityEraserShouldStopWorkingWhenDurabilityIsZero(){
        String text = "The fourth noble truth is that there is a path to end suffering: the Eightfold Path.";
        pencil.write(text);
        pencil.setEraserDurability(0);
        pencil.erase("is");
        
        assertEquals("The fourth noble truth is that there is a path to end suffering: the Eightfold Path.", pencil.getStringWritten());
    }
    
    @Test
    public void testingEraserShouldStopWorkingWhenDurabilityIsZero(){
        String text = "There once was a man from Nantucket";
        pencil.setEraserDurability(6);
        pencil.write(text);
        pencil.erase("Nantucket");
        
        assertEquals("There once was a man from Nan      ", pencil.getStringWritten());
    }
    
    @Test
    public void testingNewBooleanIfErased(){
        pencil.write("foo bar");
        pencil.erase("bar");
        
        assertEquals(true, pencil.isEraserUsed());
    }
    
    
}
