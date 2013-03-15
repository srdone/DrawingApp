package interfaces;

import java.awt.Color;

/**
 * An interface for objects that can be filled
 */
public interface Fillable {
  
  public boolean isFilled();
  
  public void setFilled(boolean filled);
  
  public Color getFillColor();
  
  public void setFillColor(Color fillColor);

}
