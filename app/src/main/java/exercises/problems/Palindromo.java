package exercises.problems;

public class Palindromo {
    public boolean IsPalindromo(String palavra) {
        StringBuilder palindromo = new StringBuilder();
        
        String s = palavra.toLowerCase();

        for (int i = s.length() - 1; i >= 0; i--) /* indice final até 0 */ {
            char c = s.charAt(i);
            palindromo.append(c);
        }

        if (s.equals(palindromo.toString())) {
            return true;
        }
        return false;
    }

    public boolean IsPalindromoRecursivo(String palavra) {        
        String s = palavra.toLowerCase();

        if (s.length() == 1) {
            return true;
        }

        if (s.length() > 1) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(-1);

            // checa se a primeira letra e a ultima são iguais
            if (c1 != c2) {
                return false;
            }

            // tira cl e c2 e repete o loop
            String substring = s.substring(1, -2);

            IsPalindromoRecursivo(substring); // vai repetindo o loop, até dar false ou ele reduzir a 1 char e então dar true
        }

        return true;
    }
}
