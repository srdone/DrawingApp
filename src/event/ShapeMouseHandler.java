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
    } else if (model.getAction() == Model.REMOVE) {
    	System.out.println("Remove");
    	System.out.println(model.getShapeArray().remove(model.getShapeAt(e.getX(), e.getY())));
    	model.getShapeArray().trimToSize();
    	model.repaint();
    } else if (model.getAction() == Model.CHANGE) {
    	//Change line color, fill color, and fill status to current values on panel
    	Shape shape = model.getShapeAt(e.getX(), e.getY());
    	shape.setLineColor(model.getLineColor());
    	//Check to see if it is a closed shape - if it is, change the fill attributes
    	if(shape instanceof ClosedShape) {
    		((ClosedShape)shape).setFilled(model.isFill());
    		((ClosedShape)shape).setFillColor(model.getFillColor());
    	}
    	model.repaint();
    } 
  }
  
  /*
   * Overrides MouseAdapter's mouseDragged method.
   */
  public void mouseDragged(MouseEvent e) {
	  //get the current shape handled by the model
	  //if there is a current shape in the model:
		  //if we are in DRAW mode.
		  if (model.getAction() == Model.DRAW) {
			  shape = model.getCurrentShape();
			  if(shape != null) {
				  shape.setX1(startX);
				  shape.setY1(startY);
				  System.out.println(shape);
				  shape.setX2(e.getX());
				  shape.setY2(e.getY());
				  System.out.println(shape);
			  }
		  } else if (model.getAction() == Model.MOVE)  {
			  //Move the shape under the mouse according in the same directions and amounts as the mouse is dragged.
			  if(shape == null) shape = model.getShapeAt(e.getX(), e.getY());
			  if(shape != null) {
				  int initialX1 = shape.getX1();
				  int initialY1 = shape.getY1();
				  int differenceX = e.getX() - initialX1;
				  int differenceY = e.getY() - initialY1;
				  shape.setX1(shape.getX1() + differenceX);
				  shape.setY1(shape.getY1() + differenceY);
				  shape.setX2(shape.getX2() + differenceX);
				  shape.setY2(shape.getY2() + differenceY);
				  System.out.println(shape);
			  }
		  } else if (model.getAction() == Model.RESIZE) {
			  //Rezize
			  if(shape == null) shape = model.getShapeAt(e.getX(), e.getY());
			  if(shape != null) {
				  System.out.println(shape);
				  //change the position of one corner, thereby stretching the shape.
				  shape.setX2(e.getX());
				  shape.setY2(e.getY());
				  System.out.println(shape);
			  }
		  }
	  // tell the model to repaint the applet or application
	  model.repaint();
  }
  
  public void mouseReleased(MouseEvent e) {
	  shape = null;
  }

}
