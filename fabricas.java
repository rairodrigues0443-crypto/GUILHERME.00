public class FabricaDePadroes {

    public static void main(String[] args) {
        int n = 5;
        
        System.out.println("=== TRIÂNGULO ===");
        // triângulo crescente
        for (int linha = 1; linha <= n; linha++) {
            for (int espacos = 0; espacos < n - linha; espacos++) {
                System.out.print(' ');
            }
            for (int estrelas = 0; estrelas < linha; estrelas++) {
                System.out.print('*');
            }
            System.out.println();
        }
        
        System.out.println("\n=== TRIÂNGULO INVERTIDO ===");
        // triângulo invertido
        for (int linha = n; linha >= 1; linha--) {
            for (int espacos = 0; espacos < n - linha; espacos++) {
                System.out.print(' ');
            }
            for (int estrelas = 0; estrelas < linha; estrelas++) {
                System.out.print('*');
            }
            System.out.println();
        }
        
        System.out.println("\n=== LOSANGO ===");
        // losango com base 2*n-1
        int largura = 2 * n - 1;
        for (int linha = 1; linha <= n; linha++) {
            int estrelas = 2 * linha - 1;
            int espacos = (largura - estrelas) / 2;
            for (int i = 0; i < espacos; i++) {
                System.out.print(' ');
            }
            for (int i = 0; i < estrelas; i++) {
                System.out.print('*');
            }
            System.out.println();
        }
        for (int linha = n - 1; linha >= 1; linha--) {
            int estrelas = 2 * linha - 1;
            int espacos = (largura - estrelas) / 2;
            for (int i = 0; i < espacos; i++) {
                System.out.print(' ');
            }
            for (int i = 0; i < estrelas; i++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
