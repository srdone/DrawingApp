package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {
  ActionPanel actionPanel;
  ChoicePanel choicePanel;
  ControlsPanel controlsPanel;
  
  public MainPanel(Model model) {
    choicePanel = new ChoicePanel(model);
    controlsPanel = new ControlsPanel(model);
    actionPanel = new ActionPanel(model);
    setLayout(new GridLayout(3,1));
    add(controlsPanel);
    add(choicePanel);
    add(actionPanel);
  }
  
  public void resetComponents() {
    controlsPanel.resetComponents();
    actionPanel.resetComponents();
    choicePanel.resetComponents();
  }

}
