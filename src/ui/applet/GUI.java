package ui.applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

import model.Model;
import ui.panels.MainPanel;
import interfaces.ComparableShape;
import interfaces.Resettable;

import event.ShapeMouseHandler;

import shapes.Shape;

public class GUI extends Applet implements Resettable {
  MainPanel mainPanel;
  Model model;
  ArrayList<Shape> shapesToDraw;
  
  public void init() {
    resize(Model.MAIN_WINDOW_SIZE_X, Model.MAIN_WINDOW_SIZE_Y);
    model = new Model(this);                                        //Create new instance of a model, and give the GUI as the container
    mainPanel = new MainPanel(model);                               //Create a new MainPanel and give it the model
    add(mainPanel);                                                 //Add the mainpanel to the screen
    ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);  //Create a new instance of ShapeMouseHandler and give it the model
    addMouseListener(mouseHandler);                                 //Add a mouseListener to the GUI so the mouseHandler receives events from it.
    addMouseMotionListener(mouseHandler);                           //Same as above, but a mouseMotionListener
  }
  
  public void paint(Graphics g) {
	  shapesToDraw = model.getShapeArray();
	  for(Shape shape : shapesToDraw) {
		  if(shape != null) {
			  shape.draw(g);								//draw shape at index i
			  g.drawString("Shape " + (shapesToDraw.indexOf(shape) + 1), shape.getX1(), shape.getY1());		//Draw labels on each shape
		  }
		  //make sure both shapes are comparable, then do the compare. Currently commented out as we don't have a way to choose ones to compare
//		  if(shapeToDraw instanceof ComparableShape && shapesToDraw[1] != null && shapesToDraw[1] instanceof ComparableShape) {
//			  drawCompareResults(g);
//		  } else if(shapesToDraw[1] != null) {
//			  g.drawString(Model.NOT_COMPARABLE, 10, Model.MAIN_WINDOW_SIZE_Y - 10);
//			  }
		  System.out.println(model);
		  System.out.println(shape);
	  }
  }
  
  /*
   * Display the results of comparing two shapes on the screen
   */
  public void drawCompareResults(Shape a, Shape b, Graphics g) {
	  switch(model.compareShapes(a,b)) {
	  case -1: g.drawString(Model.TWO_BIGGER_THAN_ONE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;			//output - 2 is bigger than 1
	  case 0: g.drawString(Model.TWO_SAME_AS_ONE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;											//output - 1 and 2 are the same size
	  case 1: g.drawString(Model.TWO_SMALLER_THAN_ONE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;			//output - 1 is bigger than 2
	  case -9: g.drawString(Model.NOT_COMPARABLE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;				//not comparable
	  }
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
  }

}
