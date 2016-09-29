package ru.korenev.view;

import ru.korenev.controller.EventListener;
import ru.korenev.model.Direction;
import ru.korenev.model.GameObject;
import ru.korenev.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by k1per on 26.01.2016.
 */
public class Field extends JPanel
{
    View view;
    EventListener eventListener;

    public Field(View view){

        this.view = view;
        KeyHandler keyHandler = new KeyHandler(this);
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        GameObjects gameObjects = view.getGameObjects();
        for(GameObject gameObject : gameObjects.getAll()){
            gameObject.draw(g);
        }

    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public static class KeyHandler extends KeyAdapter
    {
        Field field;

        public KeyHandler(Field field)
        {
            this.field = field;
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    field.eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    field.eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    field.eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    field.eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R:
                    field.eventListener.restart();
                    break;
            }
        }

    }

}
