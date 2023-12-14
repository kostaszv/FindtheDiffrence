package game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import java.awt.Color;
class Img implements Comparable{
    String path; 
    int width;
    int height;
    PixelBoxImg pxBoxes;
    Pixel [][] pixels;
    int id ;

    Img(String path){
        this.path = config.Assets + path ;
        
        cropImage();
        PNGtoArray();
        this.pxBoxes = createPixelBox();
    }

    Img(String path,int id){
        this.path = path;
        this.id = id ;
    }

    public int  get_Id(){
        return this.id;
    }

    public String get_path(){
        return this.path;
    }

    public int getPathLen(){
        return  this.path.length();
    }



    public void cropImage(){
        try {
            // Read the image
            BufferedImage originalImage = ImageIO.read(new File(path));
            if(originalImage.getWidth()>500 ||originalImage.getHeight()>500){
            // Resize the image
            BufferedImage resizedImage = resizeImage(originalImage, config.CROP_W, config.CROP_H);

            // Save the resized image
            ImageIO.write(resizedImage, "jpg", new File(path));

            System.out.println("Image resizing completed successfully.");
            this.width = resizedImage.getWidth();
            this.height = resizedImage.getHeight();
            }else{
                this.width = originalImage.getWidth();
                this.height = originalImage.getHeight();
            }
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    




    public void PNGtoArray(){
        try {
            // Read the PNG image file
            BufferedImage image1 = ImageIO.read(new File(path));
            ImageIO.write(image1, "png", new File(path));
            BufferedImage image = ImageIO.read(new File(path));
            // Get the width and height of the image
            int width = image.getWidth();
            int height = image.getHeight();

            // Create 2D arrays to store pixel values for each component (ARGB)
            pixels = new Pixel[width][height];
            // Loop through each pixel and store its components
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    // Get the RGB value of the pixel
                    int rgb = image.getRGB(j, i);

                    // Extract individual components
                    int alpha = (rgb >> 24);
                    int red = (rgb >> 16) ;
                    int green = (rgb >> 8) ;
                    int blue = rgb;

                    // Store the components in the arrays
                    pixels[i][j] = new Pixel(red, green, blue, alpha,j,i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

   


    public Boolean isDiffrent(Img image){

        int counter = 0 ;
        int counter2 =0; 
        
        // Compare pixel values
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                if (this.pixels[j][i].compareTo(image.pixels[j][i]))  {
                    counter++;       
                    
                }

                counter2++;
            }
        }
        System.out.println(counter2);
        System.out.println(counter);
        return false; // Images are identical
    
    }

    public boolean sameSize(Img image){
        if(image.height == this.height && image.width == this.width){
            return true;
        }
        return false;
    }

    public void DrawNewPic(){
        BufferedImage image = new BufferedImage(config.CROP_W, config.CROP_H, BufferedImage.TYPE_INT_RGB);
        pixels = this.pxBoxes.convertToPixelsArray();
        // Set RGB values for each pixel in the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(pixels[y][x].getBlue()== 255 ){
                    System.out.println();
                }

                int rgb = ((pixels[y][x] .getAlpha()<< 24 ))|((pixels[y][x].getRed()<<16))|((pixels[y][x].getGreen()<<8))|pixels[y][x].getBlue();
                image.setRGB(x, y, rgb);
            }
        }

        // Save the image to the specified output path
        try {
            File output = new File(path);
            ImageIO.write(image, "png", output); // You can change the format if needed (e.g., "jpg", "bmp", etc.)
            System.out.println("Image created successfully at: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        Image resultingImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(resultingImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    public  void addRedCircle( int centerX, int centerY, int radius) {
        
        try {
            // Read the PNG image file
            BufferedImage image = ImageIO.read(new File(path));
             for(int i =  0; i <500; i++){
                for(int k = 0 ; k <500; k++){
                int modifiedRgb = ((pixels[i][k] .getAlpha()<< 24 ))|((pixels[i][k].getRed()<<16))|((pixels[i][k].getGreen()<<8))|pixels[i][k].getBlue();
                 image.setRGB(k,i ,modifiedRgb);
                }
            }
            
             
            ImageIO.write(image, "png", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }   
        
    }

    public PixelBoxImg createPixelBox(){
         this.pxBoxes = new PixelBoxImg();
        this.pxBoxes.boxes = new PixelBox[100][100];
        int boxw =0 ;
        int boxh = 0 ;
        int pixi = 0 ;
        int pixk = 0 ;
        int changeboxw = 4;
        int changeboxh = 4;
        for(int i = 0 ;i<pixels.length;i++){
            for(int k = 0; k<pixels[0].length;k++){
                    if (this.pxBoxes.boxes[boxh][boxw] == null) {
                    this.pxBoxes.boxes[boxh][boxw] = new PixelBox(); // Initialize each PixelBox if not already initialized
                    }
                    this.pxBoxes.boxes[boxh][boxw].setPixelBox( pixels[k][i],pixi, pixk,boxw,boxh);
                    pixi++;
                    if(k == changeboxw){
                        boxw++;
                        pixi =0 ;
                        changeboxw+=5;
                    }
            }
            pixk++;
            changeboxw= 4;
            boxw=0;
            if(i==changeboxh){
                boxw=0;
                boxh++;
                pixk = 0;
                changeboxh+=5;
                changeboxw = 4;
            }
        }
        int gg = 0 ;
        return this.pxBoxes;       
    }

    @Override
    public int compareTo(Object o) {
        if(((Img)o).get_path().compareTo(this.path)>0){
            return 1 ;
        }else{
            return -1;
        }
    }

    


}