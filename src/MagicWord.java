public class MagicWord {
    private static final int MAX_FAILS = 10;
    private static String[] WORD = {
            "freddy fazbear", "bonnie", "chica", "foxy", "golden freddy",
            "toy freddy", "toy bonnie", "toy chica", "mangle", "puppet",
            "balloon boy", "jj", "withered freddy", "withered bonnie", "withered chica",
            "withered foxy", "withered golden freddy", "shadow freddy", "shadow bonnie", "endoskeleton 01",
            "endoskeleton 02", "paperpals", "springtrap", "phantom freddy", "phantom chica",
            "phantom foxy", "phantom mangle", "phantom balloon boy", "phantom puppet", "nightmare freddy",
            "nightmare bonnie", "nightmare chica", "nightmare foxy", "nightmare fredbear", "nightmare",
            "plushtrap", "nightmare balloon boy", "nightmare mangle", "nightmarionne", "jack-o-bonnie",
            "jack-o-chica", "fredbear", "spring bonnie", "circus baby", "ballora",
            "funtime freddy", "funtime foxy", "ennard", "bidybab", "minireena", "bon-bon", "bonnet", "yendo", "lolbit", "electrobab",
            "helpy", "happy frog", "mr. hippo", "pigpatch", "nedd bear",
            "orville elephant", "rockstar freddy", "rockstar bonnie", "rockstar chica", "rockstar foxy",
            "music man", "el chip", "funtime chica", "molten freddy", "scrap baby",
            "scraptrap", "lefty", "candy cadet", "security puppet", "bucket bob",
            "mr. can-do", "mr. hugs", "no. 1 fan", "pan stan", "glamrock freddy",
            "glamrock chica", "montgomery gator", "roxanne wolf", "gregory", "vannie",
            "sun", "moon", "dj music man", "wind-up music man", "shattered freddy",
            "shattered chica", "shattered monty", "shattered roxy", "glamrock mr. hippo", "the blob",
            "burntrap", "wet floor bot", "map bot", "staff bot", "eclipse"
    };

    public String hiddenWord;

    public boolean[] letrasAcertadas;

    public int fails = 0;

    public MagicWord() {
        int palabraAleatoria = (int) (Math.random() * WORD.length);
        hiddenWord = WORD[palabraAleatoria];
        letrasAcertadas = new boolean[hiddenWord.length()];
        for (int i = 0 ; i < hiddenWord.length() ; i ++){
            letrasAcertadas[i] = false;
        }
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0 ; i < hiddenWord.length() ; i ++){
            if (letrasAcertadas[i]){
                s += hiddenWord.charAt(i);
            }else{
                s+= "_";
            }
        }
        return s;
    }

    public boolean wins(){
        for(int i = 0; i < letrasAcertadas.length; i++ ){
            if(!letrasAcertadas[i]){
                return false;
            }
        }
        return true;
    }



    public void shoot (String wordOrLetter){
        boolean acierto = false;
        if(wordOrLetter.length() == 1){
            for (int i = 0 ; i < hiddenWord.length(); i++){
                if (wordOrLetter.charAt(0) == hiddenWord.charAt(i)){
                    letrasAcertadas[i] = true;
                }
            }
            if (!acierto){
                fails++;
            }
        }else{
            if (hiddenWord.equals(wordOrLetter)){
                for (int i = 0 ; i < letrasAcertadas.length; i++){
                    letrasAcertadas[i] = true;
                }
            }else {
                fails = MAX_FAILS + 1;
            }
        }
    }

    public boolean loses(){
        return fails > MAX_FAILS;
    }
}
