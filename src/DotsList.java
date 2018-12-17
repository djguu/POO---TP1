import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DotsList {
    public List<Point> setLista(String ficheiro){

        List<Point> pontos = null;

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("ficheiro.txt"));

            String temp;

            pontos = new ArrayList<>();

            do{
                temp = scanner.nextLine();
                String[] p1 = temp.split(",");
                try{
                    Point x = new Point(Integer.valueOf(p1[0]),Integer.valueOf(p1[1]));
                    pontos.add(x);
                }
                catch(PointNegativeException e){
                    System.out.println(e.toString() );
                    System.exit(0);
                }
            }while(scanner.hasNextLine());


            scanner.close();

            //this.maxPoints = numero;

            ConvexHull ch = new ConvexHull();
            pontos = ch.makeHull(pontos);

            return pontos;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void processarLista(List<Point> pontos){
        try{
            int maxPoints = 0;
            double perimeter = 0;

            maxPoints = pontos.size();
            if( maxPoints == 3){
                Triangulo pol = new Triangulo(pontos);
                String tipo = pol.getTriangleType();
                System.out.println("O triangulo foi do tipo " + tipo);
                perimeter = pol.getTrianglePerimeter();
                System.out.println("Perimetro: " + perimeter);
            }
            else
            if (maxPoints == 4) {
                Quadrilatero pol = new Quadrilatero(pontos);
                String tipo = pol.getQuadrilateroType();
                System.out.println("O quadrilatero foi do tipo " + tipo);
                perimeter = pol.getQuadrilateralPerimeter();
                System.out.println("Perimetro: " + perimeter);
            }
            else {
                Poligono pol = new Poligono(pontos);
            }

        }
        catch (InvalidPoligonException e){
            System.out.println(e.toString());
        }

    }
}
