package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Rectangle class for drawing rectangles
 * @author Stephen
 *
 */
public class Rectangle extends ClosedShape {

	/*
	 * Empty constructor to allow for quick rectangle creation
	 */
	public Rectangle() {
		super();
	}

	/**
	 * Constructor for a rectangle that allows setting of all relevant variables
	 * @param x1 X value for first coordinate
	 * @param y1 Y value for first coordinate
	 * @param x2 X value for second coordinate
	 * @param y2 Y value for second coordinate
	 * @param lineColor Color for the shape's line
	 * @param fillColor Color to fill the shape
	 * @param filled Whether the shape is filled or not
	 */
	public Rectangle(int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
		super(x1,y1,x2,y2,lineColor,fillColor,filled);
	}

	/*
	 * Draw code specific to the Rectangle
	 * (non-Javadoc)
	 * @see shapes.Shape#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		if (isFilled()) {
			drawFilledRect(g);
		}
		drawEmptyRect(g);
		g.setColor(oldColor);
	}

	/*
	 * Draw a filled rectangle.
	 * Pre-condition: The Rectangle must be a filled rectangle.
	 */
	private void drawFilledRect(Graphics g) {
		g.setColor(getFillColor());
		g.fillRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), getWidth(), getHeight());
	}

	/*
	 * Draw an empty rectangle.
	 * This draws on top of a filled rectangle if the Rectangle object is filled.
	 */
	private void drawEmptyRect(Graphics g) {
		g.setColor(getLineColor());
		g.drawRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), getWidth(), getHeight());
	}

	/*
	 * The string value of the Rectangle object.
	 * (non-Javadoc)
	 * @see shapes.Shape#toString()
	 */
	public String toString() {
		return "Rectangle: \n\tx = " + getX1() + "\n\ty = " + getY1() +
				"\n\tx2 = " + getX2() + "\n\ty2 = " + getY2() +
				"\n\tw = " + getWidth() + "\n\th = " + getHeight() + 
				"\n\tlc = " + getLineColor() + "\n\tfc = " + getFillColor();
	}


}
