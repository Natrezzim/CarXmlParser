import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SaxParser {

  public ModificationName parse(File file) {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SaxParserHandler handler = new SaxParserHandler();
    SAXParser parser = null;
    try {
      parser = factory.newSAXParser();
    } catch (ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    }
    try {
      if (parser != null) {
        parser.parse(file, handler);
      }
    } catch (SAXException | IOException e) {
      e.printStackTrace();
    }

    return handler.getModificationName();
  }
}
