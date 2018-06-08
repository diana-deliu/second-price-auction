import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diahne on 08.06.2018.
 */
public class AuctionInputReader {

    public static List<String> readAllInputLines() {
        List<String> lines = new ArrayList<String>();
        try {
            FileReader inputFile = new FileReader("input.txt");
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String firstLine = bufferReader.readLine();
            if (!firstLine.matches("START[1-9]+")) {
                throw new AuctionException("File does not have or has invalid reserve price!");
            }
            while (bufferReader.readLine() != null) {
                lines.add(bufferReader.readLine());
            }
            parseReservePrice(lines.get(0));
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AuctionException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static Auction parseAuctionDetailsFromBidders() {
        Auction auction = null;
        List<String> lines = readAllInputLines();
        List<Bidder> biddersList = new ArrayList<Bidder>();
        for (int i = 0; i < lines.size(); i++) {
            try {
                biddersList.add(parseBidderDetailFromLine(lines.get(i), i));
            } catch (AuctionException e) {
                e.printStackTrace();
            }
        }
        auction.setBiddersList(biddersList);
        return auction;
    }

    private static int parseReservePrice(String line) {
        return Integer.parseInt(line.substring(line.indexOf('['), line.indexOf(']')));
    }

    public static List<Integer> parseBiddingPricesForABidder(String bidderPrices) {
        String[] biddingPrices = bidderPrices.split(",");
        List<Integer> biddingPricesList = new ArrayList<Integer>();
        for (int i = 0; i < biddingPrices.length; i++) {
            biddingPricesList.add(Integer.parseInt(biddingPrices[i]));
        }
        return biddingPricesList;
    }

    public static Bidder parseBidderDetailFromLine(String line, int i) throws AuctionException {
        if (line == null || line.isEmpty()) {
            throw new AuctionException("Line " + i + " is empty!");
        } else if (line.contains("[") || line.contains("]")) {
            throw new AuctionException("One or both box brackets on line " + i + " is missing!");
        } else if (!line.substring(line.indexOf('['), line.indexOf(']')).matches("[0-9]+")) {
            throw new AuctionException("Bidder prices on line " + i + " are not valid!");
        } else if (!line.substring(0, line.indexOf(']')).matches("[a-zA-z]")) {
            throw new AuctionException("Bidder Name on line " + i + " is missing or is not valid");
        }
        return new Bidder(line.substring(0, line.indexOf('[')),
                parseBiddingPricesForABidder(line.substring(line.indexOf('['), line.indexOf(']'))));
    }
}
