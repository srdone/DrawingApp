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

public class ControlsPanel extends Panel implements Resettable{
  private ButtonPanel btnPanel;
  private ColorChoicePanel colorChoice;
  
  public ControlsPanel(Model model) {
    btnPanel = new ButtonPanel(model);
    colorChoice = new ColorChoicePanel(model);
    add(colorChoice);
    add(btnPanel);
  }
  
  public void resetComponents() {
    colorChoice.resetComponents();
  }
  
  static class ColorChoicePanel extends Panel implements Resettable {
	  private Label fillColorLabel;
	  private Choice fillColorChoice;
	  
	  private Label lineColorLabel;
	  private Choice lineColorChoice;
	  
	  private Model model;
	  
	  public ColorChoicePanel(final Model model) {
		  fillColorLabel = new Label("Fill Color: ", Label.RIGHT);
		  fillColorChoice = new Choice();
		  
		  lineColorLabel = new Label("Line Color: ", Label.RIGHT);
		  lineColorChoice = new Choice();
		  this.model = model;
		  
		  for(Colors colorChoice : Model.COLOR_CHOICES) {
			  fillColorChoice.add(colorChoice.toString());
			  lineColorChoice.add(colorChoice.toString());
		  }
		  
		  fillColorChoice.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent e) {
				  model.setFillColor(Colors.toType(fillColorChoice.getSelectedItem()));
			  }
		  });
		  
		  lineColorChoice.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent e) {
				  model.setLineColor(Colors.toType(lineColorChoice.getSelectedItem()));
			  }
		  });

		  setLayout(new GridLayout(1,4));
		  add(lineColorLabel);
		  add(lineColorChoice);
		  
		  add(fillColorLabel);
		  add(fillColorChoice);
		  
	  }
	  
	  public void resetComponents() {
	    fillColorChoice.select(Model.DEFAULT_COLOR);
	    lineColorChoice.select(Model.DEFAULT_COLOR);
	  }
  }

}

//TODO Panels not resetting
