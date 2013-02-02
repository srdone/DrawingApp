package ui.applet;

import java.applet.Applet;
import java.awt.Graphics;
import model.Model;
import ui.panels.MainPanel;
import interfaces.ComparableShape;
import interfaces.Resettable;

import event.ShapeMouseHandler;

import shapes.Shape;

public class GUI extends Applet implements Resettable {
  MainPanel mainPanel;
  Model model;
  Shape[] shapesToDraw;
  
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
	  for(int i = 0 ; i < shapesToDraw.length; i++) {
		  if(shapesToDraw[i] != null) {
			  shapesToDraw[i].draw(g);								//draw shape at index i
			  g.drawString("Shape " + (i + 1), shapesToDraw[i].getX1(), shapesToDraw[i].getY1());
		  }
		  //make sure both shapes are comparable, then do the compare
		  if(shapesToDraw[0] instanceof ComparableShape && shapesToDraw[1] != null && shapesToDraw[1] instanceof ComparableShape) {
			  drawCompareResults(g);
		  } else if(shapesToDraw[1] != null) {
			  g.drawString(Model.NOT_COMPARABLE, 10, Model.MAIN_WINDOW_SIZE_Y - 10);
			  }
		  System.out.println(model);
		  System.out.println(shapesToDraw[i]);
	  }
  }
  
  public void drawCompareResults(Graphics g) {
	  switch(model.compareShapes()) {							//TODO Create output for comparables
	  case -1: g.drawString(Model.TWO_BIGGER_THAN_ONE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;			//output - 2 is bigger than 1
	  case 0: g.drawString(Model.TWO_SAME_AS_ONE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;											//output - 1 and 2 are the same size
	  case 1: g.drawString(Model.TWO_SMALLER_THAN_ONE, 10, Model.MAIN_WINDOW_SIZE_Y - 10); break;											//output - 1 is bigger than 2
	  }
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
  }

}
