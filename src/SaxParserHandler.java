import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserHandler extends DefaultHandler {

  private final List<String> stringList = new ArrayList<>();
  ModificationName modificationName = new ModificationName();

  public ModificationName getModificationName() {
    return modificationName;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    if (qName.equals("modification")) {
      if (attributes != null && attributes.getLength() > 0) {
        for (int i = 0; i < attributes.getLength(); i++) {
          if (attributes.getLocalName(i).equals("name")) {
            stringList.add(attributes.getValue(i));
          }
        }
      }
    }
  }

  @Override
  public void endDocument() {
    Set<String> stringSet = new HashSet<>(stringList);
    modificationName.setStringSet(stringSet);
  }
}
