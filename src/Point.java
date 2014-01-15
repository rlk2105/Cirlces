/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raluca
 */
public class Point {// membrii x si y care retin pozitia pe axa x resectiv y a punctului; se foloseste [t desenarea cercurilor
    private int X, Y;
    
    Point()// constructori fara parametrii care asigneaza valoarea 0 membrilor
    {
        X = Y = 0;
    }
    
    Point(int x, int y)// idem
    {
        X = x;
        Y = y;
    }

    Point Add(Point p) {
        return new Point(X + p.X, Y + p.Y);// aduna doua puncte si intoarce un nou punct 
    }
    
    public void ReverseX()// inverseaza valoarea lui x si y 
    {
        X = - X;
    }
    
    public void ReverseY()// 
    {
        Y = - Y;
    }
    
    public int GetX() //intoarce valoare lui x
    {
        return X;
    }
    
    public int GetY()// intoarce valoarea lui Y
    {
        return Y;
    }
    
    public void SetX(int x)// seteaza valoarea lui x 
    {
        X = x;
    }
    
    public void SetY(int y)// seteaza vaoarea lui Y
    {
        Y = y;
    }
}
