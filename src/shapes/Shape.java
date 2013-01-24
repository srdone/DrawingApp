package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;

public abstract class Shape {
  private int x1 = 10, y1 = 10, x2 = 20, y2 = 20;
  private Color lineColor = Color.BLUE;

  //Strings for testing against in the change() method.
  //Each variable has a corresponding string
  private static final String strX1 = "x1", strX2 = "x2", strY1 = "y1", strY2 = "y2", strLineColor = "lineColor";
  
  public Shape() {
    
  }
  
  public Shape(int x1, int y1, int x2, int y2, Color lineColor) {
    this.x1 = x1;
    this.y1 = y1;
    this.lineColor = lineColor;
  }
  
  public abstract void draw(Graphics g);
  
  public abstract boolean containsLocation(int x, int y);
  
  public abstract void move(int x1, int y1);
  
  public abstract void resize(int x1, int y1, int x2, int y2);
  
  //Takes pairs of strings - the first one is the value that should be changed, the second is the new value.
  //The method interprets what has to be done by matching strings to pre-determined strings.
  public void change(String[][] toChange) {
    
  }
  
  //Removes the shape from the area where displayed
  public void remove() {
    
  }
  
  public int getX1() {
    return x1;
  }
  
  public int getY2() {
    return y2;
  }
  
  public int getX2() {
    return x2;
  }
  
  public int getY1() {
    return y1;
  }
  
  public Color getLineColor() {
    return lineColor;
  }
  
  public int getWidth() {
    return Math.abs(getX2() - getX1());
  }
  
  public int getHeight() {
    return Math.abs(getY2() - getY1());
  }
  
  public void setX1(int x1) {
    this.x1 = x1;
  }
  
  public void setY1(int y1) {
    this.y1 = y1;
  }
  
  public void setX2(int x2) {
    this.x2 = x2;
  }
  
  public void setY2(int y2) {
    this.y2 = y2;
  }
  
  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }
  
  public void setWidth(int width) {
    setX2(getX1() + width);
  }
  
  public void setHeight(int height) {
    setY2(getY1() + height);
  }
  
  public String toString() {
    return "x1 = " + x1 + "y1 = " + y1;
  }

}

//Need to put width into shapeMouseHandler
