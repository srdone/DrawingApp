package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends ClosedShape {
  
  public Rectangle() {
    super();
  }
  
  public Rectangle(int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
    super(x1,y1,x2,y2,lineColor,fillColor,filled);
  }
  
  public void draw(Graphics g) {
    Color oldColor = g.getColor();
    if (isFilled()) {
      g.setColor(getFillColor());
      g.fillRect(getX1(), getY1(), getWidth(), getHeight());
    }
    g.setColor(getLineColor());
    g.drawRect(getX1(), getY1(), getWidth(), getHeight());
    g.setColor(oldColor);
  }
  
  public String toString() {
    return "Rectangle: \n\tx = " + getX1() + "\n\ty = " + getY1() + 
        "\n\tw = " + getWidth() + "\n\th = " + getHeight() + 
        "\n\tlc = " + getLineColor() + "\n\tfc = " + getFillColor();
  }

}
