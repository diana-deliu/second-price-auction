/**
 * Created by Diahne on 08.06.2018.
 * Main class
 */
public class Main {

    public static void main(String... args) throws AuctionException {
        if (args.length < 1) {
            System.out.println("Usage for the auction program: second-price-auction.jar <.txt input file path>");
            System.exit(0);
        }
        AuctionInputReader auctionInputReader = new AuctionInputReader();
        Auction auction = auctionInputReader.transform(args[0]);
        AuctionResult auctionResult = auction.computeWinner();

        System.out.println(auctionResult.toString());
    }
}

