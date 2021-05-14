public class Kernel {
   float[][] kernel;
   
   public Kernel(float[][] init) {
     kernel = init;
   }
   
   color calcNewColor(PImage img, int x, int y) {
     float redResult = 0;;
     float blueResult = 0;
     float greenResult = 0;
     for(int i = -1; i < 2; i++) {
       for(int j = -1; j < 2; j++) {
         int x1 = x + i;
         int y1 = y + j;
         color c = img.get(x1,y1);
         float r = red (c);
         float g = green(c);
         float b = blue (c);
         redResult = redResult + r * kernel[i + 1][j + 1];
         blueResult = blueResult + b * kernel[i + 1][j + 1];
         greenResult = greenResult + g * kernel[i + 1][j + 1];
       }
     }
     return color(redResult, blueResult, greenResult);
   }  
   
   void apply (PImage source, PImage destination) {
     for(int x = 0; x < source.width; x++) {
       for(int y = 0; y < source.height; y++) {
         destination.set(x, y, calcNewColor(source, x, y));
       }
     }
   }
}
