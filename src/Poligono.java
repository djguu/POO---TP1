import java.util.List;

public class Poligono {

    public List<Point> pontos;


    public Poligono(List<Point> pontos) throws InvalidPoligonException {
        if(pontos.size() < 3) throw new InvalidPoligonException("O ficheiro contem pontos invalidos (precisa de ter 3 pontos distantes no minimo)\nAltere o ficheiro e reinicie o programa");
        if(pontos.size() > 4) throw new InvalidPoligonException("O poligono contem mais que 4 pontos");
        this.pontos = pontos;
    }


    public String biggestNumber(double n1, double n2, double n3){
        double x = n1;
        double y = n2;
        double z = n3;

        if (x > y && x > z)
            return "d1";
        else if (y > x && y > z)
            return "d2";
        else if (z > x && z > y)
            return "d3";
        return "false";
    }

    public boolean Hipotenusa(double h, double c1, double c2){
        double temp = Math.sqrt(Math.pow(c1,2) + Math.pow(c2,2));

        if(temp == h){
            return true;
        }
        return false;
    }

}


