package shapes;

import java.awt.Color;

import interfaces.*;

public abstract class ClosedShape extends Shape implements Fillable {
  private boolean filled = false;
  private Color fillColor = Color.RED;

  public static final String strFilled = "filled", strFillColor = "fillColor";
  
  public ClosedShape() {
    super();
  }
  
  public ClosedShape (int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
    super(x1,y1,x2,y2,lineColor);
    this.setFillColor(fillColor);
    this.setFilled(filled);
  }
  
  public void change(String[][] toChange) {
    //specialized code to set fill parameters
  }
  
  public void resize(int x1, int y1, int x2, int y2) {
    
  }
  
  public void move(int x1, int y1) {
    
  }
  
  public boolean containsLocation(int x, int y) {
    if (getX1() <= x && getY1() <= y && getX2() >= x && getY2() >=y  ) {
      return true;
    }
    return false;
  }
  
  public boolean isFilled() {
    return filled;
  }
  
  public Color getFillColor() {
    return fillColor;
  }
  
  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }
  
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  
  
}
