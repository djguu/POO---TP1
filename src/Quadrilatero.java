import java.util.List;

public class Quadrilatero extends Poligono{
    public Quadrilatero(List<Point> pontos) throws InvalidPoligonException {
        super(pontos);
        if(pontos.size() < 3) throw new InvalidPoligonException("O ficheiro contem pontos invalidos (precisa de ter 3 pontos distantes no minimo)\nAltere o ficheiro e reinicie o programa");
        if(pontos.size() > 4) throw new InvalidPoligonException("O poligono contem mais que 4 pontos");
    }

    public String getQuadrilateroType(){
        String result = null;
        Point a = pontos.get(0);
        Point b = pontos.get(1);
        Point c = pontos.get(2);
        Point d = pontos.get(3);

        //Pontos Lado a lado
        double ab = a.distance(b);
        double ad = a.distance(d);
        double bc = c.distance(b);
        double cd = c.distance(d);

        //Pontos Extremos
        double ac = a.distance(c);
        double bd = b.distance(d);



        if(ab == ad && ac == bd){
            result = "Quadrado";
        }
        else
        if(ab == ad && ac != bd){
            result = "Losango";
        }
        else
        if(ab != ad){
            if(bc != ad){
                result = "Trapezio";
            }
            else{
                result = "Rectangulo";
            }
        }

        return result;
    }
}
