package ru.stqa.pft.sandbox1;

import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

/**
 * Created by LEN on 16.03.2017.
 */
public class PointTests {

  @Test
  public void testsPoint(){
    Point p = new Point(1, 3, 2, 4);
    //Assert.assertEquals(p.distance(),1.41421356270951);
    System.out.println("расстояние между точками =" + p.distance());


  }
}
