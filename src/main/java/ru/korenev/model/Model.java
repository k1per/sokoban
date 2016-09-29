package ru.korenev.model;


import ru.korenev.controller.EventListener;

import java.util.Set;

/**
 * Created by k1per on 26.01.2016.
 */
public class Model
{
    EventListener eventListener;
    public static final int FIELD_SELL_SIZE = 20;
    GameObjects gameObjects;
    public int currentLevel = 1;
    LevelLoader levelLoader = new LevelLoader("/levels.txt");

    public void setEventListener(EventListener eventListener){
       this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){

        return gameObjects;
    }

    public void restartLevel(int level){
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction){


        if(checkWallCollision(gameObjects.getPlayer(),direction)) return;
        if(checkBoxCollision(direction)) return;
        Player player = gameObjects.getPlayer();

        switch (direction){
            case UP:
                player.move(0,-FIELD_SELL_SIZE);
                break;
            case DOWN:
                player.move(0,FIELD_SELL_SIZE);
                break;
            case LEFT:
                player.move(-FIELD_SELL_SIZE,0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE,0);
                break;
        }
        checkCompletion();

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){


        Set<Wall> walls = gameObjects.getWalls();

        for(Wall wall : walls){
            if(gameObject.isCollision(wall,direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        Set<Box> boxes = gameObjects.getBoxes();

        for(Box box : boxes){
            if(player.isCollision(box,direction)){
                for(Box box1 : boxes){
                    if(box.isCollision(box1,direction)) return true;
                }
                if(checkWallCollision(box,direction)) return true;
                switch (direction){
                    case UP:
                        box.move(0,-Model.FIELD_SELL_SIZE);
                        break;
                    case DOWN:
                        box.move(0,Model.FIELD_SELL_SIZE);
                        break;
                    case LEFT:
                        box.move(-Model.FIELD_SELL_SIZE,0);
                        break;
                    case RIGHT:
                        box.move(Model.FIELD_SELL_SIZE,0);
                }
                return false;
            }
        }

    return false;
    }

    public void checkCompletion(){

        int counter = 0;
        for(Home home : gameObjects.getHomes()){
             for(Box box : gameObjects.getBoxes()){
                 if(home.getX() == box.getX() && home.getY() == box.getY()) counter++;
             }
        }
       if(counter == gameObjects.getHomes().size()){
           eventListener.levelCompleted(currentLevel);
       }
    }

}
