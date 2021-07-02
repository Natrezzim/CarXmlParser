import java.io.File;

public class Main {
  public static void main(String[] args) {
    SaxParser parser = new SaxParser();
    String pathToXml = args[0];
    ModificationName modificationName = parser.parse(new File(pathToXml));
    System.out.println(modificationName.getStringSet().size());
  }
}
