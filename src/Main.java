import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Main Class
 */
public class Main {
    /**
     * Entry point to the program
     * @param args parameters
     */
    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("products.xml");

            DAO dao = new DAO();

            dao.printAllProducts(document);
            dao.printOnlyKettles(document);
            dao.printProductsWithMinimalCost(document);

        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
