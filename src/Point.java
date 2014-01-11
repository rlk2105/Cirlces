/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vlad
 */
public class Point {
    private int X, Y;
    
    Point()
    {
        X = Y = 0;
    }
    
    Point(int x, int y)
    {
        X = x;
        Y = y;
    }

    Point Add(Point p) {
        return new Point(X + p.X, Y + p.Y);
    }
    
    public void ReverseX()
    {
        X = - X;
    }
    
    public void ReverseY()
    {
        Y = - Y;
    }
    
    public int GetX()
    {
        return X;
    }
    
    public int GetY()
    {
        return Y;
    }
    
    public void SetX(int x)
    {
        X = x;
    }
    
    public void SetY(int y)
    {
        Y = y;
    }
}
