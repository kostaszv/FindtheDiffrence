package game;
class PixelBox{
    int posx   ;
    int posy ; 
    Pixel[][] pixelbox;
    Boolean diffrent;
    PixelBox(){
        pixelbox = new Pixel[5][5];
        diffrent = false; 
    }

    public void setPixelBox(Pixel pixel,int i , int k,int posx , int posy ){
        if(pixelbox[i][k] == null){
            pixelbox[i][k]=new Pixel();
        }
          pixelbox[i][k] =  pixel;
          this.posx = posx;
          this.posy = posy;
    }

    public boolean isDiffrent(PixelBox pxbox2){
        for(int i = 0 ; i<pixelbox.length;i++){
            for(int k =0 ; k <pixelbox[0].length; k++){
                if(pixelbox[i][k].compareTo(pxbox2.pixelbox[i][k])){
                    this.diffrent = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    public void DrawDiffrence( ){
         for(int i = 0 ; i < pixelbox.length;i++){
            for(int k = 0 ; k < pixelbox[0].length; k ++){
                    this.pixelbox[i][k].setBlue(k*i*2);
            }
         }
    }

    public void SetIsDiff(){
        this.diffrent = true;
    }

    public Boolean clickedDiff(int posx , int posy ){
            for(Pixel p1[] : pixelbox){
                for(Pixel p2 : p1){
                    if(p2.k == posy&& p2.i == posx){
                        System.out.println(p2);
                        return true;
                    }
                }
            }
            return false;
    }

    
    
}
