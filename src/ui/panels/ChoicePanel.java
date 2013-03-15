package ui.panels;

import interfaces.Resettable;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import enums.ShapeType;

import model.Model;

/**
 * A panel containing a choice box that has all the possible shapeTypes from the ShapeType class.
 * @author Stephen
 *
 */
public class ChoicePanel extends Panel implements Resettable {
	private Choice choice;
	private Model model;


	/**
	 * Creates an instance of Choice, giving it the values in the ShapeType class and assigning it a listerner.
	 * Adds the instance to the current panel.
	 * @param model
	 */
	public ChoicePanel(final Model model) {
		choice = new Choice();
		this.model = model;

		addShapeValues();
		addItemListeners(model);
		setLayoutInfo();
	}

	/*
	 * Add all the existing shape choices in the ShapeType enumerated class to the Choice.
	 */
	private void addShapeValues() {
		for(ShapeType shapeChoice : ShapeType.values()) {
			choice.add(shapeChoice.toString());
		}
	}

	/*
	 * Add an item listener to the Choice instance. This sets the current shape type stored in the model to the
	 * current displayed value of the Choice instance.
	 */
	private void addItemListeners(final Model model) {
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setCurrentShapeType(ShapeType.valueOf(choice.getSelectedItem().toString().toUpperCase()));
			}
		});
	}

	/*
	 * Sets the layout to a GridLayout and adds the Choice instance to it.
	 */
	private void setLayoutInfo() {
		setLayout(new GridLayout(1,1));
		add(choice);
	}

	/*
	 * Sets the displayed value of choice to the current shape type of the model.
	 * (non-Javadoc)
	 * @see interfaces.Resettable#resetComponents()
	 */
	@Override
	public void resetComponents() {
		choice.select(model.getCurrentShapeType().toString());
	}

}
