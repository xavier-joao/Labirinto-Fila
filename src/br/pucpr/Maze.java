package br.pucpr;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
    private char[][] maze;
    private Coord teseu, end;
    public boolean printSteps = true;
    private String passosEfetivados;
    private String inicial;


    private class Move {
        Move(Coord c, int dir) {this.coord = c; this.dir = dir;}
        public Coord coord;
        public int dir;
        public String toString() { return "" + coord + "-" + dir;}
    }
    private Queue<Move> fila = new LinkedList<Move>();

    private final static int UP = 0;
    private final static int RIGHT = 1;
    private final static int DOWN = 2;
    private final static int LEFT = 3;
    private final static int INVALID = -1;

    private final static char W = '#'; // Wall
    private final static char P = ' '; // Path
    private final static char V = '-'; // Visited
    private final static char S = 'E'; // Start
    private final static char E = 'S'; // End
    private final static char T = '@'; // Teseu

    public Maze(char[][] maze) {
        this.maze = maze;
        this.teseu = getStartingCoord();
        this.end = getEndingCoord();
        Queue<Move> fila = new LinkedList<Move>();
    }

    public Maze() {
        this(new char[][]{
            {W,W,W,W,W,W,W,W,W,W,W},
            {W,S,W,E,P,P,W,P,W,P,W},
            {W,P,W,W,W,P,W,P,W,P,W},
            {W,P,P,W,P,P,W,P,P,P,W},
            {W,P,W,W,W,P,W,W,W,P,W},
            {W,P,W,P,P,P,P,P,W,P,W},
            {W,P,W,P,W,W,W,W,W,P,W},
            {W,P,W,P,P,P,P,P,P,P,W},
            {W,P,W,W,W,W,W,W,W,P,W},
            {W,P,P,P,P,P,P,P,P,P,W},
            {W,W,W,W,W,W,W,W,W,W,W}});
    }

    public boolean isValid(int x,int y) {
        if (maze[y][x] == W || maze[y][x] == V)
            return false;
        return true;
    }

    private boolean isValidUp(Coord c) {
        return isValid(c.getX(),c.getY()-1);
    }
    private boolean isValidRight(Coord c) {
        return isValid(c.getX()+1,c.getY());
    }
    private boolean isValidDown(Coord c) {
        return isValid(c.getX(),c.getY()+1);
    }
    private boolean isValidLeft(Coord c) {
        return isValid(c.getX()-1,c.getY());
    }

    private int findValidDirection(Coord c) {
        if (isValidUp(c)) return UP;
        if (isValidRight(c)) return RIGHT;
        if (isValidDown(c)) return DOWN;
        if (isValidLeft(c)) return LEFT;

        return INVALID;
    }

    public void visit(int x,int y) {
        if (isValid(x, y)) {
            maze[y][x] = V;
        }
    }

    public void visit(Coord c){
        visit(c.getX(),c.getY());
    }

    public Coord getStartingCoord() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if(maze[row][col] == S){
                    return new Coord(col, row);
                }
            }
        }
        return null;
    }

    public Coord getEndingCoord() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if(maze[row][col] == E){
                    return new Coord(col, row);
                }
            }
        }
        return null;
    }

    public String toString(){
        String str = "";
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (row == teseu.getY() && col == teseu.getX())
                    str += T;
                else {
                    str += maze[row][col];
                }
            }
            str += '\n';
        }
        for (Move cur : fila)
            str += cur + " -> ";
        if (teseu.equals(end)) {str += "Teseu sai vivo";}
        return  str;
    }

    public void solve() {
        inicial = toString();
        passosEfetivados = toString();
        
        visit(teseu);
        while (teseu.equals(end) == false) {
            step();
            if (printSteps){
                System.out.println(passosEfetivados);
                //(new Scanner(System.in)).nextLine();
            }
        }
    }

    public void step() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Para caminhar para cima, digite 0");
        System.out.println("Para caminhar para direita, digite 1");
        System.out.println("Para caminhar para baixo, digite 2");
        System.out.println("Para caminhar para esquerda, digite 3");
        System.out.println("Para reiniciar, digite 4");
        System.out.println("Para realizar os passos, digite 5");
        try {
        Scanner leitor = new Scanner(System.in);
        int userInput = leitor.nextInt();
        if (userInput == findValidDirection(teseu)) {
            fila.add(new Move(teseu.copy(), userInput));
            teseu.move(userInput);
            visit(teseu);
        } else if (userInput == 4) {
            fila.clear();
            passosEfetivados = inicial;

        } else if (userInput == 5) {
            passosEfetivados = toString();
        } else if (userInput != findValidDirection(teseu) && userInput >= 0 && userInput <= 3) {
            System.out.println("Bateu na parede ou lugar já visitado.");
        } else {
            System.out.println("VALOR INVALIDO");
        }
        System.out.println("Comandos enfileirados: " + fila.size());
    }catch(Exception e){
        System.out.println("VALOR INVALIDO");
        }
    }
}

