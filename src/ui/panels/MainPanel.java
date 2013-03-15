package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import model.Model;

/**
 * Takes the other panels and puts them into one panel using a GridLayout.
 * The panels are: ActionPanel, ChoicePanel, and ControlsPanel
 * @author Stephen
 */
public class MainPanel extends Panel implements Resettable {
  ActionPanel actionPanel;
  ChoicePanel choicePanel;
  ControlsPanel controlsPanel;
  
  /**
   * Creates new instances of each panel type to be displayed, and gives each a reference to the model.
   * @param model The class keeping track of all changes in the applet. The panels use it to communicate actions performed on them to the applet.
   */
  public MainPanel(Model model) {
    choicePanel = new ChoicePanel(model);
    controlsPanel = new ControlsPanel(model);
    actionPanel = new ActionPanel(model);
    setLayout(new GridLayout(3,1));
    add(controlsPanel);
    add(choicePanel);
    add(actionPanel);
  }
  
  /**
   * Sends a resetComonents message to all the components of MainPanel
   */
  public void resetComponents() {
    controlsPanel.resetComponents();
    actionPanel.resetComponents();
    choicePanel.resetComponents();
  }

}
