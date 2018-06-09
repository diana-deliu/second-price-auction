import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Diahne on 08.06.2018.
 * Transforms data from input file to Auction
 */
public class AuctionInputReader implements Transformer<String, Auction> {

    private String firstLine;
    private Set<String> biddersNames = new HashSet<String>();

    private List<String> readAllInputLines(String fileInputPath) throws AuctionException {
        List<String> lines = new ArrayList<String>();
        try {
            FileReader inputFile = new FileReader(fileInputPath);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            firstLine = bufferReader.readLine();
            if (firstLine == null) {
                throw new AuctionException("File is empty!");
            }
            if (!firstLine.matches("(?i)Start\\[[0-9]+\\]")) {
                throw new AuctionException("File does not have or has invalid reserve price!");
            }
            parseReservePrice(firstLine);
            String line = bufferReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferReader.readLine();
            }
            if (lines.size() < 2) {
                throw new AuctionException("File does not contain enough bidders!");
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private Auction parseAuctionDetailsFromBidders(String fileInputPath) throws AuctionException {
        Auction auction = new Auction();
        List<String> lines = readAllInputLines(fileInputPath);
        List<Bidder> biddersList = new ArrayList<Bidder>();
        for (int i = 0; i < lines.size(); i++) {
            biddersList.add(parseBidderDetailFromLine(lines.get(i), i));
        }
        auction.setBiddersList(biddersList);
        auction.setReservePrice(parseReservePrice(firstLine));
        return auction;
    }

    private int parseReservePrice(String line) {
        return Integer.parseInt(line.substring(line.indexOf('[') + 1, line.indexOf(']')));
    }

    private List<Integer> parseBiddingPricesForABidder(String bidderPrices) {
        String[] biddingPrices = bidderPrices.split(",");
        List<Integer> biddingPricesList = new ArrayList<Integer>();
        for (String biddingPrice : biddingPrices) {
            if (!biddingPrice.trim().equals("")) {
                biddingPricesList.add(Integer.parseInt(biddingPrice.trim()));
            }
        }
        return biddingPricesList;
    }

    private Bidder parseBidderDetailFromLine(String line, int i) throws AuctionException {
        if (!line.contains("[") || !line.contains("]")) {
            throw new AuctionException("One or both box brackets on line " + i + " is missing!");
        }
        String bidderName = line.substring(0, line.indexOf('['));
        String biddingPricesForABidder = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
        if (!biddingPricesForABidder.matches("[0-9\\-]*(,( )*[0-9]+)*")) {
            throw new AuctionException("Bidding prices on line " + i + " are not valid!");
        }
        if (!biddersNames.add(bidderName)) {
            throw new AuctionException("Bidder name " + bidderName + " has multiple occurrences!");
        }
        if (!bidderName.matches("[a-zA-z]+")) {
            throw new AuctionException("Bidder name on line " + i + " is missing or is not valid");
        }
        return new Bidder(bidderName, parseBiddingPricesForABidder(biddingPricesForABidder));
    }

    public Auction transform(String fileInputPath) throws AuctionException {
        return parseAuctionDetailsFromBidders(fileInputPath);
    }
}
