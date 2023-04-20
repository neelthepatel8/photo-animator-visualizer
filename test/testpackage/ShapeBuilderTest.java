package testpackage;

import org.junit.Test;

import app.model.shape.IShape;
import app.model.shape.ShapeBuilder;

import static org.junit.Assert.*;

public class ShapeBuilderTest {


  @Test
  public void testShapeBuilder() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).build();
    assertEquals(1, shape.getX(), 0.001);
    assertEquals(2, shape.getY(), 0.001);
  }

  @Test
  public void testShapeBuilder2() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setRadius(3).build();
    assertEquals(1, shape.getX(), 0.001);
    assertEquals(2, shape.getY(), 0.001);
    assertEquals(3, shape.getRadius(), 0.001);
  }


  @Test
  public void testRectangle(){
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setWidth(3).setHeight(4).build();
    assertEquals(1, shape.getX(), 0.001);
    assertEquals(2, shape.getY(), 0.001);
    assertEquals(3, shape.getWidth(), 0.001);
    assertEquals(4, shape.getHeight(), 0.001);
  }

  @Test
  public void testOval() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setRadiusX(3).setRadiusY(4).build();
    assertEquals(1, shape.getX(), 0.001);
    assertEquals(2, shape.getY(), 0.001);
    assertEquals(3, shape.getRadiusX(), 0.001);
    assertEquals(4, shape.getRadiusY(), 0.001);
  }

  @Test
  public void testShapeBuilderIsSingleton() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    ShapeBuilder shapeBuilder2 = ShapeBuilder.getInstance();
    assertEquals(shapeBuilder, shapeBuilder2);
  }

  @Test
  public void testRectanglesRadiusIsEmpty() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setWidth(3).setHeight(4).build();
    assertEquals(0, shape.getRadius(), 0.001);
    assertEquals(0, shape.getRadiusX(), 0.001);
    assertEquals(0, shape.getRadiusY(), 0.001);
  }

  @Test
  public void testOvalsWidthXIsEmpty() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setRadiusX(3).setRadiusY(4).build();
    assertEquals(0, shape.getWidth(), 0.001);
    assertEquals(0, shape.getHeight(), 0.001);
    assertEquals(0, shape.getRadius(), 0.001);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testShapeBuilderException() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setRadius(-10).setWidth(4).build();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testShapeBuilderException2() {
    ShapeBuilder shapeBuilder = ShapeBuilder.getInstance();
    IShape shape = shapeBuilder.start().setX(1).setY(2).setName(null).build();
  }

}