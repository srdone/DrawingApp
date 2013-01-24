package enums;

import shapes.Shape;

public enum ShapeType {
  
  RECTANGLE("Rectangle"),
  OVAL("Oval"),
  LINE("Line");
  
  private String shapeText;
  private Shape shape;
  
  ShapeType(String shapeText) {
    this.shapeText = shapeText;
  }
  
//  public Shape createShape() {
//    
//  }
  
  public String toString() {
    return shapeText;
  }
  
  public static ShapeType toType(String shapeText) {
    for(ShapeType shapeType : ShapeType.values()) {
      if (shapeText.equals(shapeType.toString())) return shapeType;
    }
    return RECTANGLE;
  }
  
}
