package game;

public class imageSet {
    Img original ;
    Img diffrent;
    public imageSet(Img original , Img diffrent){
        this.original = original;
        this.diffrent = diffrent;
    }   
    public String getOriginalImagePath(){
        return original.get_path();
    }
    public String getDiffImagePath(){
        return diffrent.get_path();
    }
}
