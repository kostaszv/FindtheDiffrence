package game;
import java.util.ArrayList;

public class CompareImg {
    Img image1;
    Img image2;
    ArrayList<PixelBox> diffrentboxes ;
    ArrayList<Diffrence> difs ;
    public CompareImg(String path1 , String path2){
       image1 = new Img(path1);
       image2 = new Img(path2); 
    }

    public ArrayList<Diffrence> diffrentBox(){
        PixelBoxImg boxes1  = image1.createPixelBox();
        PixelBoxImg boxes2  = image2.createPixelBox();
        difs = new ArrayList<Diffrence>();
        diffrentboxes = new ArrayList<PixelBox>();
        diffrentboxes = boxes1.diffBoxes(boxes2);
        if(diffrentboxes.size()<=0){
            return null;
        }
        image1.DrawNewPic();
        Diffrence dif1 = new Diffrence();
        dif1.AddPixelBox(diffrentboxes.get(0));
        diffrentboxes.remove(0);
        difs.add(dif1);
        boolean founddif = false;
        int posofdif = 0;
        while (true) {
            for(int i =0; i<diffrentboxes.size(); i++){
                for(int k = 0 ; k<difs.size();k++){
                    if(diffrentboxes.size()>0&& i<diffrentboxes.size()){
                    if(difs.get(k).conjdiffrence(diffrentboxes.get(i))){
                            difs.get(k).AddPixelBox(diffrentboxes.get(i));
                            diffrentboxes.remove(i);
                            founddif = true;
                            if(diffrentboxes.size()==0){
                            break;
                        }
                    
                        
                    }else if (diffrentboxes.size()<i){
                        break;
                    }
                }else {
                    break;
                }
                }
                if(founddif == false){

                
                Diffrence ndif = new Diffrence();
                        ndif.AddPixelBox(diffrentboxes.get(i));
                        difs.add(ndif);
                        diffrentboxes.remove(i);
                        if(diffrentboxes.size()==0){
                            break;
                        }
                    }
                    founddif = false;
                   
            }
           
            if(diffrentboxes.size()==0){
                break;
            }
        }
        System.out.println();
       return this.difs;
        
        
    }


    public void FindDif(int xpos ,int ypos){
        int i = 0 ;
        Diffrence d = new Diffrence(0);
            while (difs.size()>0&& i < difs.size()) {
                    if(difs.get(i).clickeddif(xpos, ypos)){
                    System.out.println("Diffrence Found ");
                    d = difs.get(i);
                    break;
                }
                i++;
            }
            if(difs.size()>0&& d.no!= 0){
                difs.remove(d);
            }
            
             int g = 1 ;   
            
    }

}
