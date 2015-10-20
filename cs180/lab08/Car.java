public class Car {
  private String color;
  private String make;
  private boolean isSold = false;
  Car(String color, String make ) {
    this.color = color;
    this.make = make;
  }
  public String getColor() {
    return this.color;
  }
  public String getMake() {
    return this.make;
  }
  public boolean isSold() {
    return this.isSold;
  }
  public void sell() {
    this.isSold = true;
  }
}