package ru.korenev.view;


import ru.korenev.controller.Controller;
import ru.korenev.controller.EventListener;
import ru.korenev.model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан    R - restart");
        setVisible(true);
    }

    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }

    public void update(){
        field.repaint();
    }


    public void completed(int level){
        update();
        JOptionPane.showMessageDialog(null, "You completed " + level + " level");
        controller.startNextLevel();

    }

    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }
}
