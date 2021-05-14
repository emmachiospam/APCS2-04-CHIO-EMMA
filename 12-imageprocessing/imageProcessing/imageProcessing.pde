void setup(){
  size(1450,500);
  PImage car = loadImage("redcar.jpg");
  PImage output = car.copy();
  Kernel k = new Kernel( new float[][]    { {-1, -1, -1},
     {-1, 8, -1},
   {-1, -1, -1} } );
  k.apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
