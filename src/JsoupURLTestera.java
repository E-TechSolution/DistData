

import java.io.File;
import java.io.IOException;
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
public class JsoupURLTestera {

    private static Document doc;

  
         public static void st() {
        String query = null;
        String Connurl = "jdbc:derby:C:\\Users\\Arnab\\Documents\\NetBeansProjects\\DistData\\src\\db\\DistData";
        String userName = "us3r";
        String pass = "pass";
        for (int counter = 1081;; counter++) {

            //int il = 2;
            //String websiteUrl = "https://indane.co.in/distributor_details.php?distid=1" + counter;
            File file = new File("C:/Users/Arnab/Desktop/index.html");
            try {
                doc = Jsoup.parse(file, "utf-8", "abcd.co.in");
//                doc = Jsoup.connect(websiteUrl)//connection @Arnab
//                        .userAgent("Mozilla/5.0 ")
//                        .timeout(600)
//                        .get();
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
                System.out.println(userName);
                System.out.println(pass);
                query = "INSERT INTO APP.DIST_DATA (FNAME) VALUES (?)";
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                Connection conn = DriverManager.getConnection(Connurl, userName, pass);
                System.out.println("2");
                PreparedStatement prst = conn.prepareStatement(query);
                System.out.println("Connected To DB");
                prst.setString(1, distName);
//                prst.setString(2, PropName);
//                prst.setString(3, LandlindNo);
//                prst.setString(4, MobileNo);
//                prst.setString(5, eMail);
//                prst.setString(6, AO_Name);
                System.out.println("S1");
                prst.execute();
                System.out.println("S2");
                System.out.println("Connected");
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                System.out.println(ex);
            }
            // tree selection,05/07/17,
            
            // tree selection,05/07/17,

            //Ouputing Data 
//            System.out.println(distName);
//            System.out.print(PropName + "\n");//Have to use Substring class for removing the "name of proprietor
//            System.out.print(LandlindNo + "\n");
//            System.out.print(MobileNo + "\n");
//            System.out.print(eMail + "\n");
//            System.out.print(AO_Name + "\n");
            System.out.println("\n" + counter + "\n");
break;
//                if(affected==1){
//                    System.out.println("Sucessfully Inserted");
//                } else {
//                    System.out.println("Fiald to insert");
//                }
        }
    }
}