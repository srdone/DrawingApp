package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.ClosedShape;
import shapes.Rectangle;
import shapes.Shape;

public class ShapeMouseHandler extends MouseAdapter{
  private Model model;
  private int startX;
  private int startY;
  private Shape shape;
  
  /**
   * Constructor. Sets the model for this listener.
   * 
   * @param model
   */
  public ShapeMouseHandler(Model model) {
    //persist local variable model to this.model
    this.model = model;
  }
  
  /*
   * Overrides MouseAdapter mousePressed method.
   */
  public void mousePressed(MouseEvent e) {
    if (model.getAction() == Model.DRAW) {
      //original upper left x and y of the shape.
      startX = e.getX();
      startY = e.getY();
      //have the model create a new shape for us
      shape = model.createShape();
      //if the shape was created.
      System.out.println(shape);
      if (shape != null) {
        //set its upper left x and y to where the mouse was pressed.
        shape.setX1(startX);
        shape.setY1(startY);
        shape.setX2(startX + Model.DEFAULT_WIDTH);
        shape.setY2(startY + Model.DEFAULT_HEIGHT);
        shape.setLineColor(model.getLineColor());
        if(shape instanceof ClosedShape) {
        	((ClosedShape)shape).setFillColor(model.getFillColor());
        	((ClosedShape)shape).setFilled(model.isFill());
        }
        System.out.println(shape);
      }
      //tell the model to repaint the applet or application.
      model.repaint();
    }
  }
  
  /*
   * Overrides MouseAdapter's mouseDragged method.
   */
  public void mouseDragged(MouseEvent e) {
    //get the current shape handled by the model
    shape = model.getCurrentShape();
    //if there is a current shape in the model:
    if (shape != null) {
      //if we are in DRAW mode.
      if (model.getAction() == Model.DRAW) {
        shape.setX1(startX);
        shape.setY1(startY);
        System.out.println(shape);
      }
      shape.setX2(e.getX());
      shape.setY2(e.getY());
      System.out.println(shape);
    }
    // tell the model to repaint the applet or application
    model.repaint();
  }

}
