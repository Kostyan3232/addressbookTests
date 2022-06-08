package ru.stqa.pft.sandbox1;

public class Point {
  public double y, x;

  public Point (double y, double x) {
    this.y = y;
    this.x = x;
  }

  // Метод
  double distance(Point p) {

    double yy = this.y - p.y;
    double xx = this.x - p.x;
    return  Math.sqrt(yy*yy + xx*xx);
  }

}
