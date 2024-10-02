class Automat {
    char[] inputAlfabet;
    int[] aksepterendeTilstander;
    int startTilstand;
    int[][] nesteTilstand;

    public Automat(char[] inputAlfabet, int[] aksepterendeTilstander, int[][] nesteTilstand) {
        this.inputAlfabet = inputAlfabet;
        this.aksepterendeTilstander = aksepterendeTilstander;
        this.nesteTilstand = nesteTilstand;
        this.startTilstand = 0;
    }

    public boolean sjekkInput(char[] input) {
        int currentPos = 0;
        for (int i = 0; i < input.length; i++) {
            int inputIndex = 0;
            for (int k = 0; k < inputAlfabet.length; k++) {
                if (input[i] == inputAlfabet[k]) {
                    inputIndex = k;
                    break;
                }
            }
            // System.out.println(inputIndex);
            currentPos = nesteTilstand[currentPos][inputIndex];
            // System.out.println(currentPos);
        }
        for (int i = 0; i < aksepterendeTilstander.length; i++) {
            if (currentPos == aksepterendeTilstander[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Automat i oppgave 8a Øving 10
        char[] inputAlfabet = { '0', '1' };
        int[] aksepterendeTilstander = { 2 };
        int[][] nesteTilstand = { { 1, 3 }, { 1, 2 }, { 2, 3 }, { 3, 3 } };
        Automat automat1 = new Automat(inputAlfabet, aksepterendeTilstander, nesteTilstand);
        char[] testInput1 = { '0', '1', '0' };
        char[] testInput2 = { '1', '1', '1' };
        char[] testInput3 = { '0', '1', '0', '1', '1', '0' };
        char[] testInput4 = { '0', '0', '1', '0', '0', '0' };
        System.out.println("Automat fra 8a:");
        System.out.println("    Input \"010\" gir: " + automat1.sjekkInput(testInput1));
        System.out.println("    Input \"111\" gir: " + automat1.sjekkInput(testInput2));
        System.out.println("    Input \"010110\" gir: " + automat1.sjekkInput(testInput3));
        System.out.println("    Input \"001000\" gir: " + automat1.sjekkInput(testInput4));

        // Automat i oppgave 8b Øving 10
        char[] inputAlfabet2 = { 'a', 'b' };
        int[] aksepterendeTilstander2 = { 2 };
        int[][] nesteTilstand2 = { { 3, 1 }, { 2, 4 }, { 2, 2 }, { 4, 2 }, { 4, 4 } };
        Automat automat2 = new Automat(inputAlfabet2, aksepterendeTilstander2, nesteTilstand2);
        char[] test2Input1 = { 'a', 'b', 'b', 'b' };
        char[] test2Input2 = { 'a', 'a', 'a', 'b' };
        char[] test2Input3 = { 'b', 'a', 'b', 'a', 'b' };
        System.out.println("Automat fra 8b:");
        System.out.println("    Input \"abbb\" gir: " + automat2.sjekkInput(test2Input1));
        System.out.println("    Input \"aaab\" gir: " + automat2.sjekkInput(test2Input2));
        System.out.println("    Input \"babab\" gir: " + automat2.sjekkInput(test2Input3));
    }
}