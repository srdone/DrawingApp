package ui.panels;

import interfaces.Resettable;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import enums.Actions;
import model.Model;

/**
 * Panel with a radio button group and a checkbox to be used by the user to select the action they want
 * to perform and whether the shape will be filled.
 * @author Stephen
 *
 */
public class ActionPanel extends Panel implements Resettable{

	private CheckboxGroup actionGroup;
	private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill;

	/**
	 * Constructor to create the radio buttons for action selection and the fill checkbox.
	 * @param model The model to send the status messages to from the itemListeners
	 */
	public ActionPanel(final Model model) {
		createActionGroup();
		createDrawActionRadioButtons();
		createFillCheckbox();
		createItemListeners(model);
		createLayoutAndAddBoxes();
	}

	/*
	 * Create the checkbox group for the action radio buttons
	 */
	private void createActionGroup() {
		actionGroup = new CheckboxGroup();
	}

	/*
	 * Create the checkboxes that become part of the checkbox group actionGroup
	 */
	private void createDrawActionRadioButtons() {
		chkDraw = new Checkbox(Actions.DRAW.toString(), actionGroup, true);
		chkMove = new Checkbox(Actions.MOVE.toString(), actionGroup, false);
		chkResize = new Checkbox(Actions.RESIZE.toString(), actionGroup, false);
		chkRemove = new Checkbox(Actions.REMOVE.toString(), actionGroup, false);
		chkChange = new Checkbox(Actions.CHANGE.toString(), actionGroup, false);
	}

	/*
	 * Create the fill checkbox
	 */
	private void createFillCheckbox() {
		chkFill = new Checkbox(Actions.FILL.toString(), false);
	}

	/*
	 * Add item listeners to each checkbox created.
	 * Pre-condition: all the checkboxes in the actionGroup have been created, as well as the fill checkbox.
	 * Post-condition: all items have appropriate itemListeners.
	 */
	private void createItemListeners(final Model model) {
		createDrawListener(model);
		createMoveListener(model);
		createResizeListener(model);
		createRemoveListener(model);
		createChangeListener(model);
		createFillListener(model);
	}

	/*
	 * Create the listener for the Draw radio button.
	 * Sets the current action in the model to DRAW.
	 */
	private void createDrawListener(final Model model) {
		chkDraw.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				model.setAction(Actions.DRAW);
			}
		});

	}

	/*
	 * Create the listener for the Move radio button.
	 * Sets the current action in the model to MOVE.
	 */
	private void createMoveListener(final Model model) {
		chkMove.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				model.setAction(Actions.MOVE);
			}
		});

	}

	/*
	 * Create the listener for the Resize radio button.
	 * Sets the current action in the model to RESIZE.
	 */
	private void createResizeListener(final Model model) {
		chkResize.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				model.setAction(Actions.RESIZE);
			}
		});

	}

	/*
	 * Create the listener for the REMOVE radio button.
	 * Sets the current action in the model to REMOVE.
	 */
	private void createRemoveListener(final Model model) {
		chkRemove.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				model.setAction(Actions.REMOVE);
			}
		});

	}

	/*
	 * Create the listener for the Change radio button.
	 * Sets the current action in the model to CHANGE.
	 */
	private void createChangeListener(final Model model) {
		chkChange.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				model.setAction(Actions.CHANGE);
			}
		});

	}

	/*
	 * Create the listener for the Fill checkbox.
	 * Sets the fill value in the model to true when checked and to false when unchecked.
	 */
	private void createFillListener(final Model model) {
		chkFill.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				model.setFill(chkFill.getState());
			}
		});

	}

	/*
	 * Set the layout for the panel and adds the created components to the panel.
	 */
	private void createLayoutAndAddBoxes() {
		setLayout(new GridLayout(1,6));
		add(chkDraw);
		add(chkMove);
		add(chkResize);
		add(chkRemove);
		add(chkChange);
		add(chkFill);
	}

	/*
	 * Sets the components in the ActionPanel to default values. Unchecked/unselected for all but DRAW.
	 * Draw is selected by default.
	 * (non-Javadoc)
	 * @see interfaces.Resettable#resetComponents()
	 */
	public void resetComponents() {
		chkDraw.setState(true);
		chkMove.setState(false);
		chkResize.setState(false);
		chkRemove.setState(false);
		chkChange.setState(false);
		chkFill.setState(false);
	}

}
