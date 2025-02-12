import java.text.DecimalFormat;

public class Point {
 private final double x;
 private final double y;

 public Point(double x, double y) {
  this.x = x;
  this.y = y;
 }

 public double getX() {
  return this.x;
 }

 public double getY() {
  return this.y;
 }

 @Override
 public String toString() {
  DecimalFormat df = new DecimalFormat(".##");
  String x = df.format(this.x);
  String y = df.format(this.y);
  return "(" + x + ", " + y + ")";
 }
}
