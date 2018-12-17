import java.util.List;

public class Triangulo extends Poligono {

    public Triangulo(List<Point> pontos) throws InvalidPoligonException {
        super(pontos);
        if(pontos.size() < 3) throw new InvalidPoligonException("O ficheiro contem pontos invalidos (precisa de ter 3 pontos distantes no minimo)\nAltere o ficheiro e reinicie o programa");
        if(pontos.size() > 4) throw new InvalidPoligonException("O poligono contem mais que 4 pontos");
    }

    public String getTriangleType(){
        String result = null;
        Point a = pontos.get(0);
        Point b = pontos.get(1);
        Point c = pontos.get(2);
        double d1 = a.distance(b);
        double d2 = a.distance(c);
        double d3 = b.distance(c);
        boolean hip = false;
        if(d1 == d2 && d2 == d3){
            result = "Equilatero";
        }
        else
        if((d1 == d2 && d2 != d3) || (d2 == d3 && d3 != d1) || (d1 == d3 && d3 != d2)){
            result = "Isosceles";
        }
        else
        if(d1 != d2 && d2 != d3){
            String h = biggestNumber(d1,d2,d3);
            switch(h){
                case "d1": hip = Hipotenusa(d1, d2, d3); break;
                case "d2": hip = Hipotenusa(d2, d1, d3); break;
                case "d3": hip = Hipotenusa(d3, d1, d2); break;
            }
            if (hip){
                result = "Rectangulo";
            }
            else{
                result = "Escaleno";
            }
        }
        return result;
    }
}

