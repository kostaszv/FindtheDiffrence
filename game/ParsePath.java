package game;

import java.awt.List;
import java.util.ArrayList;

public class ParsePath {
    public static  ArrayList<imageSet> ParsePaths(ArrayList<Img>images){ 
        images.sort(null);
        ArrayList<imageSet> sets = new ArrayList<imageSet>();
        for(int k =0 ; k<images.size();k++){
            for(int i = 1 ; i <images.size();i++){
                int dif = is_the_diffrent(images.get(i),images.get(k));
                if(dif == -1 ){
                    break ;

                }else{
                    imageSet  set ;
                    if(dif == images.get(i).get_Id()){
                         set = new imageSet(images.get(k), images.get(i));
                    }else{
                         set = new imageSet(images.get(i), images.get(k));
                    }
                    sets.add(set);
                    images.remove(i);
                    images.remove(k);
                    k--;
                }
                if(images.size()<2){
                    break;
                }
                
            }
            if(images.size()<2){
                    break;
                }
        }
        return sets;
    }

    
    private static  int is_the_diffrent(Img image1 ,Img image2 ){// returns - 1 if not diff else if the are a set returns the id of the diff image s
            char[] to_compare = new char[image1.getPathLen()-4];
            char[] to_compare2 = new char[image2.getPathLen()- 4];
            int i = 0;
            for(char c1 : image1.get_path().toCharArray()){
                if(c1!='.'){
                    to_compare[i] = c1;
                }else{
                    break;
                }
                i++;
            }
            i = 0;
            for(char c2 : image2.get_path().toCharArray()){
                if(c2!='.'){
                    to_compare2[i] = c2;
                }else{
                    break;
                }
                 i++;
            }
            int pos_of_diffrence = 0;
            for(int k = 0 ; k<Math.min(to_compare.length,to_compare2.length); k++){
                if(to_compare[k]!= to_compare2[k]){
                    return -1;
                }else{
                    pos_of_diffrence ++;
                }
            }
            if(to_compare.length < to_compare2.length){
                 if(to_compare2[pos_of_diffrence]== 'D'){
                    return image2.get_Id();
                }
            }else if(to_compare.length> to_compare2.length){
                if(to_compare[pos_of_diffrence]== 'D'){
                    return image1.get_Id();
                }
            }
            return -1;
    }
}
