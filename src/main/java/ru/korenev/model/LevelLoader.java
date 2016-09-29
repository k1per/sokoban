package ru.korenev.model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by k1per on 26.01.2016.
 */
public class LevelLoader
{
    String levels;

    public LevelLoader(String levels)
    {
        this.levels = levels;
    }


    public GameObjects getLevel(int level){

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        int actualLevel = (level == 60 ? 60 : level % 60);
        try
        {
            InputStream in = getClass().getResourceAsStream(levels);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            while (bufferedReader.ready()){
                if(bufferedReader.readLine().equals("Maze: " + actualLevel)){
                    bufferedReader.readLine();
                    int x = Integer.parseInt(bufferedReader.readLine().split(" ")[2]);
                    int y = Integer.parseInt(bufferedReader.readLine().split(" ")[2]);
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();

                    int x0 = Model.FIELD_SELL_SIZE / 2;
                    int y0 = Model.FIELD_SELL_SIZE / 2;

                    for(int i = 0; i < y;i++){
                        String line = bufferedReader.readLine();
                        for(int j = 0; j < x;j++){
                            char ch = line.charAt(j);
                            switch (ch){
                                case 'X':
                                    walls.add(new Wall(x0 + Model.FIELD_SELL_SIZE*j,y0 + Model.FIELD_SELL_SIZE*i));
                                    break;
                                case '*':
                                    boxes.add(new Box(x0 + Model.FIELD_SELL_SIZE*j,y0 + Model.FIELD_SELL_SIZE*i));
                                    break;
                                case '.':
                                    homes.add(new Home(x0 + Model.FIELD_SELL_SIZE*j,y0 + Model.FIELD_SELL_SIZE*i));
                                    break;
                                case '&':
                                    boxes.add(new Box(x0 + Model.FIELD_SELL_SIZE*j,y0 + Model.FIELD_SELL_SIZE*i));
                                    homes.add(new Home(x0 + Model.FIELD_SELL_SIZE*j,y0 + Model.FIELD_SELL_SIZE*i));
                                    break;
                                case '@':
                                    player = new Player(x0 + Model.FIELD_SELL_SIZE*j,y0 + Model.FIELD_SELL_SIZE*i);
                                    break;
                                default:
                            }
                        }

                    }
                }
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return new GameObjects(walls,boxes,homes,player);

    }
}
