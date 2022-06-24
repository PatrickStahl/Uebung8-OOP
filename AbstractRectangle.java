interface GraphObj
{
    public void setColor(int x);
    public void show();
    public void hide();
}

interface ResizeableGO extends GraphObj
{
    public void resize(float x);
}

interface MoveableGO extends GraphObj
{
    public void move(float x, float y);
}


class Rectangle implements MoveableGO, ResizeableGO
{
    protected int color = 0;
    protected boolean visibility = false;
    protected float x;
    protected float y;
    protected float length;
    protected float height;

    Rectangle()
    {
        this.x=0;
        this.y=0;
        this.length=0;
        this.height=0;
    }

    Rectangle(float x, float y, float height, float length)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.length = length;
    }

    public void setLength(float x)
    {
        this.length = x;
    }

    public void setHeight(float x)
    {
        this.height = x;
    }

    public void setColor(int x)
    {
        this.color = x;
        System.out.println("Color changed to " + x + " !");
    }

    public void show()
    {
        this.visibility = true;
        System.out.println("Rectangle shown!");
    }

    public void hide()
    {
        this.visibility = false;
        System.out.println("Rectangle hidden!");
    }

    public void resize(float x)
    {
        length = length * x;
        height = height * x;
    }

    public void move(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public static void resizeAll(float r, ResizeableGO rgo[]) 
    {
        for (ResizeableGO g : rgo) 
        {
            g.resize(r);
        }
    }

    public static void moveAll(float dx, float dy, MoveableGO mgo[]) {
        for (MoveableGO m : mgo) 
        {
            m.move(dx, dy);
        }
        }
        
        
    public void print()
    {
        //System.out.println("Color: " + color + " Visibility: " + visibility);
        System.out.println("X: " + x + " Y: " + y + " length: " + length + " height: " + height);
    }
}

public class AbstractRectangle
{
    public static void main(String[] args) 
    {
        Rectangle rects[] = new Rectangle[3];
        rects[0] = new Rectangle();
        rects[1] = new Rectangle(3, 3, 3, 3);
        rects[2] = new Rectangle(5, 5, 5, 5);
        

        for(int i = 0; i<rects.length; i++)
        {
            rects[i].print();    
        }

        System.out.println("Calling resizeAll & moveAll...");
        
        Rectangle.resizeAll(4, rects);
        Rectangle.moveAll(6, 9, rects);

        for(int i = 0; i<rects.length; i++)
        {
            rects[i].print();    
        }

    }
}