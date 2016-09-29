package ru.korenev.model;

import java.awt.*;

/**
 * Created by k1per on 26.01.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y){
        super(x,y,10,10);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        graphics.fillOval(getX(),getY(),getWidth(),getHeight());
    }
}
