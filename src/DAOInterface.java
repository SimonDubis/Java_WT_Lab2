import org.w3c.dom.Document;
import javax.xml.xpath.XPathExpressionException;

/**
 * Interface
 */
public interface DAOInterface {
    /**
     * Method for printing all products
     * @param document file with products
     * @throws XPathExpressionException exception
     */
    void printAllProducts(Document document) throws XPathExpressionException;
    /**
     * Method for printing only kettles
     * @param document file with products
     * @throws XPathExpressionException exception
     */
    void printOnlyKettles(Document document) throws XPathExpressionException;
    /**
     * Method for printing products with minimal price
     * @param document file with products
     * @throws XPathExpressionException exception
     */
    void printProductsWithMinimalCost(Document document) throws XPathExpressionException;
}
