
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Webscraper {
    public static void main(String[] args) throws Exception {

        final String url = "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";
        String ticker;
        String name;
        String tempPrice;
        String tempPrice1;
        double price;

        try {
            final Document document = Jsoup.connect(url).get();

            for (Element row : document.select("table.tablesorter.full tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    ticker = row.select("td:nth-of-type(1)").text();
                    name = row.select("td:nth-of-type(2)").text();
                    tempPrice = row.select("td:nth-of-type(3)").text();
                    tempPrice1 = tempPrice.replace(",", "");
                    price = Double.parseDouble(tempPrice1);
                    String f = ticker + " " + name + " " + price;
                    System.out.println(f);

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
