import java.lang.reflect.Field;

public class fuga {

    public static void main(String[] args) {
        System.out.println("--- INICIANDO PROTOCOLO DE FUGA ---");

        // NODO 1: O Labirinto de Tipos
        // Objetivo: Ajuste as variáveis para que o resultado da soma seja 12.5
        int a = 5;
        int b = 2;
        double resultadoNodo1 = (double) a / b; // CORRIGIDO: Cast para double evita divisão inteira
        
        if (resultadoNodo1 + 10 == 12.5) {
            System.out.println("[NODO 1] Desbloqueado!");
        }

        // NODO 2: A Maldição do NullPointer
        // Objetivo: Corrija o IF para que ele não quebre, mesmo que o username seja null
        String username = null; 
        
        // CORRIGIDO: Usa equals com string literal para evitar NullPointerException
        boolean acessoGarantido = "admin".equals(username); 
        
        if (acessoGarantido) {
            System.out.println("[NODO 2] Desbloqueado!");
        }

        // NODO 3: O Enigma da Recursão
        // Objetivo: Implemente o retorno da função para que enigma(5) retorne 9
        int resultadoNodo3 = enigma(5);
        if (resultadoNodo3 == 9) {
            System.out.println("[NODO 3] Desbloqueado!");
        }

        // NODO FINAL: A Chave de Prata
        // Objetivo: Use Reflection para ler o valor da variável privada 'segredo'
        try {
            Porta porta = new Porta();
            Field field = Porta.class.getDeclaredField("segredo");
            
            // CORRIGIDO: Adiciona setAccessible(true) para acessar o campo privado
            field.setAccessible(true);
            
            String chave = (String) field.get(porta);
            
            if (chave.equals("LIBERDADE_2026")) {
                System.out.println("[FINAL] Porta aberta! ACESSO LIBERADO.");
            }
        } catch (Exception e) {
            System.out.println("[ERRO] A porta continua trancada...");
        }
    }

    public static int enigma(int n) {
        // CORRIGIDO: Implementa recursão que soma n + (n-2) + (n-4)... até n <= 1
        if (n <= 1) {
            return n;
        }
        return n + enigma(n - 2);
    }
}

class Porta {
    private String segredo = "LIBERDADE_2026";
    public Porta() {} 
}
