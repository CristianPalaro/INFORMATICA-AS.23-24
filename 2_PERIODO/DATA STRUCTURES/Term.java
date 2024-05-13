public class Term{
    private int coef;
    private int exp;
    

    public Term(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public int getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}