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
		switch(model.getAction()) {
		case DRAW: drawPress(e); break;
		case REMOVE: remove(e); break;
		case CHANGE: change(e); break;
		default: break;
		}
	}

	/*
	 * Overrides MouseAdapter's mouseDragged method and determines what to do based on the selected action.
	 */
	public void mouseDragged(MouseEvent e) {
		//get the current shape handled by the model
		//if there is a current shape in the model:
		//if we are in DRAW mode.
		switch (model.getAction()) {
		case DRAW: drawDragged(e); break;
		case MOVE: move(e); break;
		case RESIZE: resize(e); break;
		default: break;
		}
		model.repaint();
	}

	/*
	 * Draws the currentShape where the mouse is pressed. Has a predefined size.
	 */
	private void drawPress(MouseEvent e) {
		//original upper left x and y of the shape.
		setFirstAnchorPoint(e);
		//have the model create a new shape
		shape = model.createShape();
		//if the shape was created.
		System.out.println(shape);
		if (shape != null) {
			setInitialSpatialDimensions();
			shape.setLineColor(model.getLineColor());
			if(shape instanceof ClosedShape) {
				setFill((ClosedShape)shape);
			}
			System.out.println(shape);
		}
		//tell the model to repaint the applet or application.
		model.repaint();
	}
	
	private void setFirstAnchorPoint(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}
	
	private void setInitialSpatialDimensions() {
		//set its upper left x and y to where the mouse was pressed.
		shape.setX1(startX);
		shape.setY1(startY);
		shape.setX2(startX + Model.DEFAULT_WIDTH);
		shape.setY2(startY + Model.DEFAULT_HEIGHT);
	}
	
	private void setFill(ClosedShape shape) {
		((ClosedShape)shape).setFillColor(model.getFillColor());
		((ClosedShape)shape).setFilled(model.isFill());
	}

	/*
	 * Removes the shape under the mouse from the canvas.
	 */
	private void remove(MouseEvent e) {
		System.out.println("Remove");
		System.out.println(model.getShapeArray().remove(model.getShapeAt(e.getX(), e.getY())));
		model.getShapeArray().trimToSize();
		model.repaint();
	}

	/*
	 * Takes the settings for fill, fill color, and line color and applies them to the shape under the mouse.
	 */
	private void change(MouseEvent e) {
		//Change line color, fill color, and fill status to current values on panel
		Shape shape = model.getShapeAt(e.getX(), e.getY());
		shape.setLineColor(model.getLineColor());
		//Check to see if it is a closed shape - if it is, change the fill attributes
		if(shape instanceof ClosedShape) {
			setFill((ClosedShape)shape);
		}
		model.repaint();
	}



	/*
	 * Draws the current shape as the mouse is dragged across the screen.
	 */
	private void drawDragged(MouseEvent e) {
		shape = model.getCurrentShape();
		if(shape != null) {
			setFirstAnchorPoint(e);
			System.out.println(shape);
			setSecondAnchorPoint(e);
			System.out.println(shape);
		}
	}

	/*
	 * Moves the shape under the mouse from where it is to a new point. It is translated on the same vector as the mouse movement.
	 */
	private void move(MouseEvent e) {
		//Move the shape under the mouse according in the same directions and amounts as the mouse is dragged.
		if(shape == null) shape = model.getShapeAt(e.getX(), e.getY());
		if(shape != null) {
			setMovements(getDifference(e));
			System.out.println(shape);
		}
	}
	
	private int[] getDifference(MouseEvent e) {
		int initialX1 = shape.getX1();
		int initialY1 = shape.getY1();
		int differenceX = e.getX() - initialX1;
		int differenceY = e.getY() - initialY1;
		int[] differenceValues = {differenceX, differenceY};
		return differenceValues;
	}
	
	private void setMovements(int[] differenceValues) {
		shape.setX1(shape.getX1() + differenceValues[0]);
		shape.setY1(shape.getY1() + differenceValues[1]);
		shape.setX2(shape.getX2() + differenceValues[0]);
		shape.setY2(shape.getY2() + differenceValues[1]);
	}

	/*
	 * Resizes the shape under the mouse, moving X2 and Y2 to the new point given by the MouseEvent e.
	 */
	private void resize(MouseEvent e) {
		//Rezize
		if(shape == null) shape = model.getShapeAt(e.getX(), e.getY());
		if(shape != null) {
			System.out.println(shape);
			//change the position of one corner, thereby stretching the shape.
			setSecondAnchorPoint(e);
			System.out.println(shape);
		}
	}
	
	public void setSecondAnchorPoint(MouseEvent e) {
		shape.setX2(e.getX());
		shape.setY2(e.getY());
	}

	public void mouseReleased(MouseEvent e) {
		shape = null;
	}

}
