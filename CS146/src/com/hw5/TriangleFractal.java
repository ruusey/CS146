package com.hw5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class TriangleFractal extends Applet {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final Color BG_COLOR = Color.CYAN;
	private static final long serialVersionUID = 1L;
	public static int tri = 0;
	public static void main(String[] args) {
		System.out.println();
	}

	public void paint(Graphics g) {
		
		this.setSize(WIDTH, HEIGHT);
		setBackground(BG_COLOR);

		Point p1 = new Point(0, HEIGHT);
		Point p2 = new Point(WIDTH / 2, 0);
		Point p3 = new Point(WIDTH, HEIGHT);
		int level = 5;
		recurseTriangle(p1, p2, p3, level, g);
		System.out.println(tri);
	}
	//INSTEAD OF DRAWING THE SPACES, DRAW THE TRIANGLES
	public void recurseTriangle(Point p1, Point p2, Point p3, int level,
			Graphics g) {
		
		if (level == 0) {
			Polygon p = new Polygon();
			p.addPoint(p1.x, p1.y);
			p.addPoint(p2.x, p2.y);
			p.addPoint(p3.x, p3.y);
			g.fillPolygon(p);
			tri++;
		} else {
			//GET THE MIDPOINT OF POINTS
			Point p4 = midpoint(p1, p2);
			Point p5 = midpoint(p2, p3);
			Point p6 = midpoint(p1, p3);
			
			level = level - 1;
			//DRAW 3 MORE TRIANGLES INSIDE OF EACH TRIANGLE
			recurseTriangle(p1, p4, p6, level, g);
			recurseTriangle(p4, p2, p5, level, g);
			recurseTriangle(p6, p5, p3, level, g);
		}

	}

	public static Point midpoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}

	private class Triangle {
		public Point p1;
		public Point p2;
		public Point p3;

		public Triangle(Point p1, Point p2, Point p3) {
			super();
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
		}

		public void drawTriangle(Graphics g) {
			Polygon p = new Polygon();
			p.addPoint(p1.x, p1.y);
			p.addPoint(p2.x, p2.y);
			p.addPoint(p3.x, p3.y);
			g.fillPolygon(p);
		}
	}
}
