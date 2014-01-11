
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vlad
 */
public class Circle {
    // culoarea cercului
    private Color _color;
    // vectori 2d pentru pozitia si directia 
    private Point _location, _direction;
    // dimensiunea cercului
    private Dimension cDimension;
    // boolean care retine daca cercul este sau nu in miscare
    private boolean _inMotion;
    
    // generator de numere aleatoare uniforme pe intervalul (min, max)
    private int rand(int min, int max)
    {
        return (int)(Math.random() * (max - min) + min);
    }
    
    public Circle(Color c, Dimension d)
    {
        _inMotion = true;
        _location = new Point(rand(0, (int) d.getWidth() - 30), 
                                rand(0, (int) (d.getHeight() - 30)));
        _direction = new Point(rand(3,6), 
                                rand(3,6));
        _color = c;
        cDimension = d;
    }
    
    public Graphics drawCircle(Component c) {
        Graphics g = c.getGraphics();
        g.drawOval(_location.GetX(), _location.GetY(), 30, 30);
        g.setColor(_color);
        g.fillOval(_location.GetX(), _location.GetY(), 30, 30);
        updateLocation();
        return g;
    }
    
    private void updateLocation()
    {
        if(_inMotion)
        {
            int newX = _location.Add(_direction).GetX(),
                newY = _location.Add(_direction).GetY();
            if(newX > cDimension.getWidth() - 30 || newX < 0)
                _direction.ReverseX();
            if(newY > cDimension.getHeight() - 30 || newY < 0)
                _direction.ReverseY();
            _location = _location.Add(_direction);
        }
    }
    
    public void Stop()
    {
        _inMotion = false;
    }
    
    public void Start()
    {
        _inMotion = true;
    }
    
    public boolean ColorMatch(Color c)
    {
        return _color == c;
    }
}
