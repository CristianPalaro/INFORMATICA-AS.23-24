import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
    LinkedList<Term> poli_list;

    public Polynomial(Term t) {
        poli_list = new LinkedList<>();
        poli_list.add(t);
    }

    public Polynomial() {
        poli_list = new LinkedList<>();
    }

    public void add(Polynomial p){
        ListIterator<Term> it;

        for (Term term : p.poli_list) {

            it = poli_list.listIterator();
            boolean ins = false;

            while (it.hasNext() && !ins) {

                Term o = it.next();

                if(o.getExp() == term.getExp()){
                    o.setCoef(o.getCoef()+term.getCoef());
                    ins = true;
                }

                else if(o.getExp() < term.getExp()){
                    it.previous();
                    it.add(new Term(term.getCoef(), term.getExp()));
                    ins = true;
                }

                if(!ins) poli_list.addLast(new Term(term.getCoef(), term.getExp()));

            }
        }
    }


    public void subtract(Polynomial t){
        ListIterator<Term> it;

        for (Term term : t.poli_list) {

            it = poli_list.listIterator();
            boolean ins = false;

            while (it.hasNext() && !ins) {

                Term o = it.next();

                if(o.getExp() == term.getExp()){
                    o.setCoef(o.getCoef()-term.getCoef());
                    ins = true;
                }

                else if(o.getExp() < term.getExp()){
                    it.previous();
                    it.add(new Term(-term.getCoef(), term.getExp()));
                    ins = true;
                }

                if(!ins) poli_list.addLast(new Term(-term.getCoef(), term.getExp()));

            }
        }
    }


    public void multiply(Polynomial p){
        Polynomial res = new Polynomial();

        for(Term t : poli_list){
            for(Term t2 : p.poli_list){
                ListIterator<Term> it = poli_list.listIterator();
                Term ris = new Term(t.getCoef()*t2.getCoef(), t.getExp()+t2.getExp());
                Term o = it.next();
                if(o.getCoef() == ris.getCoef()){
                    o.setCoef(o.getCoef()+ris.getCoef());
                }
                else if(o.getCoef() < ris.getCoef()){
                    it.previous();
                    it.add(ris);
                }
                else{
                    it.next();
                    it.add(ris);
                }
                res.add(new Polynomial(new Term(t.getCoef()*t2.getCoef(), t.getExp()+t2.getExp())));
            }
        }
    }


    public void divide(Polynomial p){
        Polynomial res = new Polynomial();

        for(Term t : poli_list){
            for(Term t2 : p.poli_list){
                res.add(new Polynomial(new Term(t.getCoef()/t2.getCoef(), t.getExp()-t2.getExp())));
            }
        }
    }

    @Override
    public String toString() {
        String s = "";

        ListIterator<Term> it = poli_list.listIterator();
        for (Term term : poli_list) {
            if(term.getCoef()>0) s += "("+term.getCoef()+"x^"+term.getExp()+")";
            else s += "("+term.getCoef()+"x^"+term.getExp()+")";
        }

        return s;
    }

    
}
