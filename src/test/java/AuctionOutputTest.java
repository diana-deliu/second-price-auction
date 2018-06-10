import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * Created by deliu on 09.06.2018.
 * Test Class used to check if the algorithm output is correct
 */
public class AuctionOutputTest {

    private AuctionInputReader auctionInputReader = new AuctionInputReader();

    @Test
    public void testAlgorithmInput1() {
        Bidder winner = new Bidder("B");
        int winningPrice = 160;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_1.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput2() {
        Bidder winner = new Bidder("D");
        int winningPrice = 258;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_2.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput3() {
        Bidder winner = new Bidder("nobody");
        int winningPrice = 150;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_3.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput4() {
        Bidder winner = new Bidder("vitel");
        int winningPrice = 100000;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_4.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput5() {
        Bidder winner = new Bidder("purcel");
        int winningPrice = 250000;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_5.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput6() {
        Bidder winner = new Bidder("latrau");
        int winningPrice = 4521;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_6.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput7() {
        Bidder winner = new Bidder("B");
        int winningPrice = 780;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_7.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput8() {
        Bidder winner = new Bidder("B");
        int winningPrice = 1000;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_8.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput9() {
        Bidder winner = new Bidder("nobody");
        int winningPrice = 1000;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_9.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAlgorithmInput10() {
        Bidder winner = new Bidder("C");
        int winningPrice = 1200;
        AuctionResult auctionResult = new AuctionResult(winner, winningPrice);
        try {
            Auction auction = auctionInputReader.transform("algorithm_test_input_files/algorithm_test_input_file_10.txt");
            assertEquals(auctionResult, auction.computeWinner());
        } catch (AuctionException e) {
            fail(e.getMessage());
        }
    }
}
