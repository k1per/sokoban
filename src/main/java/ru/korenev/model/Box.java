package ru.korenev.model;

import java.awt.*;

/**
 * Created by k1per on 26.01.2016.
 */
public class Box extends CollisionObject implements Movable
{


    public Box(int x, int y){
       super(x,y);
    }

    public void move(int x, int y)
    {
        setX(getX()+x);
        setY(getY()+y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
