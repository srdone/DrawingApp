package ui.applet;

import java.applet.Applet;
import java.awt.Graphics;
import model.Model;
import ui.panels.MainPanel;
import interfaces.Resettable;

import event.ShapeMouseHandler;

import shapes.Shape;

public class GUI extends Applet implements Resettable {
  MainPanel mainPanel;
  Model model;
  
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
    Shape shape;
    shape = model.getCurrentShape();
    if(shape != null) {
      shape.draw(g);
    }
    System.out.println(model);
    System.out.println(shape);
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
  }

}
