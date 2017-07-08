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
        for (int i = 1081; ;i++) {
            
            //int il = 2;
        String websiteUrl="https://indane.co.in/distributor_details.php?distid=1"+i;
            
        
        try {
//            File input = new File("C:\\Users\\Arnab\\Desktop\\indane.html");
//            doc = Jsoup.parse(input,"utf-8","https://indane.co.in");
            doc = Jsoup.connect(websiteUrl)//connection @Arnab
             .userAgent("Mozilla/5.0 ")//(Windows NT 6.1; rv:55.0) Gecko/20100101 Firefox/55.0
             .timeout(600)
             .get();
            System.out.println("Connected");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        // tree selection,05/07/17,
         System.out.println("\n"+i+"\n");
         Element tableOne = doc.select("table").get(1);
         Elements rows = tableOne.select("tr");
         String distName = tableOne.select("div").get(0).text();
         System.out.println(distName);
         Element distPropName = tableOne.select("div").get(3);
         String s1 = distPropName.select("div").get(1).text();
         String distPropNameOne =s1.substring(21);
         System.out.print(distPropNameOne+"\n");//Have to use Substring class for removing the "name of proprietor
        
         Element tableTwo = doc.select("table").get(2);
         String rowTwo=tableTwo.select("td").get(2).text();
         Element tableThree = doc.select("table").get(3);
         String rowThrree=tableTwo.select("td").get(4).text();
         String rowFour=tableTwo.select("td").get(6).text();
         System.out.print(rowTwo+"\n");
         System.out.print(rowThrree+"\n");
         System.out.print(rowFour+"\n");
          //Element tableFour = doc.select("table").get(5);
         Element tableFour = doc.select("table").get(4);
          String rowFive= tableFour.select("td").get(9).text();
         System.out.print(rowFive+"\n");

         System.out.println("\n"+i+"\n");        
//if (distPropName == null);
//    break;
    
    
}
}
}