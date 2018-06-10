import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Diahne on 08.06.2018.
 * Test Class used to check if input is correctly passed
 */
public class InputValidationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private AuctionInputReader auctionInputReader = new AuctionInputReader();

    @Test
    public void testWithEmptyInputFile() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("File is empty!");
        auctionInputReader.transform("validate_test_input_files/empty_input.txt");
    }

    @Test
    public void testWithMisspelledStartInFile() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("File does not have or has invalid reserve price!");
        auctionInputReader.transform("validate_test_input_files/misspelled_start.txt");
    }

    @Test
    public void tesWithCorrectlySpelledStartWithoutPrice() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("File does not have or has invalid reserve price!");
        auctionInputReader.transform("validate_test_input_files/correctly_spelled_start_without_price.txt");
    }

    @Test
    public void tesWithCorrectlySpelledStartWithLettersAsPrice() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("File does not have or has invalid reserve price!");
        auctionInputReader.transform("validate_test_input_files/correctly_spelled_start_with_letters_as_price.txt");
    }

    @Test
    public void testWithStartPriceNoBidders() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("File does not contain enough bidders!");
        auctionInputReader.transform("validate_test_input_files/start_price_no_bidders.txt");
    }

    @Test
    public void testWithLettersAsBiddingPrice() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("Bidding prices on line 0 are not valid!");
        auctionInputReader.transform("validate_test_input_files/letters_as_bidding_price.txt");
    }

    @Test
    public void testWithNoBracketsForBidderLine() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("One or both box brackets on line 0 is missing!");
        auctionInputReader.transform("validate_test_input_files/no_brackets_for_bidder_line.txt");
    }

    @Test
    public void testWithInvalidBidderName() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("Bidder name on line 1 is missing or is not valid");
        auctionInputReader.transform("validate_test_input_files/invalid_bidder_name.txt");
    }

    @Test
    public void testWithMissingBiddersNames() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("Bidder name on line 0 is missing or is not valid");
        auctionInputReader.transform("validate_test_input_files/missing_bidders_names.txt");
    }

    @Test
    public void testWithMissingBiddingPriceAfterComma() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("Bidding prices on line 6 are not valid!");
        auctionInputReader.transform("validate_test_input_files/missing_bidding_price_after_comma.txt");
    }

    @Test
    public void testWithNegativeBiddingPrices() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("Bidding prices on line 0 are not valid!");
        auctionInputReader.transform("validate_test_input_files/negative_bidding_prices.txt");
    }

    @Test
    public void testWithMultipleBidderNamesOccurrences() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("Bidder name galusca has multiple occurrences!");
        auctionInputReader.transform("validate_test_input_files/multiple_bidder_names_occurrences.txt");
    }

    @Test
    public void testWithMultipleOccurrencesOfSameBiddingPrice() throws AuctionException {
        expectedException.expect(AuctionException.class);
        expectedException.expectMessage("The same price 170 cannot be bid twice!");
        auctionInputReader.transform("validate_test_input_files/multiple_occurrences_of_same_bidding_price.txt");
    }
}
