package game;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitOption.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
public class ReadImage {
    public static ArrayList<Img> ReadImages(){
     // Specify the path to the folder containing PNG images
     Path folderPath = Paths.get("C:/Users/vagelis/Desktop/findthediffrence/assets");

        List<String> pngPaths = new ArrayList<>();

        try {
            // Use Files.walk to get all files in the folder and its subfolders
            try (var paths = Files.walk(folderPath)) {
                paths.filter(Files::isRegularFile)
                     .filter(path -> path.toString().toLowerCase().endsWith(".png"))
                     .forEach(path -> pngPaths.add(path.getFileName().toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print or use the paths as needed
        for (String path : pngPaths) {
            System.out.println(path);
        }
        
    return convertToImgObj(pngPaths);
 }

 public static ArrayList<Img> convertToImgObj(List<String> paths){
    int id =  0 ;
    ArrayList<Img> images = new ArrayList<Img>();
    for(String path : paths){
        Img image = new Img(path,id);
        id++;
        images.add(image);
    }
    return images;
 }
}
