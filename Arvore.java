public class Arvore {
    private Node raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return this.raiz;
    }

    public void insere(int valor) {
        // Arvore vazia
        if (this.raiz == null) {
            Node novoNode = new Node(valor);
            this.raiz = novoNode;
        } 
        else {
            Node atual = this.raiz;
            Node pai = null;
            boolean esquerda = false;
            while (atual != null) {
                pai = atual;
                if (valor < atual.getDado()) {
                    atual = atual.getEsquerda();
                    esquerda = true;
                }
                else {
                    atual = atual.getDireita();
                    esquerda = false;
                }
            }
            if (esquerda)
                pai.setEsquerda(new Node(valor));
            else 
                pai.setDireita(new Node(valor));
        }    
    }

    public void imprimeEmOrdem(Node raiz) {
        if (raiz == null) {
            return;
        }
        else {
            imprimeEmOrdem(raiz.getEsquerda());
            System.out.print(raiz.getDado() + "");
            imprimeEmOrdem(raiz.getDireita());
        }
    }

    public Node acharMenor(Node raiz) {
        if (raiz.getEsquerda() == null) {
            return raiz;
        }
        else {
            return acharMenor(raiz.getEsquerda());
        }
    }

    public Node removerN(Node raiz, int valor) {
        if (raiz == null) {
            return null;
        }

        if (valor < raiz.getDado()) {
            raiz.setEsquerda(removerN(raiz.getEsquerda(), valor));
        }
        else if (valor > raiz.getDado()) {
            raiz.setDireita(removerN(raiz.getDireita(), valor));
        }
        else {
            // nó sem filho
            if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                return null;
            }
            // nó com 1 filho na direita
            if (raiz.getEsquerda() == null && raiz.getDireita() != null) 
                return raiz.getDireita();
            // nó com 1 filho na esquerda
            if (raiz.getDireita() == null && raiz.getEsquerda() != null) 
                return raiz.getEsquerda();
            // nó com 2 filhos
            raiz.setDado(acharMenor(raiz.getDireita()).getDado());
            raiz.setDireita(removerN(raiz.getDireita(), raiz.getDado()));
        }
        return raiz;
    }
    
    public Node buscar(int elemento) {
        Node atual = this.raiz;
        while (atual != null && atual.getDado() != elemento) {
            if (elemento < atual.getDado()) {
                atual = atual.getEsquerda();
            }
            else {
                atual = atual.getDireita();
            }
        }
        return null;
    }

    public void printTree() {
        printTreeHelper(this.raiz, 0);
    }

    private void printTreeHelper(Node node, int space) {
        if (node == null) {
            return;
        }

        space += 10;

        printTreeHelper(node.getDireita(), space);

        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }

        System.out.println(node.getDado());

        printTreeHelper(node.getEsquerda(), space);
    }
}


