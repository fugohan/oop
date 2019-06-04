package container;

import java.util.Iterator;

public class Itr<E> extends Object implements Iterator<E> {
    private IContainerElement<E> next;

    public Itr(IContainerElement<E> firstelement){
        this.next = firstelement;
    }

    public E next(){
        return (E) this.next.getNextElement();
    }

    public  boolean hasNext(){
        if( this.next.getNextElement() != null){
            return true;
        }
        return false;
    }

    public void remove(){
        throw new UnsupportedOperationException("Not supported");
    }
}
