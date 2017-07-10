package GetDistData;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Arnab
 * @version 1.0
 */
public class JsoupURLTester {

    private static Document doc;

    public static void main(String[] args) {

        for (int counter = 1081;; counter++) {

            //int il = 2;
            String websiteUrl = "https://indane.co.in/distributor_details.php?distid=1" + counter;

            try {
                doc = Jsoup.connect(websiteUrl)//connection @Arnab
                        .userAgent("Mozilla/5.0 ")
                        .timeout(600)
                        .get();
                System.out.println("Connected");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            // tree selection,05/07/17,
            System.out.println("\n" + counter + "\n");
            Element tableOne = doc.select("table").get(1);
            Elements rows = tableOne.select("tr");
            String distName = tableOne.select("div").get(0).text();

            Element distPropName = tableOne.select("div").get(3);
            String s1 = distPropName.select("div").get(1).text();
            String PropName = s1.substring(21);

            Element tableTwo = doc.select("table").get(2);
            String LandlindNo = tableTwo.select("td").get(2).text();
            Element tableThree = doc.select("table").get(3);
            String MobileNo = tableTwo.select("td").get(4).text();
            String eMail = tableTwo.select("td").get(6).text();

            Element tableFour = doc.select("table").get(4);
            String AO_Name = tableFour.select("td").get(9).text();

            //Ouputing Data 
            System.out.println(distName);
            System.out.print(PropName + "\n");//Have to use Substring class for removing the "name of proprietor
            System.out.print(LandlindNo + "\n");
            System.out.print(MobileNo + "\n");
            System.out.print(eMail + "\n");
            System.out.print(AO_Name + "\n");

            System.out.println("\n" + counter + "\n");

        }
    }
}
