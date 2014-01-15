
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class DoubleBufferedCanvas extends Canvas {// am folosit un double buffer pt eliminarea flickerului ; pt a incarca imaginea in memorie 
    
    public void update(Graphics g) { 
	Graphics offgc;//am definit offscreen o imagine
	Image offscreen = null;
	Dimension d = size();

	// creez o imagine pe care o incarc in memorie 
	offscreen = createImage(d.width, d.height);
	offgc = offscreen.getGraphics();//se incarca grafica imaginii 
	// clear the exposed area
	offgc.setColor(getBackground());
	offgc.fillRect(0, 0, d.width, d.height);
	offgc.setColor(getForeground());
	// do normal redraw
	paint(offgc);
	// transfer offscreen to window
	g.drawImage(offscreen, 0, 0, this);
    }
}


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
    
    public Circle(Color c, Dimension d)// constructor care ia  o culoare si o dimensiune
    {
        _inMotion = true;
        _location = new Point(rand(0, (int) d.getWidth() - 30), 
                                rand(0, (int) (d.getHeight() - 30)));// locatia cercului se genereaza aleator intre 0 si dimeniunile canvasului
        _direction = new Point(rand(3,6), 
                                rand(3,6));
        _color = c;
        cDimension = d;
    }
    
    public void drawCircle(Component c) {// se desenaza cercul pe componenta luata ca parametru si se updateaza locatia cercului 
        Graphics g = c.getGraphics();
        g.drawOval(_location.GetX(), _location.GetY(), 30, 30);
        g.setColor(_color);
        g.fillOval(_location.GetX(), _location.GetY(), 30, 30);
        updateLocation(); 
    }
    
    private void updateLocation()// updateaza locatia si verifica coliziunea
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
        return _color == c;// verifica culoarea
    }
}
