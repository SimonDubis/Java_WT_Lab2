import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

/**
 * Main class
 */
public class DAO implements DAOInterface {
    /**
     * Method for printing all products
     * @param document file with products
     * @throws XPathExpressionException exception
     */
    @Override
    public void printAllProducts(Document document) throws XPathExpressionException {
        System.out.print("Print all Products:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("/goods");

        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
    }

    /**
     * Method for printing only kettles
     * @param document file with products
     * @throws XPathExpressionException exception
     */
    @Override
    public void printOnlyKettles(Document document) throws XPathExpressionException {
        System.out.print("Print only kettles:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("//good[info/@type='kettle']");

        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
        System.out.println();
    }

    /**
     * Method for printing products with minimal price
     * @param document file with products
     * @throws XPathExpressionException exception
     */
    @Override
    public void printProductsWithMinimalCost(Document document) throws XPathExpressionException {
        System.out.print("Print products with minimal cost:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expr = xPath.compile("//good[not(price > //good/price)]");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
    }
}
