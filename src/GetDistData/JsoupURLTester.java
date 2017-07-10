package GetDistData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //String query = null;
        String Connurl = "jdbc:derby:src/db/DistData;create=true";
        String userName = "us3r";
        String pass = "pass";
        String Url = "https://indane.co.in/distributor_details.php?distid=";
        String webSite=null;
        int counter = 1081;
        try (PrintWriter writer = new PrintWriter("DistList.txt", "UTF-8")) {
            for (;; counter++) {
            try {
                
            
            

            webSite=Url+counter;
            // + counter;
//            File file = new File("C:/Users/Arnab/Desktop/index.html");
            
//                doc = Jsoup.parse(file, "utf-8", "abcd.co.in");
                doc = Jsoup.connect(webSite)//connection @Arnab
                        .userAgent("Mozilla/5.0 ")
                        .timeout(600)
                        .get();
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

                
                    writer.println("\n"+
                            +counter+
                            ","
                            +distName+
                            ","
                            +PropName+
                            ","
                            +LandlindNo+
                            ","
                            +MobileNo+
                            ","
                            +eMail+
                            ","
                            +AO_Name+"\n");
                
                } catch (Exception e) {
            e.printStackTrace();
                }
            
            }
            }catch (IOException ex) {
               System.err.println(ex);
              
            }


}
}