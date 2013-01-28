package enums;

import java.awt.Color;

public enum Colors {
  
  RED("Red", new Color(255, 0, 0)),
  ORANGE("Orange", new Color(255, 127, 0)),
  YELLOW("Yellow", new Color(255, 255, 0)),
  GREEN("Green", new Color(0, 255, 0)),
  BLUE("Blue", new Color(0, 0, 255)),
  INDIGO("Indigo", new Color(75, 0, 130)),
  VIOLET("Violet", new Color(143, 0, 255)),
  BLACK("Black", Color.BLACK);
  
  private String colorText;
  private Color color;
  
  Colors(String colorText, Color color) {
    this.colorText = colorText;
    this.color = color;
  }
  
  public String toString() {
    return colorText;
  }
  
  public Color getColor() {
	  return color;
  }
  
  public static Color toType(String colorText) {
    for(Colors colorType : Colors.values()) {
      if (colorText.equals(colorType.toString())) return colorType.getColor();
    }
    return Color.BLACK;
  }
  
}
