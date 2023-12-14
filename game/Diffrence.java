package game;
import java.util.ArrayList;

public class Diffrence {   
    ArrayList<PixelBox> difs ;
    int no;
    Diffrence(){
        difs = new ArrayList<PixelBox>();
        this.no = 1;
    }
    Diffrence(int no){
        this.no = no ;
    }
    public ArrayList<PixelBox> getDiffrence(){
        return difs;
    }
    public static ArrayList<PixelBox> getDiffBoxes(PixelBoxImg box1,PixelBoxImg box2){
        ArrayList<PixelBox> difs = box1.diffBoxes(box2);
        return difs;
    }

    public boolean conjdiffrence(PixelBox diffrentboxes){
        for(int i = 0 ; i<difs.size();i++){
            if(Math.abs(difs.get(i).posx -diffrentboxes.posx)<10&&Math.abs(difs.get(i).posy - diffrentboxes.posy)<10){
                return true;
            }
        }
        return false;
    }

    public void AddPixelBox(PixelBox box1){
        difs.add(box1);
    }

    public PixelBox GetPixelBox(int i){
        if(i<difs.size()){
            return difs.get(i);
        }
        return null;
    }

    public Boolean clickeddif(int posx , int posy){
        for(PixelBox d : difs){
            if(d.clickedDiff(posx, posy)){
                System.out.println();
                return true;
            }
        }
        return false;
    }
}
