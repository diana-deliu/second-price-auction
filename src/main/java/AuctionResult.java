/**
 * Created by deliu on 08.06.2018.
 * Computes the winner and the winning price
 */
public class AuctionResult {

    private Bidder auctionWinner;
    private int auctionWinningPrice;

    AuctionResult(Bidder auctionWinner, int auctionWinningPrice) {
        this.auctionWinner = auctionWinner;
        this.auctionWinningPrice = auctionWinningPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuctionResult that = (AuctionResult) o;
        return auctionWinningPrice == that.auctionWinningPrice && auctionWinner.equals(that.auctionWinner);
    }

    @Override
    public int hashCode() {
        int result = auctionWinner != null ? auctionWinner.hashCode() : 0;
        result = 31 * result + auctionWinningPrice;
        return result;
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
