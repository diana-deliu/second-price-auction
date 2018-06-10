import java.util.Collections;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 * Bidder class
 */
public class Bidder {

    private String name;
    private int maximumBiddingPrice;
    private List<Integer> biddingPrices;

    public Bidder() {
    }

    Bidder(String name) {
        this.name = name;
    }

    Bidder(String name, List<Integer> biddingPrices) {
        this.name = name;
        this.biddingPrices = biddingPrices;
        if (biddingPrices.size() != 0) {
            this.maximumBiddingPrice = Collections.max(biddingPrices);
        }
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getMaximumBiddingPrice() {
        return maximumBiddingPrice;
    }

    List<Integer> getBiddingPrices() {
        return biddingPrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bidder bidder = (Bidder) o;

        return name.equals(bidder.getName());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + maximumBiddingPrice;
        result = 31 * result + (biddingPrices != null ? biddingPrices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
