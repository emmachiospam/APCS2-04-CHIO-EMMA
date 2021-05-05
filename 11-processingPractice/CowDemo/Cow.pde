public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (colliding && selected) {
      x += dx;
      y += dy;
    }
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    stroke(0);
    if(colliding) {
      fill(255,0,0,63);
    }
    else {
      fill(c);
    }
    ellipse(x, y, radius*2, radius*2);
    if(selected) {
      fill(255);
      ellipse(x + radius/4, y+radius/12, 5, 5);
      ellipse(x - radius/4, y+radius/12, 5, 5);
      stroke(0);
      noFill();
      arc(x, y+radius/3 , 10, 5, 0, PI);
      text(dx, x + radius, y);
      text(dy, x + radius, y + radius);
    }
    
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
    if(dist(mouseX, mouseY, x, y) <= radius) {
      selected = !selected;
    }
  }
 
  
  void collide(ArrayList<Cow> others) {
    colliding = false;
      for(int i = 0; i < others.size(); i++) {
        Cow temp = others.get(i);
        if(temp == this) {
           continue;
        }
        if (dist(temp.x, temp.y, x, y) <= radius + temp.radius) {
           colliding = true;
        }
      }
  }
  

}
