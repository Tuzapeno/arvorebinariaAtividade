public class ArvoreAVL {
    private Node raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Node no) {
        this.raiz = no;
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
        // Balanceia a árvore após inserção
        this.raiz = balancear(this.raiz);
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
        return balancear(raiz);
    }


    public static int altura(Node no) {
        if (no == null)
            return -1;
        int esquerda = altura(no.getEsquerda());
        int direita = altura(no.getDireita());
        if( esquerda > direita )
            return 1 + esquerda;
        return 1 + direita;
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

    public int fatorBalanceamento(Node no) {
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    public void achaDesbalanceamento(Node raiz) {
        if (raiz == null) {
            return;
        }
        
        System.out.println("FB Node(" + raiz.getDado() + "): " + fatorBalanceamento(raiz));
        achaDesbalanceamento(raiz.getEsquerda());
        achaDesbalanceamento(raiz.getDireita());
    }


    public Node rotacaoSimplesEsquerda(Node raiz) {
        Node novaRaiz = raiz.getDireita();
        Node temp = novaRaiz.getEsquerda();
        novaRaiz.setEsquerda(raiz);
        raiz.setDireita(temp);

        return novaRaiz;
    }

    public Node rotacaoSimplesDireita(Node raiz) {
        Node novaRaiz = raiz.getEsquerda();
        Node temp = novaRaiz.getDireita();
        novaRaiz.setDireita(raiz);
        raiz.setEsquerda(temp);

        return novaRaiz;
    }

    public Node balancear(Node raiz) {
        if (raiz == null) {
            return null;
        }

        // Balancear subárvore da esquerda
        raiz.setEsquerda(balancear(raiz.getEsquerda()));

        // Balancear subárvore da direita
        raiz.setDireita(balancear(raiz.getDireita()));

        int fb = fatorBalanceamento(raiz);

        // Se o desbalanceamento é na subárvore da esquerda
        if (fb > 1) {
            // Rotação simples à direita ou rotação dupla à direita
            if (fatorBalanceamento(raiz.getEsquerda()) < 0) {
                raiz.setEsquerda(rotacaoSimplesEsquerda(raiz.getEsquerda()));
            }
            raiz = rotacaoSimplesDireita(raiz);
        }
        
        // Se o desbalanceamento é na subárvore da direita
        if (fb < -1) {
            // Rotação simples à esquerda ou rotação dupla à esquerda
            if (fatorBalanceamento(raiz.getDireita()) > 0) {
                raiz.setDireita(rotacaoSimplesDireita(raiz.getDireita()));
            }
            raiz = rotacaoSimplesEsquerda(raiz);
        }

        return raiz;
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


