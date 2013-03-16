package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Oval class for drawing ovals
 * @author Stephen
 *
 */
public class Oval extends ClosedShape {

	/*
	 * Empty constructor to allow for quick oval creation
	 */
	public Oval() {
		super();
	}

	/**
	 * Constructor for a oval that allows setting of all relevant variables
	 * @param x1 X value for first coordinate
	 * @param y1 Y value for first coordinate
	 * @param x2 X value for second coordinate
	 * @param y2 Y value for second coordinate
	 * @param lineColor Color for the shape's line
	 * @param fillColor Color to fill the shape
	 * @param filled Whether the shape is filled or not
	 */
	public Oval(int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
		super(x1,y1,x2,y2,lineColor,fillColor,filled);
	}

	/*
	 * Draw code specific to the Oval
	 * (non-Javadoc)
	 * @see shapes.Shape#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		if (isFilled()) {
			drawFilledOval(g);
		}
		drawEmptyOval(g);
		g.setColor(oldColor);
	}

	/*
	 * Draw a filled oval.
	 * Pre-condition: The Oval must be a filled rectangle.
	 */
	private void drawFilledOval(Graphics g) {
		g.setColor(getFillColor());
		g.fillOval(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), getWidth(), getHeight());
	}

	/*
	 * Draw an empty oval.
	 * This draws on top of a filled rectangle if the Oval object is filled.
	 */
	private void drawEmptyOval(Graphics g) {
		g.setColor(getLineColor());
		g.drawOval(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), getWidth(), getHeight());
	}

	/*
	 * Return the area of the Oval object
	 * (non-Javadoc)
	 * @see shapes.ClosedShape#getArea()
	 */
	public double getArea() {
		double width = Math.abs(getX1() - getX2());
		double height = Math.abs(getY1() - getY2());
		return (width * height * .8);
	}

	/*
	 * The string value of the Oval object.
	 * (non-Javadoc)
	 * @see shapes.Shape#toString()
	 */
	public String toString() {
		return "Oval: \n\tx = " + getX1() + "\n\ty = " + getY1() + 
				"\n\tx2 = " + getX2() + "\n\ty2 = " + getY2() +
				"\n\tw = " + getWidth() + "\n\th = " + getHeight();
	}

}
