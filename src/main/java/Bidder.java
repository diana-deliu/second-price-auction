import java.util.Collections;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class Bidder {

    public String name;
    public int maximumBiddingPrice;
    public int winnerPrice;
    public boolean isWinner;
    public List<Integer> biddingPrices;

    public Bidder(String name, List<Integer> biddingPrices) {
        this.name = name;
        this.biddingPrices = biddingPrices;
        this.maximumBiddingPrice = Collections.max(biddingPrices);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaximumBiddingPrice() {
        return maximumBiddingPrice;
    }

    public void setMaximumBiddingPrice(int maximumBiddingPrice) {
        this.maximumBiddingPrice = maximumBiddingPrice;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public void setWinnerPrice(int winnerPrice) {
        this.winnerPrice = winnerPrice;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public List<Integer> getBiddingPrices() {
        return biddingPrices;
    }

    public void setBiddingPrices(List<Integer> biddingPrices) {
        this.biddingPrices = biddingPrices;
    }

    @Override
    public String toString() {
        return name;
    }
}
