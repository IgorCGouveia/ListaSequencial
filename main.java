import java.util.Scanner;

public class main {
    
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a capacidade inicial da lista: ");
        int capacidade = scanner.nextInt();
        ListaSequencial lista = new ListaSequencial(capacidade);
        
        int opcao;
        
        do {
            System.out.println("\n========================================");
            System.out.println("         LISTA SEQUENCIAL");
            System.out.println("========================================");
            System.out.println("Lista atual: " + lista.toString());
            System.out.println("Tamanho: " + lista.getTamanho() + "/" + lista.getCapacidade());
            System.out.println("----------------------------------------");
            System.out.println("1.  Inserir elemento no final");
            System.out.println("2.  Inserir elemento em posição específica");
            System.out.println("3.  Remover elemento por valor");
            System.out.println("4.  Remover elemento por posição");
            System.out.println("5.  Buscar elemento");
            System.out.println("6.  Obter elemento em posição");
            System.out.println("7.  Verificar se está vazia");
            System.out.println("8.  Verificar se está cheia");
            System.out.println("9.  Exibir lista completa");
            System.out.println("10. Limpar lista");
            System.out.println("11. Mostrar informações da lista");
            System.out.println("0.  Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a inserir: ");
                    int elemento = scanner.nextInt();
                    if (lista.inserir(elemento)) {
                        System.out.println("✓ Elemento " + elemento + " inserido com sucesso!");
                    } else {
                        System.out.println("✗ Falha ao inserir elemento!");
                    }
                    break;
                
                case 2:
                    System.out.print("Digite o elemento a inserir: ");
                    elemento = scanner.nextInt();
                    System.out.print("Digite a posição (0 a " + lista.getTamanho() + "): ");
                    int posicao = scanner.nextInt();
                    if (lista.inserirNaPosicao(elemento, posicao)) {
                        System.out.println("✓ Elemento " + elemento + " inserido na posição " + posicao + "!");
                    } else {
                        System.out.println("✗ Falha ao inserir elemento!");
                    }
                    break;
                
                case 3:
                    System.out.print("Digite o elemento a remover: ");
                    elemento = scanner.nextInt();
                    if (lista.remover(elemento)) {
                        System.out.println("✓ Elemento " + elemento + " removido com sucesso!");
                    } else {
                        System.out.println("✗ Elemento não encontrado ou erro na remoção!");
                    }
                    break;
                
                case 4:
                    if (lista.estaVazia()) {
                        System.out.println("✗ Lista está vazia!");
                        break;
                    }
                    System.out.print("Digite a posição a remover (0 a " + (lista.getTamanho() - 1) + "): ");
                    posicao = scanner.nextInt();
                    if (lista.removerNaPosicao(posicao)) {
                        System.out.println("✓ Elemento removido da posição " + posicao + "!");
                    } else {
                        System.out.println("✗ Falha ao remover elemento!");
                    }
                    break;
                
                case 5:
                    System.out.print("Digite o elemento a buscar: ");
                    elemento = scanner.nextInt();
                    posicao = lista.buscar(elemento);
                    if (posicao != -1) {
                        System.out.println("✓ Elemento " + elemento + " encontrado na posição " + posicao);
                    } else {
                        System.out.println("✗ Elemento " + elemento + " não encontrado na lista");
                    }
                    break;
                
                case 6:
                    if (lista.estaVazia()) {
                        System.out.println("✗ Lista está vazia!");
                        break;
                    }
                    System.out.print("Digite a posição (0 a " + (lista.getTamanho() - 1) + "): ");
                    posicao = scanner.nextInt();
                    try {
                        elemento = lista.obter(posicao);
                        System.out.println("✓ Elemento na posição " + posicao + ": " + elemento);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("✗ " + e.getMessage());
                    }
                    break;
                
                case 7:
                    if (lista.estaVazia()) {
                        System.out.println("✓ A lista está vazia");
                    } else {
                        System.out.println("✗ A lista NÃO está vazia");
                    }
                    break;
                
                case 8:
                    if (lista.estaCheia()) {
                        System.out.println("✓ A lista está cheia");
                    } else {
                        System.out.println("✗ A lista NÃO está cheia");
                    }
                    break;
                
                case 9:
                    System.out.println("Lista completa:");
                    lista.exibir();
                    break;
                
                case 10:
                    lista.limpar();
                    System.out.println("✓ Lista limpa com sucesso!");
                    break;
                
                case 11:
                    System.out.println("\n--- Informações da Lista ---");
                    System.out.println("Capacidade máxima: " + lista.getCapacidade());
                    System.out.println("Tamanho atual: " + lista.getTamanho());
                    System.out.println("Espaços livres: " + (lista.getCapacidade() - lista.getTamanho()));
                    System.out.println("Está vazia? " + (lista.estaVazia() ? "Sim" : "Não"));
                    System.out.println("Está cheia? " + (lista.estaCheia() ? "Sim" : "Não"));
                    System.out.println("Lista atual: " + lista.toString());
                    break;
                
                case 0:
                    System.out.println("Encerrando o programa...");
                    System.out.println("Lista final: " + lista.toString());
                    break;
                
                default:
                    System.out.println("✗ Opção inválida! Tente novamente.");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine(); // Limpa o buffer
                scanner.nextLine(); // Espera Enter
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
}
