/**
 * Created by deliu on 08.06.2018.
 */
public interface Transformer<T1, T2> {
    T2 transform(T1 input) throws AuctionException;
}
