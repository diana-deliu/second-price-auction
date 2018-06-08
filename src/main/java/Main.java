import java.util.Collections;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class Main {

    public static Auction auction;
    public static List<Bidder> biddersList;

    public static void initializeAuctionDetails() {
        auction = AuctionInputReader.parseAuctionDetailsFromBidders();
        biddersList = auction.getBiddersList();
    }

    private static void computeBidderWithMaximumBiddingPrice() {
        Collections.sort(biddersList, new BidderComparator());
        auction.getBiddersList().get(0).setWinner(true);
        auction.setWinningBidder(auction.getBiddersList().get(0));
    }

    private static void computeMaximumBiddingPrice() {
        for (int i = 1; i < biddersList.size(); i++) {
            if (!biddersList.get(i).isWinner) {
                auction.setWinningPrice(biddersList.get(i).getMaximumBiddingPrice());
                break;
            }
        }
    }

    public static void main(String... args) {
        initializeAuctionDetails();
        computeBidderWithMaximumBiddingPrice();
        computeMaximumBiddingPrice();

        System.out.println(auction.toString());
    }
}

