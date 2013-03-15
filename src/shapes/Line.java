package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends OpenShape {

	/*
	 * Draw code specific to the Line object.
	 * Draws a line from (X1, Y1) to (X2, Y2)
	 * (non-Javadoc)
	 * @see shapes.Shape#draw(java.awt.Graphics)
	 */
  @Override
  public void draw(Graphics g) {
    Color oldColor = g.getColor();
    g.setColor(getLineColor());
    g.drawLine(getX1(), getY1(), getX2(), getY2());
    g.setColor(oldColor);
  }
  
  /*
	 * The string value of the Line object.
	 * (non-Javadoc)
	 * @see shapes.Shape#toString()
	 */
  public String toString() {
    return "Line: \n\tx1 = " + getX1() + "\n\ty1 = " + getY1() + 
        "\n\tx2 = " + getX2() + "\n\ty2 = " + getY2();
  }


}
