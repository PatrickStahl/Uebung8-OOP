abstract class Behaeltnis
{
    abstract void println();
    abstract double volumen();
}

class Tetrapack extends Behaeltnis
{
    protected double length;
    protected double width;
    protected double height;

    Tetrapack(double length, double width, double height)
    {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    @Override
    public void println() 
    {
        System.out.println("Tetrapack mit Kanten " + length + ", " + width + ", " + height);
    }

    @Override
    public double volumen()
    {
        return this.length * this.height * this.width;
    }
}

class Dose extends Behaeltnis
{
    protected double radius;
    protected double height;

    Dose(double radius, double height)
    {
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public void println()
    {
        System.out.println("Dose mit der Fläche " + radius + " und Höhe " + height);
    }

    @Override
    public double volumen()
    {
        return this.radius *  this.height;
    }
}


public class Auftragsabwicklung {
    public static void main(String args[]) 
    {
        final double produktion = 200; 
        Behaeltnis[] bestellung = {
        new Tetrapack(2.3, 0.9, 0.7), new Dose(1.09 , 1.15),
        new Dose(1.09 , 1.15), new Tetrapack(1.1, 0.7, 0.7) // ...
        };
        
        for (int i = 0; i < bestellung.length; i++) 
        {
            bestellung[i].println();
        }
        
        double sumVolume = 0;
        for(int i = 0; i < bestellung.length; i++)
        {
            sumVolume += bestellung[i].volumen();
        }

        //das Rundet irgendwie auf 2 Nachkommastellen kp
        //und die Werte im Beispiel machen keinen Sinn
        System.out.println("Gesamtvolumen der Bestellung: " + Math.round(sumVolume*100.0)/100.0);
        System.out.println("Gesamtvolumen der Bestellung: " + Math.round((produktion-sumVolume)*100.0)/100.0);
        

        
    }
    }
    