package ru.korenev.model;

import java.awt.*;

/**
 * Created by k1per on 26.01.2016.
 */
public class Player extends CollisionObject implements Movable
{
   public Player(int x,int y){
       super(x,y);
   }

    @Override
    public void draw(Graphics graphics)
    {
         graphics.setColor(Color.YELLOW);
        graphics.fillOval(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void move(int x, int y)
    {
        setX(getX()+x);
        setY(getY()+y);
    }
}
