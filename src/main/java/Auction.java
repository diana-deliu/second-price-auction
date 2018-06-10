import java.util.Collections;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 * Auction class
 */
class Auction {

    private List<Bidder> biddersList;
    private int reservePrice;

    Auction() {
    }

    void setBiddersList(List<Bidder> biddersList) {
        this.biddersList = biddersList;
    }

    void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    AuctionResult computeWinner() {
        Collections.sort(biddersList, new BidderComparator());
        Bidder winner = biddersList.get(0);
        int winningPrice = biddersList.get(1).getMaximumBiddingPrice();

        if (winner.getMaximumBiddingPrice() < reservePrice) {
            winner.setName("nobody");
            winningPrice = reservePrice;
        }
        if (winningPrice < reservePrice) {
            winningPrice = reservePrice;
        }

        return new AuctionResult(winner, winningPrice);
    }
}


