package model;

//Left off on "We create the currentShape variable to hold a reference"

import java.awt.Color;
import shapes.*;
import java.awt.Container;

import enums.ShapeType;
import interfaces.Resettable;

public class Model implements Resettable {
  private Container container;
  public final static String DRAW = "Draw";
  public final static String MOVE = "Move";
  public final static String REMOVE = "Remove";
  public final static String RESIZE = "Resize";
  public final static String CHANGE = "Change";
  public final static String FILL = "Fill";
  
  public final static ShapeType[] SHAPE_CHOICES = ShapeType.values();
  
  public final static int MAIN_WINDOW_SIZE_X = 600;
  public final static int MAIN_WINDOW_SIZE_Y = 400;
  
  public final static int DEFAULT_WIDTH = 50;
  public final static int DEFAULT_HEIGHT = 50;
  
  private String action = DRAW;
  private boolean fill = false;
  private ShapeType currentShapeType = ShapeType.RECTANGLE;
  private Shape currentShape;
  
  public Shape createShape() {
    switch(currentShapeType) {
    case RECTANGLE: currentShape = new Rectangle(); break;
    case OVAL: currentShape = new Oval(); break;
    case LINE: currentShape = new Line(); break;
    default: currentShape = null; break;
    }
    return currentShape;
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
  
  public boolean isFill() {
    return fill;
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
  
  public String toString() {
    return "Model:\n\tAction: " + action + "\n\tShape: " + currentShapeType + "\n\tFill: " + fill;
  }

}
