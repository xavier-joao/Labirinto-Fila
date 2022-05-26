package br.pucpr;


public class Main {

    public static void main(String[] args) {
        testes();
    }

    public static void testes() {
        char W = '#'; // Wall
        char P = ' '; // Path
        char V = '-'; // Visited
        char S = 'E'; // Start
        char E = 'S'; // End

        Maze labirinto1 = new Maze (new char [][]{
            {W,W,W,W,W},
            {W,S,W,E,W},
            {W,P,W,P,W},
            {W,P,P,P,W},
            {W,W,W,W,W},
            });

        System.out.println(labirinto1);
        //labirinto1.printSteps = true;
        labirinto1.solve();
        System.out.println(labirinto1);



        Maze labirinto2 = new Maze (new char [][]{
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

        System.out.println(labirinto2);
        labirinto2.solve();
        System.out.println(labirinto2);

        Maze labirinto3 = new Maze (new char [][]{
                {W,W,W,W,W,W,W,W,W,W,W},
                {W,P,W,P,P,P,W,E,W,P,W},
                {W,P,W,W,W,P,W,P,W,P,W},
                {W,P,P,W,P,P,W,P,P,P,W},
                {W,P,W,W,W,P,W,W,W,P,W},
                {W,P,W,P,P,P,P,P,W,P,W},
                {W,P,W,P,W,W,W,W,W,P,W},
                {W,P,W,P,P,P,P,P,P,P,W},
                {W,P,W,W,W,W,W,W,W,P,W},
                {W,P,P,P,P,P,P,P,P,P,W},
                {W,P,W,W,W,W,W,W,W,P,W},
                {W,P,P,P,P,P,P,S,W,P,W},
                {W,P,W,W,W,W,W,W,W,P,W},
                {W,P,P,P,P,P,P,P,P,P,W},
                {W,W,W,W,W,W,W,W,W,W,W}});

        System.out.println(labirinto3);
        labirinto3.solve();
        System.out.println(labirinto3);

    }
}
