import java.util.Random;
import java.util.Scanner;

public class App {

    public static void printArvore(ArvoreAVL arvore) {
        System.out.println("\n\n");
        arvore.printTree();
        System.out.println("\n\n");
    }

    public static void printArvore(Arvore arvore) {
        System.out.println("\n\n");
        arvore.printTree();
        System.out.println("\n\n");
    }

    // arvore ****************************************************************************************************
    
    public static void testar_insercao_arvore(Arvore arvore, int n) {
        Random rand = new Random();
        long tempoinicial= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arvore.insere(rand.nextInt(100));
        }
        long tempofinal = System.currentTimeMillis();
        System.out.println("Tempo de insercao: " + (tempofinal - tempoinicial) + " ms");  
    }

    public static void testar_busca_arvore(Arvore arvore, int n) {
        Random rand = new Random();
        long tempoinicial= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arvore.buscar(rand.nextInt(100));
        }
        long tempofinal = System.currentTimeMillis();
        System.out.println("Tempo de busca: " + (tempofinal - tempoinicial) + " ms");  
    }

    public static void testar_remocao_arvore(Arvore arvore, int n) {
        Random rand = new Random();
        long tempoinicial= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arvore.removerN(arvore.getRaiz(), rand.nextInt(100));
        }
        long tempofinal = System.currentTimeMillis();
        System.out.println("Tempo de remocao: " + (tempofinal - tempoinicial) + " ms");  
    }

    // arvore AVL ************************************************************************************************

    public static void testar_insercao_arvore(ArvoreAVL arvore, int n) {
        Random rand = new Random();
        long tempoinicial= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arvore.insere(rand.nextInt(100));
        }
        long tempofinal = System.currentTimeMillis();
        System.out.println("Tempo de insercao (AVL): " + (tempofinal - tempoinicial) + " ms");  
    }

    public static void testar_busca_arvore(ArvoreAVL arvore, int n) {
        Random rand = new Random();
        long tempoinicial= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arvore.buscar(rand.nextInt(100));
        }
        long tempofinal = System.currentTimeMillis();
        System.out.println("Tempo de busca (AVL): " + (tempofinal - tempoinicial) + " ms");  
    }

    public static void testar_remocao_arvore(ArvoreAVL arvore, int n) {
        Random rand = new Random();
        long tempoinicial= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arvore.removerN(arvore.getRaiz(), rand.nextInt(100));
        }
        long tempofinal = System.currentTimeMillis();
        System.out.println("Tempo de remocao (AVL): " + (tempofinal - tempoinicial) + " ms");  
    }


    public static void main(String[] args) {
        // random, input e arvore
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero de elementos: ");
        int n = scanner.nextInt();

        Arvore arvore = new Arvore();
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        // testar inserção
        testar_insercao_arvore(arvore, n);
        // testar busca
        testar_busca_arvore(arvore, n);
        // testar remoção
        testar_remocao_arvore(arvore, n);

        System.out.println("\n");

        // testar inserção AVL
        testar_insercao_arvore(arvoreAVL, n);
        // testar busca
        testar_busca_arvore(arvoreAVL, n);
        // testar remoção
        testar_remocao_arvore(arvoreAVL, n);


        
        scanner.close();

    }

}
