package ui.panels;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;

import enums.ShapeType;
import enums.Colors;

import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;


/**
 * A panel that combines the ControlsPanel class with a static inner class ColorChoicePanel.
 * @author Stephen
 *
 */
public class ControlsPanel extends Panel implements Resettable{
  private ButtonPanel btnPanel;
  private ColorChoicePanel colorChoice;
  
  /**
   * Constructor for the ControlsPanel class.
   * Creates a new Color Choice Panel and a new ButtonPanel and adds them to this panel.
   * @param model
   */
  public ControlsPanel(Model model) {
    createPanels(model);
    addPanels();
  }
  
  /*
   * Creates instances of ButtonPanel and ColorChoicePanel
   */
  private void createPanels(Model model) {
	  btnPanel = new ButtonPanel(model);
	  colorChoice = new ColorChoicePanel(model); 
  }
  
  /*
   * Adds the created panels to the panel.
   */
  private void addPanels() {
	  add(colorChoice);
	  add(btnPanel);
  }
  
  /**
   * Sends a resetComponents message to the instance of ColorChoicePanel
   */
  public void resetComponents() {
    colorChoice.resetComponents();
  }
  
  
  /**
   * Static inner class that creates the line and fill color choice boxes and labels.
   * @author Stephen
   *
   */
  static class ColorChoicePanel extends Panel implements Resettable {
	  private Label fillColorLabel;
	  private Choice fillColorChoice;
	  
	  private Label lineColorLabel;
	  private Choice lineColorChoice;
	  
	  private Model model;
	  
	  /**
	   * Creates the choice boxes and labels for the ColorChoicePanel. Gives each a reference to the model.
	   * @param model The class keeping track of all changes in the applet. The panels use it to communicate actions performed on them to the applet.
	   */
	  public ColorChoicePanel(final Model model) {
		  //Create
		  createColorChoicesAndLabels();
		  this.model = model;
		  
		  //Set controls, add listeners, and put into layout.
		  setColorControls();
		  addItemListeners(model);
		  setLayoutInfo();
	  }
	  
	  /*
	   * Create the label and choice boxes for line and fill colors
	   */
	  private void createColorChoicesAndLabels() {
		  //Create the choice box and corresponding label for the fill color
		  fillColorLabel = new Label("Fill Color: ", Label.RIGHT);
		  fillColorChoice = new Choice();
		  
		  //Create the choice box and corresponding label for the line color
		  lineColorLabel = new Label("Line Color: ", Label.RIGHT);
		  lineColorChoice = new Choice();
	  }
	  
	  
	  /*
	   * Create and assign listeners to the choice boxes. The listener sets the fill/line color in the model.
	   */
	  private void addItemListeners(final Model model) {
		  //Fill Color Listener
		  fillColorChoice.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent e) {
				  model.setFillColor(Colors.valueOf(fillColorChoice.getSelectedItem().toUpperCase()));
			  }
		  });
		  
		  //Line Color Listener
		  lineColorChoice.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent e) {
				  model.setLineColor(Colors.valueOf(lineColorChoice.getSelectedItem().toUpperCase()));
			  }
		  });
	  }
	  
	  /*
	   * Set the layout and add the components to the panel
	   */
	  private void setLayoutInfo() {
		  //Set the layout style
		  setLayout(new GridLayout(1,4));
		  
		  //Add the line color label and choice box to the panel
		  add(lineColorLabel);
		  add(lineColorChoice);
		  
		  //Add the fill color label and choice box to the panel
		  add(fillColorLabel);
		  add(fillColorChoice);
	  }
	  
	  /*
	   * Put all the possible color values into the line and fill color choice boxes.
	   * Color values come from the Colors enumerated type
	   */
	  private void setColorControls() {
		  for(Colors colorChoice : Colors.values()) {
			  //Prepare a string that is a pretty display - the ENUM only provides capitalized values.
			  String colorString = toProperCase(colorChoice.toString());
			  fillColorChoice.add(colorString);
			  lineColorChoice.add(colorString);
		  }
	  }
	  
	  /*
	   * Converts any string to a string where the first letter of the first word is capitalized.
	   */
	  private String toProperCase(String string) {
		  return (((String) string.subSequence(0, 1)).toUpperCase() + string.substring(1).toLowerCase());
	  }
	  
	  /**
	   * Sets the color choice boxes to default values, using the DEFAULT_COLOR in the Model class.
	   */
	  public void resetComponents() {
	    fillColorChoice.select(Model.DEFAULT_COLOR);
	    lineColorChoice.select(Model.DEFAULT_COLOR);
	  }
  }

}
