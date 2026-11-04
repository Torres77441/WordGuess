public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        MagicWord m = new MagicWord();
        System.out.println(m);
        int intentos = 10;
        int buenos_intentos = 0;

        while (!gameOver){
            System.out.println("---Enter a word or letter to guess the FNAF character---");
            System.out.println(m);
            if (intentos != 0){
                System.out.println("Te quedan " + intentos + " para perder");
            }else {
                System.out.println("ES TU ULTIMO INTENTO");
            }
            String s = Input.readString();
            m.shoot(s);
            intentos--;
            buenos_intentos++;
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            if (m.wins()){
                System.out.println("Has realizado " + buenos_intentos + " intentos antes de ganar");
                System.out.println();
                System.out.println(m);
                gameOver = true;
            }else {
                if (m.loses()){
                    System.out.println("PERDISTEEE!!  LA PALABRA ERA : " + m.getHiddenWord());
                    gameOver = true;
                }
            }
        }
    }
}
