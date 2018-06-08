import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Diahne on 08.06.2018.
 */
public class SecondPriceAuctionTest {

    @Test
    public void testEmptyInputFile()  {
        AuctionInputReader auctionInputReader = new AuctionInputReader();
        try {
            auctionInputReader.transform("input_files/empty_input.txt");
        } catch (AuctionException e) {
            e.printStackTrace();
            assertEquals("File is empty!", e.getMessage());
        }

    }

    @Test
    public void testMisspelledStartInFile()  {
        AuctionInputReader auctionInputReader = new AuctionInputReader();
        try {
            auctionInputReader.transform("input_files/misspelled_start.txt");
        } catch (AuctionException e) {
            e.printStackTrace();
            assertEquals("File does not have or has invalid reserve price!", e.getMessage());
        }
    }

    @Test
    public void testCorrectlySpelledStartWithoutPrice()  {
        AuctionInputReader auctionInputReader = new AuctionInputReader();
        try {
            auctionInputReader.transform("input_files/correctly_spelled_start_without_price.txt");
        } catch (AuctionException e) {
            e.printStackTrace();
            assertEquals("File does not have or has invalid reserve price!", e.getMessage());
        }
    }

    @Test
    public void testCorrectlySpelledStartWithLetterAsPrice()  {
        AuctionInputReader auctionInputReader = new AuctionInputReader();
        try {
            auctionInputReader.transform("input_files/correctly_spelled_start_with_letters_as_price.txt");
        } catch (AuctionException e) {
            e.printStackTrace();
            assertEquals("File does not have or has invalid reserve price!", e.getMessage());
        }
    }

}
