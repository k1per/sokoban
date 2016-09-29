package ru.korenev.controller;


import ru.korenev.model.Direction;
import ru.korenev.model.GameObjects;
import ru.korenev.model.Model;
import ru.korenev.view.View;

/**
 * Created by k1per on 26.01.2016.
 */
public class Controller implements EventListener
{
    View view;
    Model model;


    public Controller(){
        view = new View(this);
        model  = new Model();
        view.init();
        model.restart();
        model.setEventListener(this);
        view.setEventListener(this);
    }

    public static void main(String[] args) throws Exception
    {
        Thread.sleep(1000);
        Controller controller = new Controller();

    }

    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }

   
    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }

    
    public void restart()
    {
        model.restart();
        view.update();
    }

     
    public void startNextLevel()
    {
        model.startNextLevel();
        view.update();
    }

     
    public void levelCompleted(int level)
    {
        view.completed(level);
    }


}
