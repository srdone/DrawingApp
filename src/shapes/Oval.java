package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends ClosedShape {
  
  public Oval() {
    super();
  }
  
  public Oval(int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
    super(x1,y1,x2,y2,lineColor,fillColor,filled);
  }
  
  public void draw(Graphics g) {
    Color oldColor = g.getColor();
    if (isFilled()) {
      g.setColor(getFillColor());
      g.fillOval(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), getWidth(), getHeight());
    }
    g.setColor(getLineColor());
    g.drawOval(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), getWidth(), getHeight());
    g.setColor(oldColor);
  }
  
  public String toString() {
    return "Oval: \n\tx = " + getX1() + "\n\ty = " + getY1() + 
        "\n\tx2 = " + getX2() + "\n\ty2 = " + getY2() +
        "\n\tw = " + getWidth() + "\n\th = " + getHeight();
  }

}
