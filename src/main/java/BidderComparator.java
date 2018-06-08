import java.util.Comparator;

/**
 * Created by Diahne on 08.06.2018.
 */
public class BidderComparator implements Comparator<Bidder> {

    public int compare(Bidder bidder1, Bidder bidder2) {
        return bidder2.getMaximumBiddingPrice() - bidder1.getMaximumBiddingPrice();
    }
}
