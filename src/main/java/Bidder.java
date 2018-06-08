import java.util.Collections;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class Bidder {

    private String name;
    private int maximumBiddingPrice;
    private List<Integer> biddingPrices;

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

    @Override
    public String toString() {
        return name;
    }
}
