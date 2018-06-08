/**
 * Created by deliu on 08.06.2018.
 */
public class AuctionResult {

    private Bidder auctionWinner;
    private int auctionWinningPrice;

    public AuctionResult(Bidder auctionWinner, int auctionWinningPrice) {
        this.auctionWinner = auctionWinner;
        this.auctionWinningPrice = auctionWinningPrice;
    }

    @Override
    public String toString() {
        if (auctionWinner.getName().toLowerCase().equals("nobody")) {
            return "Nobody has won the auction, but the winning price is the reserve price: " + auctionWinningPrice + ".";
        } else {
            return "Auction conclusions are: \n" +
                    "The winner of the bidding is " + auctionWinner.getName() +
                    " with the winner price of " + auctionWinningPrice +
                    '.';
        }
    }
}
