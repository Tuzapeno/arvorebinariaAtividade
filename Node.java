public class Node {
    private int dado;
    private Node esquerda;
    private Node direita;

    public Node(int dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    public int getDado() {
        return this.dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public Node getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return this.direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }
}
