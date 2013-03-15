package shapes;

import java.awt.Color;

import interfaces.*;

public abstract class ClosedShape extends Shape implements Fillable, ComparableShape {
  private boolean filled = false;
  private Color fillColor = Color.BLACK;
  
  /*
	 * Empty constructor to allow for quick ClosedShape creation
	 */
  public ClosedShape() {
    super();
  }
  
  /**
	 * Constructor for a ClosedShape object that allows setting of all relevant variables
	 * @param x1 X value for first coordinate
	 * @param y1 Y value for first coordinate
	 * @param x2 X value for second coordinate
	 * @param y2 Y value for second coordinate
	 * @param lineColor Color for the shape's line
	 * @param fillColor Color to fill the shape
	 * @param filled Whether the shape is filled or not
	 */
  public ClosedShape (int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
	    super(x1,y1,x2,y2,lineColor);
	    this.setFillColor(fillColor);
	    this.setFilled(filled);
	  }
  
  /*
	 * Return the rectangular area of the ClosedShape object
	 * (non-Javadoc)
	 * @see shapes.ClosedShape#getArea()
	 */
  public double getArea() {
	  double width = Math.abs(getX1() - getX2());
	  double height = Math.abs(getY1() - getY2());
	  return (width * height);
  }
  
  public boolean isFilled() {
    return filled;
  }
  
  public Color getFillColor() {
    return fillColor;
  }
  
  public int getWidth() {
    return Math.abs(getX2() - getX1());
  }
  
  public int getHeight() {
    return Math.abs(getY2() - getY1());
  }
  
  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }
  
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  
  public void setWidth(int width) {
    setX2(getX1() + width);
  }
  
  public void setHeight(int height) {
    setY2(getY1() + height);
  }
  
  
}
