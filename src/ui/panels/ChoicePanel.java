package ui.panels;

import interfaces.Resettable;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import enums.ShapeType;

import model.Model;

public class ChoicePanel extends Panel implements Resettable {
  private Choice choice;
  private Model model;
  
  public ChoicePanel(final Model model) {
    choice = new Choice();
    this.model = model;
    //Add the all the existing shape choices to the choice box.
    for(ShapeType shapeChoice : Model.SHAPE_CHOICES) {
      choice.add(shapeChoice.toString());
    }
    
    choice.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setCurrentShapeType(ShapeType.toType(choice.getSelectedItem()));
      }
    });
    
    setLayout(new GridLayout(1,1));
    add(choice);
  }

  @Override
  public void resetComponents() {
    choice.select(model.getCurrentShapeType().toString());
  }
  
}
