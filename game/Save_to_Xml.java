package game;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.print.attribute.IntegerSyntax;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;

public class Save_to_Xml {
    public static void Save(){
        ArrayList<Img> images =  ReadImage.ReadImages();
        ArrayList<imageSet> sets =ParsePath.ParsePaths(images);
        try{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("root"); // Create the root element only once
            doc.appendChild(rootElement);
            rootElement.appendChild(doc.createTextNode("\n"));
            int i = 0 ;
           
            for (imageSet set : sets) {
                
                Element dataElement = doc.createElement("data");
                rootElement.appendChild(dataElement); // Append to rootElement, not doc
                addDataToXML(doc, dataElement, "ID", Integer.toString(i));
                addDataToXML(doc, dataElement, "ORIGINAL_IMAGE", set.getOriginalImagePath());
                addDataToXML(doc, dataElement, "DIFFERENT_IMAGE", set.getDiffImagePath());
                game.CompareImg cmim = new game.CompareImg(set.getOriginalImagePath(),set.getDiffImagePath());
                ArrayList<Diffrence>  difs = cmim.diffrentBox();
    
                if(difs!=null){
                    for(Diffrence d :difs){
                    String difStr = "";
                    for(PixelBox p :d.getDiffrence()){
                         difStr +="["+ p.posx+","+p.posy+"]";
                    }
                    addDataToXML(doc, dataElement, "DIFFRENCES", difStr);
                    }
                }else{
                    addDataToXML(doc, dataElement, "DIFFRENCES", "EMPTY");
                }
                

                i++;
            }
            // Create the root element
            
            writeXmlToFile(doc, "output.xml");

            System.out.println("XML file created successfully!");
        }catch (Exception e) {
            e.printStackTrace();
            }
        }
    
        private static void addDataToXML(Document doc, Element parentElement, String tagName, String textContent) {
            Element element = doc.createElement(tagName);
            element.appendChild(doc.createTextNode(textContent));
            parentElement.appendChild(element);
            parentElement.appendChild(doc.createTextNode("\n"));
            
        }
         
    
    private static void writeXmlToFile(Document document, String fileName) {
        try {
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new java.io.File(fileName));
            transformer.transform(source, result);
        } catch (javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
    }
}
