package ru.korenev.model;

import java.awt.*;

/**
 * Created by k1per on 26.01.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
