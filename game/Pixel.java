package game;
public class Pixel  {
    private  int red ;
     private int green ; 
     private int blue;
     private int alpha;
        int i;
      int k ;
    Pixel(int red , int green,int blue ,int alpha,int i , int k){
        this.red = red ;
        this.green =  green;
        this.blue = blue;
        this.alpha = alpha; 
        this.i = i ;
        this.k = k;
    }
    Pixel(){}
    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    
    public Boolean compareTo(Pixel p) {
        if(p.blue == 255){
            int s = 0 ;
        }
        if(this.red != p.red || this.blue != p.blue ||  this.green != p.green ){
        
            return true;
        }

        return false;
    }

 
}
