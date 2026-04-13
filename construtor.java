public class Personagem {
    // Atributos privados
    private final String nome;
    private int vida;
    private final int ataque;

    // Construtor
    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = Math.max(1, vida);
        this.ataque = Math.max(0, ataque);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    // Setter para vida
    public void setVida(int vida) {
        this.vida = Math.max(0, vida);
    }

    // toString
    @Override
    public String toString() {
        return "[" + nome + "] Vida: " + vida + " | Ataque: " + ataque;
    }

    public static void main(String[] args) {
        Personagem p = new Personagem("Guerreiro", 100, 25);
        System.out.println(p); // Deve imprimir: [Guerreiro] Vida: 100 | Ataque: 25
        
        p.setVida(-10);
        System.out.println("Vida após set negativo: " + p.getVida()); // Deve ser 0
        
        p.setVida(50);
        System.out.println("Vida após set válido: " + p.getVida()); // Deve ser 50
    }
}
