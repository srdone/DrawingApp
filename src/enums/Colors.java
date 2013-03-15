package enums;

import java.awt.Color;

/**
 * 
 * Provides a list of enumerated values that provide simple conversion between
 * names and Color values. It provides defined titles for specific color values.
 * @author Stephen
 * @see Color
 */
public enum Colors {
  
  RED(new Color(255, 0, 0)),
  ORANGE(new Color(255, 127, 0)),
  YELLOW(new Color(255, 255, 0)),
  GREEN(new Color(0, 255, 0)),
  BLUE(new Color(0, 0, 255)),
  INDIGO(new Color(75, 0, 130)),
  VIOLET(new Color(143, 0, 255)),
  BLACK(Color.BLACK);
  
  private Color color;
  
  /**
   * Assigns a Color object to each enum, to be used to easily convert from enum to the intended color.
   * @param color is used to assign an actual color value to the enumeration.
   */
  Colors(Color color) {
    this.color = color;
  }
  
  /*
   * Returns the Color object corresponding to the Colors enumerated value.
   */
  public Color getColor() {
	  return color;
  }
  
}
