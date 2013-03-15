package model;

//Left off on "We create the currentShape variable to hold a reference"

import java.awt.Color;
import shapes.*;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import enums.Colors;
import enums.ShapeType;
import enums.Actions;
import interfaces.ComparableShape;
import interfaces.Resettable;

/**
 * A model to keep track of the state of the applet.
 * @author Stephen
 *
 */
public class Model implements Resettable {
	private Container container;

	//Strings for comparison
	public final static String TWO_BIGGER_THAN_ONE = "Shape 2 is bigger than Shape 1";
	public final static String TWO_SAME_AS_ONE = "Shape 2 is the same size as Shape 1";
	public final static String TWO_SMALLER_THAN_ONE = "Shape 2 is smaller than Shape 1";
	public final static String NOT_COMPARABLE = "One or more shapes doesn't have an area";

	//Window size dimensions for the main window
	public final static int MAIN_WINDOW_SIZE_X = 600;
	public final static int MAIN_WINDOW_SIZE_Y = 400;

	//Default width and height of a shape
	public final static int DEFAULT_WIDTH = 50;
	public final static int DEFAULT_HEIGHT = 50;

	//Default color for the shape line color and fill color
	public final static String DEFAULT_COLOR = "Red";

	//Variable for tracking the state of the model
	private Actions action = Actions.DRAW;
	private boolean fill = false;
	private ShapeType currentShapeType = ShapeType.RECTANGLE;
	private Shape currentShape;
	private Color lineColor = Color.RED;
	private Color fillColor = Color.RED;
	private ArrayList<Shape> shapeArray = new ArrayList<Shape>();

	//Create a shape object matching the currentShapeType
	public Shape createShape() { 
		//Determine the shape to create and create the object
		switch(currentShapeType) {
		case RECTANGLE: currentShape = new Rectangle(); break;
		case OVAL: currentShape = new Oval(); break;
		case LINE: currentShape = new Line(); break;
		default: currentShape = null; break;
		}
		//Add the shape to the end of the shape array
		shapeArray.add(shapeArray.size(), currentShape);
		printShapeArrayStatus();
		return currentShape;
	}

	/*
	 * This method writes the list of objects in the array to the console
	 */
	private void printShapeArrayStatus() {
		for(Shape shape : shapeArray) {
			System.out.println("Element " + (shapeArray.indexOf(shape) + 1) + " is a " + shape.toString().substring(0,shape.toString().indexOf(":")));
		}
	}

	/**
	 * This method takes an x and y coordinate (point) and returns the most recently drawn shape that contains the point.
	 * @param x x coordinate of point
	 * @param y y coordinate of point
	 * @return Shape containing the (x,y) point. If there is more than one shape, returns the most recently drawn shape
	 */
	public Shape getShapeAt(int x, int y) {
		ListIterator<Shape> itr = shapeArray.listIterator(shapeArray.size());
		while(itr.hasPrevious()) {
			Shape shape = itr.previous();
			if(shape.containsLocation(x,y)) return shape;
		}
		System.out.println("NULL SHAPE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return null;
	}

	//Sets the container for the model
	public Model (Container container) {
		this.container = container;
	}

	//Tells the container to repaint
	public void repaint() {
		container.repaint();
	}

	/*
	 * Reset the state values of the model and then send the reset command to the container
	 * (non-Javadoc)
	 * @see interfaces.Resettable#resetComponents()
	 */
	public void resetComponents() {
		setDefaultValues();
		if(container instanceof Resettable) {
			((Resettable)container).resetComponents();
		}
	}

	/*
	 * Sets the state values of the model to their defaults.
	 */
	private void setDefaultValues() {
		action = Actions.DRAW;
		fill = false;
		currentShapeType = ShapeType.RECTANGLE;
		currentShape = null;
		shapeArray = new ArrayList<Shape>();				//Clear all shapes from screen
		lineColor = Color.RED;
		fillColor = Color.RED;
	}

	public Actions getAction() {
		return action;
	}

	public ShapeType getCurrentShapeType() {
		return currentShapeType;
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public ArrayList<Shape> getShapeArray() {
		return shapeArray;
	}

	public boolean isFill() {
		return fill;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public void setCurrentShapeType(ShapeType shapeType) {
		this.currentShapeType = shapeType;
	}

	public void setCurrentShape(Shape shape) {
		this.currentShape = shape;
	}

	public void setFillColor(Colors fillColor) {
		this.fillColor = fillColor.getColor();
	}

	public void setLineColor(Colors lineColor) {
		this.lineColor = lineColor.getColor();
	}

	/*
	 * A string value of the current state of the model
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Model:\n\tAction: " + action + "\n\tShape: " + currentShapeType + "\n\tFill: " + fill 
				+ "\n\tLine Color: " + lineColor + "\n\tFill Color: " + fillColor;
	}

}
