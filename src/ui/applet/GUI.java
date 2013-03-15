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

/**
 * GUI handles the applet initialization and the paint process.
 */
public class GUI extends Applet implements Resettable {
  MainPanel mainPanel;
  Model model;
  ArrayList<Shape> shapesToDraw;
  
  /*
   * Declares the window size and instantiates all objects needed to start the applet
   * (non-Javadoc)
   * @see java.applet.Applet#init()
   */
  public void init() {
    initializeGUIComponents();
    initializeMouseHandlerAndAddListeners();
  }
  
  /*
   * Declare window size.
   * Create an instance of model for all components to communicate with.
   * Create an instance of the main panel, which contains all the controls, and add it to the GUI.
   */
  private void initializeGUIComponents() {
	  resize(Model.MAIN_WINDOW_SIZE_X, Model.MAIN_WINDOW_SIZE_Y);
	    model = new Model(this);                                        //Create new instance of a model, and give the GUI as the container
	    mainPanel = new MainPanel(model);                               //Create a new MainPanel and give it the model
	    add(mainPanel);                                                 //Add the mainpanel to the screen
  }
  
  /*
   * Initialize the mouse handler and add the mouse listeners to the GUI. 
   */
  private void initializeMouseHandlerAndAddListeners() {
	  ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);  //Create a new instance of ShapeMouseHandler and give it the model
	    addMouseListener(mouseHandler);                                 //Add a mouseListener to the GUI so the mouseHandler receives events from it.
	    addMouseMotionListener(mouseHandler);                           //Same as above, but a mouseMotionListener
  }
  
  
  /*
   * When paint is called, draw all the shapes currently in the model and draw a string showing the name of the shape
   * (non-Javadoc)
   * @see java.awt.Container#paint(java.awt.Graphics)
   */
  public void paint(Graphics g) {
	  shapesToDraw = model.getShapeArray();
	  for(Shape shape : shapesToDraw) {
		  if(shape != null) {
			  shape.draw(g);								//draw shape at index i
			  g.drawString("Shape " + (shapesToDraw.indexOf(shape) + 1), shape.getX1(), shape.getY1());		//Draw labels on each shape
		  }
		  System.out.println(model);
		  System.out.println(shape);
	  }
  }
  
  /*
   * Sends the reset components command to all parts of the mainPanel.
   * (non-Javadoc)
   * @see interfaces.Resettable#resetComponents()
   */
  public void resetComponents() {
    mainPanel.resetComponents();
  }

}
