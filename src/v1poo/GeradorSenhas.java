package v1poo;

import java.util.Random;

public class GeradorSenhas {
    private static final String LETRAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUM = "0123456789";
    private static final String ESP = "!@#$%&*";
    private static Random random = new Random();

    public static String gerar(int tam, boolean usarEsp) {
        String todos = LETRAS + MAIUSCULAS + NUM;
        if (usarEsp) {
            todos += ESP;
        }

        String resultado = "";
        for (int i = 0; i < tam; i++) {
            int aleatorio = random.nextInt(todos.length());
            char caracAle = todos.charAt(aleatorio);
            resultado += caracAle;  // ← faltava isso!
        }
        return resultado;
    }

    public static String gerar(int tamanho) {
        return gerar(tamanho, true);
    }

    public static int avaliarForca(String senha) {
        int forca = 0;

        if (senha.length() >= 8) forca += 25;

        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                forca += 25;
                break;
            }
        }

        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                forca += 25;
                break;
            }
        }

        for (int i = 0; i < senha.length(); i++) {
            if (ESP.indexOf(senha.charAt(i)) != -1) {
                forca += 25;
                break;
            }
        }
        return forca;
    }

    public static boolean ehSegura(String senha) {
        return avaliarForca(senha) >= 75;
    }

    public static String gerarPin(int tamanho) {
        String pin = "";
        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(NUM.length());
            pin += NUM.charAt(indice);
        }
        return pin;
    }

    public static String gerarMemoravel() {
        String[] palavras = {"Judo", "Futsal", "Tatame", "Golpe", "Faixa"};
        int indiceSorteado = random.nextInt(palavras.length);
        return palavras[indiceSorteado] + gerarPin(4) + "!";
    }
}
