public class ListaSequencial {
    private int[] dados;
    private int tamanho;
    private int capacidade;

    // Construtor
    public ListaSequencial(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.dados = new int[capacidade];
        this.tamanho = 0;
    }

    // Construtor padrão
    public ListaSequencial() {
        this(10); // Capacidade padrão de 10 elementos
    }

    // Inserir elemento no final da lista
    public boolean inserir(int elemento) {
        if (tamanho >= capacidade) {
            System.out.println("Lista cheia! Não é possível inserir o elemento " + elemento);
            return false;
        }

        dados[tamanho] = elemento;
        tamanho++;
        return true;
    }

    // Inserir elemento em uma posição específica (1-based)
    public boolean inserirNaPosicao(int elemento, int posicao) {
        // Posições válidas: 1 até tamanho+1
        if (posicao < 1 || posicao > tamanho + 1) {
            System.out.println("Posição inválida! (válidas: 1 até " + (tamanho + 1) + ")");
            return false;
        }
        if (tamanho >= capacidade) {
            System.out.println("Lista cheia!");
            return false;
        }
        // Desloca elementos para a direita
        for (int i = tamanho; i >= posicao; i--) {
            dados[i] = dados[i - 1];
        }
        dados[posicao - 1] = elemento;
        tamanho++;
        return true;
    }

    // Remover elemento por valor
    public boolean remover(int elemento) {
        int posicao = buscar(elemento);
        if (posicao == -1) {
            System.out.println("Elemento " + elemento + " não encontrado!");
            return false;
        }

        return removerNaPosicao(posicao);
    }

    // Remover elemento em uma posição específica (1-based)
    public boolean removerNaPosicao(int posicao) {
        // Posições válidas: 1 até tamanho
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida! (válidas: 1 até " + tamanho + ")");
            return false;
        }
        // Desloca elementos para a esquerda
        for (int i = posicao - 1; i < tamanho - 1; i++) {
            dados[i] = dados[i + 1];
        }
        tamanho--;
        return true;
    }

    // Buscar elemento (retorna a posição ou -1 se não encontrado)
    public int buscar(int elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    // Obter elemento em uma posição (1-based)
    public int obter(int posicao) {
        if (posicao < 1 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao + " (válidas: 1 até " + tamanho + ")");
        }
        return dados[posicao - 1];
    }

    // Modificar elemento em uma posição (1-based)
    public boolean modificar(int posicao, int novoValor) {
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida! (válidas: 1 até " + tamanho + ")");
            return false;
        }
        dados[posicao - 1] = novoValor;
        return true;
    }

    // Verificar se a lista está vazia
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Verificar se a lista está cheia
    public boolean estaCheia() {
        return tamanho >= capacidade;
    }

    // Obter o tamanho atual da lista
    public int getTamanho() {
        return tamanho;
    }

    // Obter a capacidade máxima da lista
    public int getCapacidade() {
        return capacidade;
    }

    // Limpar a lista
    public void limpar() {
        tamanho = 0;
    }

    // Exibir a lista
    public void exibir() {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }

        System.out.print("Lista: [");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(dados[i]);
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método toString para representação da lista
    @Override
    public String toString() {
        if (estaVazia()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}