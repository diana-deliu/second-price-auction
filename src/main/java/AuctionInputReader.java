import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class AuctionInputReader implements Transformer<String, Auction> {

    private String firstLine;

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
            try {
                biddersList.add(parseBidderDetailFromLine(lines.get(i), i));
            } catch (AuctionException e) {
                e.printStackTrace();
            }
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
        for (int i = 0; i < biddingPrices.length; i++) {
            biddingPricesList.add(Integer.parseInt(biddingPrices[i].trim()));
        }
        return biddingPricesList;
    }

    private Bidder parseBidderDetailFromLine(String line, int i) throws AuctionException {
        if (line == null || line.isEmpty()) {
            throw new AuctionException("Line " + i + " is empty!");
        } else if (!line.contains("[") || !line.contains("]")) {
            throw new AuctionException("One or both box brackets on line " + i + " is missing!");
        } else if (!line.substring(line.indexOf('[') + 1, line.indexOf(']')).matches("[0-9]+(, [0-9]+)*")) {
            throw new AuctionException("Bidder prices on line " + i + " are not valid!");
        } else if (!line.substring(0, line.indexOf('[')).matches("[a-zA-z]")) {
            throw new AuctionException("Bidder Name on line " + i + " is missing or is not valid");
        }
        return new Bidder(line.substring(0, line.indexOf('[')),
                parseBiddingPricesForABidder(line.substring(line.indexOf('[') + 1, line.indexOf(']'))));
    }

    public Auction transform(String fileInputPath) throws AuctionException{
        return parseAuctionDetailsFromBidders(fileInputPath);
    }
}
