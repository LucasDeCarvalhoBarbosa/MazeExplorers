package Control;

/**
 *
 * @author Lucas Barbosa
 */
public class Ponto {
    
    private float x;
    private float y;
    
    public Ponto(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "(x="+x+", y="+y+")";
    }
    
    //gets e sets
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    
    
}
