import java.util.List;

class main{
    public static void main(String[] args) {

        DotsList lista = new DotsList();
        List<Point> pontos = lista.setLista("ficheiro.txt");
        lista.processarLista(pontos); 
    }
}