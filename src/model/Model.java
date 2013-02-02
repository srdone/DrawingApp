package model;

//Left off on "We create the currentShape variable to hold a reference"

import java.awt.Color;
import shapes.*;

import java.awt.Container;

import enums.Colors;
import enums.ShapeType;
import interfaces.ComparableShape;
import interfaces.Resettable;

public class Model implements Resettable {
  private Container container;
  public final static String DRAW = "Draw";
  public final static String MOVE = "Move";
  public final static String REMOVE = "Remove";
  public final static String RESIZE = "Resize";
  public final static String CHANGE = "Change";
  public final static String FILL = "Fill";
  
  public final static String TWO_BIGGER_THAN_ONE = "Shape 2 is bigger than Shape 1";
  public final static String TWO_SAME_AS_ONE = "Shape 2 is the same size as Shape 1";
  public final static String TWO_SMALLER_THAN_ONE = "Shape 2 is smaller than Shape 1";
  public final static String NOT_COMPARABLE = "One or more shapes doesn't have an area";
  
  public final static ShapeType[] SHAPE_CHOICES = ShapeType.values();
  public final static Colors[] COLOR_CHOICES = Colors.values();
  
  public final static int MAIN_WINDOW_SIZE_X = 600;
  public final static int MAIN_WINDOW_SIZE_Y = 400;
  
  public final static int DEFAULT_WIDTH = 50;
  public final static int DEFAULT_HEIGHT = 50;
  
  public final static String DEFAULT_COLOR = "Red";
  
  private String action = DRAW;
  private boolean fill = false;
  private ShapeType currentShapeType = ShapeType.RECTANGLE;
  private Shape currentShape;
  private Color lineColor = Color.RED;
  private Color fillColor = Color.RED;
  private Shape[] shapeArray = new Shape[2];
  
  public Shape createShape() {
	  //if there is a shape in the second position (position 1), then we have a full array and need to reset it.
	  if (shapeArray[1] != null) {shapeArray = new Shape[2];}; 
	  switch(currentShapeType) {
	  case RECTANGLE: currentShape = new Rectangle(); break;
	  case OVAL: currentShape = new Oval(); break;
	  case LINE: currentShape = new Line(); break;
	  default: currentShape = null; break;
	  }
	  //if there is no shape in slot 0, put the new shape there. Otherwise, put it in slot 1.
	  if(shapeArray[0] == null) {shapeArray[0] = currentShape;} else {shapeArray[1] = currentShape;}
	  return currentShape;
  }
  
  public int compareShapes() {
	  //if then else to return -1 (0 less than 1); 0 (same size) 1 (0 larger than 1), 3 if not comparable
	  if(shapeArray[0] instanceof ComparableShape && shapeArray[1] instanceof ComparableShape) {
	  if (((ComparableShape) shapeArray[0]).getArea() < ((ComparableShape) shapeArray[1]).getArea()) {return -1;} 
	  else if (((ComparableShape) shapeArray[0]).getArea() == ((ComparableShape) shapeArray[1]).getArea()) {return 0;}
	  else if (((ComparableShape) shapeArray[0]).getArea() > ((ComparableShape) shapeArray[1]).getArea()) {return 1;}
	  //TODO Display result somewhere
	  }
	  return 3;
  }
  
  public Model (Container container) {
    this.container = container;
  }
  
  public void repaint() {
    container.repaint();
  }
  
  public void resetComponents() {
    action = DRAW;
    fill = false;
    currentShapeType = ShapeType.RECTANGLE;
    currentShape = null;
    lineColor = Color.RED;
    fillColor = Color.RED;
    if(container instanceof Resettable) {
      ((Resettable)container).resetComponents();
    }
  }
  
  public String getAction() {
    return action;
  }
  
  public ShapeType getCurrentShapeType() {
    return currentShapeType;
  }
  
  public Shape getCurrentShape() {
    return currentShape;
  }
  
  public Shape[] getShapeArray() {
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
  
  public void setAction(String action) {
    this.action = action;
  }
  
  public void setCurrentShapeType(ShapeType shapeType) {
    this.currentShapeType = shapeType;
  }
  
  public void setCurrentShape(Shape shape) {
    this.currentShape = shape;
  }
  
  public void setFillColor(Color fillColor) {
	  this.fillColor = fillColor;
  }
  
  public void setLineColor(Color lineColor) {
	  this.lineColor = lineColor;
  }
  
  
  public String toString() {
    return "Model:\n\tAction: " + action + "\n\tShape: " + currentShapeType + "\n\tFill: " + fill 
    		+ "\n\tLine Color: " + lineColor + "\n\tFill Color: " + fillColor;
  }

}
