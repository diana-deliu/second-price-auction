/**
 * Created by Diahne on 08.06.2018.
 */
public class Main {

    public static void main(String... args) throws AuctionException {

        AuctionInputReader auctionInputReader = new AuctionInputReader();
        Auction auction = auctionInputReader.transform("empty_input.txt");
        AuctionResult auctionResult = auction.computeWinner();

        System.out.println(auctionResult.toString());
    }
}

