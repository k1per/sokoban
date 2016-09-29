package ru.korenev.controller;


import ru.korenev.model.Direction;

/**
 * Created by k1per on 26.01.2016.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}
