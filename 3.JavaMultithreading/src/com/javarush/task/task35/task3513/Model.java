package com.javarush.task.task35.task3513;

import java.util.ArrayList;

/**
 * Created by Sukora Stas.
 */
public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    protected int score;
    protected int maxTile;
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }
    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private ArrayList<Tile> getEmptyTiles() {
        ArrayList<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        ArrayList<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int randomTileIndex = (int) (Math.random() * emptyTiles.size());
            emptyTiles.get(randomTileIndex).value = (Math.random() < 0.9) ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = 0; j < tiles.length - 1; j++) {
                if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = new Tile();
                    isCompressed = true;
                }
            }
        }
        return isCompressed;
    }
    private boolean mergeTiles(Tile[] tiles) {  //Слияние плиток одного номинала
        boolean isMerges = false;
        for (int j = 0; j < tiles.length - 1; j++) {
            if (tiles[j].value == tiles[j + 1].value && !tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                tiles[j].value = tiles[j].value * 2;
                isMerges = true;
                score += tiles[j].value;
                maxTile = maxTile > tiles[j].value ? maxTile : tiles[j].value;
                tiles[j + 1] = new Tile();
                compressTiles(tiles);
            }
        }
        return isMerges;
    }

    void left() {
        if (isSaveNeeded){saveState(gameTiles);}
        boolean isChange = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChange = true;
            }
        }
        isSaveNeeded = true;
        if (isChange) addTile();
    }

    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }
    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }
    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    private void rotateToRight() {
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                Tile temp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = temp;
            }
        }
    }


    private void saveState(Tile[][] tile) {
        Tile[][] newGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                newGameTiles[i][j] = tile[i][j];
            }
        }
//        previousStates.push(newGameTiles);
//        previousScores.push(score);
        isSaveNeeded = false;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
}
