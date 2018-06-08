import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class Auction {
    public List<Bidder> biddersList;
    public int winningPrice;
    public int reservePrice;
    public Bidder winningBidder;

    public Auction(List<Bidder> biddersList) {
        this.biddersList = biddersList;
    }

    public List<Bidder> getBiddersList() {
        return biddersList;
    }

    public void setBiddersList(List<Bidder> biddersList) {
        this.biddersList = biddersList;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public void setWinningPrice(int winningPrice) {
        this.winningPrice = winningPrice;
    }

    public Bidder getWinningBidder() {
        return winningBidder;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public void setWinningBidder(Bidder winningBidder) {
        this.winningBidder = winningBidder;
    }

    @Override
    public String toString() {
        return "Auction conclusions are: \n" +
                "The winner of the bidding is " + winningBidder +
                " with the winner price of " + winningPrice +
                '.';
    }
}


