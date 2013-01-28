package ui.panels;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ButtonPanel extends Panel{
  private Button btnClear;
  private ClearButtonListener btnListener;
  
  public ButtonPanel(Model model) {
    btnClear = new Button("Clear");
    btnListener = new ClearButtonListener(model);
    btnClear.addActionListener(btnListener);
    add(btnClear);
  }
  
  class ClearButtonListener implements ActionListener  {
	  private Model model;
	
	  public ClearButtonListener(Model model) {
		  this.model = model;
	  }

	  @Override
	  public void actionPerformed(ActionEvent arg0) {
		  model.resetComponents();
		  model.repaint();

	  }
	  
  }

}
