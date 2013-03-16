package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Rectangle class for drawing triangles
 * @author Stephen
 *
 */
public class Triangle extends ClosedShape {
	private int[] xPoints = new int[3];
	private int[] yPoints = new int[3];
	private static final int numPoints = 3;
	
	/*
	 * Empty constructor to allow for quick triangle creation
	 */
	public Triangle() {
		super();
	}

	/**
	 * Constructor for a triangle that allows setting of all relevant variables
	 * X and Y coordinates are merely used as reference points to draw a triangle with height equal
	 * to the Y vertical difference and width equal to the X vertical difference.
	 * @param x1 X value for first coordinate
	 * @param y1 Y value for first coordinate
	 * @param x2 X value for second coordinate
	 * @param y2 Y value for second coordinate
	 * @param lineColor Color for the shape's line
	 * @param fillColor Color to fill the shape
	 * @param filled Whether the shape is filled or not
	 */
	public Triangle(int x1, int y1, int x2, int y2, Color lineColor, Color fillColor, boolean filled) {
		super(x1,y1,x2,y2,lineColor,fillColor,filled);
	}

	/*
	 * Draw code specific to the Triangle
	 * (non-Javadoc)
	 * @see shapes.Shape#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		calculateTriangleCoordinates();
		Color oldColor = g.getColor();
		if (isFilled()) {
			drawFilledTriangle(g);
		}
		drawEmptyTriangle(g);
		g.setColor(oldColor);
	}
	
	/*
	 * Calculates the x,y coordinates for the three points on the triangle
	 */
	private void calculateTriangleCoordinates() {
		//find bottom corner
		int leftCornerX = Math.max(getX1(), getX2());
		int leftCornerY = Math.max(getY1(), getY2());
		//bottom left vertex
		xPoints[0] = leftCornerX;
		yPoints[0] = leftCornerY;
		//bottom right vertex
		xPoints[1] = leftCornerX - getWidth();
		yPoints[1] = leftCornerY;
		//top vertex
		xPoints[2] = leftCornerX - getWidth()/2;
		yPoints[2] = leftCornerY - getHeight();
	}

	/*
	 * Draw a filled triangle.
	 * Pre-condition: The Rectangle must be a filled rectangle.
	 */
	private void drawFilledTriangle(Graphics g) {
		g.setColor(getFillColor());
		g.fillPolygon(xPoints, yPoints, numPoints);
	}

	/*
	 * Draw an empty triangle.
	 * This draws on top of a filled rectangle if the Rectangle object is filled.
	 */
	private void drawEmptyTriangle(Graphics g) {
		g.setColor(getLineColor());
		g.drawPolygon(xPoints, yPoints, numPoints);
	}

	/*
	 * The string value of the Triangle object.
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
