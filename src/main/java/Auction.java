import java.util.Collections;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class Auction {

    private List<Bidder> biddersList;
    private int reservePrice;

    public Auction() {
    }

    public void setBiddersList(List<Bidder> biddersList) {
        this.biddersList = biddersList;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public AuctionResult computeWinner() {
        Collections.sort(biddersList, new BidderComparator());

        Bidder winner = biddersList.get(0);
        int winningPrice;

        if (winner.getMaximumBiddingPrice() < reservePrice) {
            winner.setName("nobody");
            winningPrice = reservePrice;
        } else {
            winningPrice = biddersList.get(1).getMaximumBiddingPrice();
        }

        return new AuctionResult(winner, winningPrice);
    }
}


