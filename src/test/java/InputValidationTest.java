import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Diahne on 08.06.2018.
 * Test Class used to check if input is correctly passed
 */
public class InputValidationTest {

    private AuctionInputReader auctionInputReader = new AuctionInputReader();

    @Test
    public void testWithEmptyInputFile() {
        try {
            auctionInputReader.transform("validate_test_input_files/empty_input.txt");
        } catch (AuctionException e) {
            assertEquals("File is empty!", e.getMessage());
        }
    }

    @Test
    public void testWithMisspelledStartInFile() {
        try {
            auctionInputReader.transform("validate_test_input_files/misspelled_start.txt");
        } catch (AuctionException e) {
            assertEquals("File does not have or has invalid reserve price!", e.getMessage());
        }
    }

    @Test
    public void tesWithCorrectlySpelledStartWithoutPrice() {
        try {
            auctionInputReader.transform("validate_test_input_files/correctly_spelled_start_without_price.txt");
        } catch (AuctionException e) {
            assertEquals("File does not have or has invalid reserve price!", e.getMessage());
        }
    }

    @Test
    public void tesWithCorrectlySpelledStartWithLettersAsPrice() {
        try {
            auctionInputReader.transform("validate_test_input_files/correctly_spelled_start_with_letters_as_price.txt");
        } catch (AuctionException e) {
            assertEquals("File does not have or has invalid reserve price!", e.getMessage());
        }
    }

    @Test
    public void testWithStartPriceNoBidders() {
        try {
            auctionInputReader.transform("validate_test_input_files/start_price_no_bidders.txt");
        } catch (AuctionException e) {
            assertEquals("File does not contain enough bidders!", e.getMessage());
        }
    }

    @Test
    public void testWithLettersAsBiddingPrice() {
        try {
            auctionInputReader.transform("validate_test_input_files/letters_as_bidding_price.txt");
        } catch (AuctionException e) {
            assertEquals("Bidding prices on line 0 are not valid!", e.getMessage());
        }
    }

    @Test
    public void testWithNoBracketsForBidderLine() {
        try {
            auctionInputReader.transform("validate_test_input_files/no_brackets_for_bidder_line.txt");
        } catch (AuctionException e) {
            assertEquals("One or both box brackets on line 0 is missing!", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidBidderName() {
        try {
            auctionInputReader.transform("validate_test_input_files/invalid_bidder_name.txt");
        } catch (AuctionException e) {
            assertEquals("Bidder name on line 1 is missing or is not valid", e.getMessage());
        }
    }

    @Test
    public void testWithMissingBiddersNames() {
        try {
            auctionInputReader.transform("validate_test_input_files/missing_bidders_names.txt");
        } catch (AuctionException e) {
            assertEquals("Bidder name on line 0 is missing or is not valid", e.getMessage());
        }
    }

    @Test
    public void testWithMissingBiddingPriceAfterComma() {
        try {
            auctionInputReader.transform("validate_test_input_files/missing_bidding_price_after_comma.txt");
        } catch (AuctionException e) {
            assertEquals("Bidding prices on line 6 are not valid!", e.getMessage());
        }
    }

    @Test
    public void testWithNegativeBiddingPrices() {
        try {
            auctionInputReader.transform("validate_test_input_files/missing_bidding_price_after_comma.txt");
        } catch (AuctionException e) {
            assertEquals("Bidding prices on line 6 are not valid!", e.getMessage());
        }
    }

    @Test
    public void testWithMultipleBidderNamesOccurrences() {
        try {
            auctionInputReader.transform("validate_test_input_files/multiple_bidder_names_occurrences.txt");
        } catch (AuctionException e) {
            assertEquals("Bidder name galusca has multiple occurrences!", e.getMessage());
        }
    }
}
