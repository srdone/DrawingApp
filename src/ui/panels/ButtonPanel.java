package ui.panels;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

/**
 * A clear button that sends a command to reset all components of the drawing app.
 * @author Stephen
 *
 */
public class ButtonPanel extends Panel{
  private Button btnClear;
  private ClearButtonListener btnListener;
  
  /**
   * Creates a button to reset all components of the drawing app, and gives it a reference to the model.
   * @param model
   */
  public ButtonPanel(Model model) {
	  //Create the button with the title "Clear"
    btnClear = new Button("Clear");
    //Create an instance of the inner class ClearButtonListener
    btnListener = new ClearButtonListener(model);
    //Add the listenter to the clear button
    btnClear.addActionListener(btnListener);
    //Add the clear button to the panel
    add(btnClear);
  }
  
  /**
   * An inner class that acts as the action listener for the clear button.
   * @author Stephen
   *
   */
  class ClearButtonListener implements ActionListener  {
	  private Model model;
	
	  /**
	   * Contstructor for the listener
	   * @param model
	   */
	  public ClearButtonListener(Model model) {
		  this.model = model;
	  }

	  /*
	   * When the actionListener detects an action, tell the model to reset it's components and repaint.
	   * (non-Javadoc)
	   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	   */
	  @Override
	  public void actionPerformed(ActionEvent arg0) {
		  model.resetComponents();
		  model.repaint();

	  }
	  
  }

}
