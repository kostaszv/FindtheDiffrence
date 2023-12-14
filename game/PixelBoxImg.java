package game;
import java.util.ArrayList;

class PixelBoxImg{
    PixelBox[][] boxes;
    
    PixelBoxImg(){
        boxes = new PixelBox[100][100];
        
    }
    public PixelBox getPixelBox(int i,int k){
        return boxes[i][k];
    }
    public void setBoxImg(PixelBox box,int i ,int k){
        boxes[i][k] = box;
    }
    public ArrayList<PixelBox> diffBoxes(PixelBoxImg imgbox2){
        ArrayList<PixelBox>  difboxes  = new ArrayList<PixelBox>();
        for(int i = 0 ; i<boxes.length; i++){
            for(int k = 0; k<boxes.length; k++){
                if(boxes[i][k].isDiffrent(imgbox2.boxes[i][k])){
                    difboxes.add(boxes[i][k]);
                }
            }
        }
        return difboxes;
    }

    public Pixel[][] convertToPixelsArray() {
        int boxWidth = 5; // Assuming each PixelBox has dimensions 20x20
        int boxHeight = 5;
        Pixel[][] pixels = new Pixel[500][500];

        for (int boxRow = 0; boxRow < boxes.length; boxRow++) {
            for (int boxCol = 0; boxCol < boxes[0].length; boxCol++) {
                PixelBox currentBox = boxes[boxRow][boxCol];
                if(currentBox.diffrent==true){
                    for (int row = 0; row < boxHeight; row++) {
                    for (int col = 0; col < boxWidth; col++) {
                        Pixel pixelValue = currentBox.pixelbox[col][row];
                        int pixelRow = boxRow * boxHeight + row;
                        int pixelCol = boxCol * boxWidth + col;
                        pixels[pixelCol][pixelRow] = pixelValue;
                        pixels[pixelCol][pixelRow].setBlue(255);
                    }
                }
                }else{
                    for (int row = 0; row < boxHeight; row++) {
                    for (int col = 0; col < boxWidth; col++) {
                        Pixel pixelValue = currentBox.pixelbox[col][row];
                        int pixelRow = boxRow * boxHeight + row;
                        int pixelCol = boxCol * boxWidth + col;
                        pixels[pixelCol][pixelRow] = pixelValue;
                    }
                }
                }

                
            }
        }

        return pixels;
    }

}