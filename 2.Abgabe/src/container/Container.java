package container;

import java.util.Collection;

public class Container extends Object implements Collection<E> {

    private IContainerElement<E> firstElement;

    public Container(){
        this.firstElement = null;
    }


    @Override
    public int size() {

        return 0;
    }

    @Override
    public boolean isEmpty() {
        if(this.firstElement == null){
            return true;
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {

        if(this.contains(o)==true){
            return true;
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr<E>(this.firstElement);

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(E e) {
        IContainerElement<E> temp = new ContainerElement<E>(e);
        if(e == null){
            throw new NullPointerException();
        }
        if(this.firstElement == null){
            this.firstElement = temp;
            return true;
        }
        if(this.firstElement != null){
            IContainerElement here = this.firstElement;
            while (here.hasNextElement()==true){
               if(here.hasNextElement() == true){
                   here = here.getNextElement();
               }
               else{
                   here.setNextElement(temp);
                   return true;
               }
            }
        }


        return false;
    }



    @Override
    public boolean remove(Object o) {
        IContainerElement<E> here = this.firstElement;
        if(here == null)
            return false;

        if(here.hasNextElement()){
            if(here.equals(o)) {
                IContainerElement temp = here.getNextElement();
                here = temp;
                return true;
            }
            while(here.hasNextElement()){

                if(o.equals(here.getNextElement())!=true){
                    here = here.getNextElement();
                }
                else{
                    here.setNextElement(here.getNextElement());
                }
                here = here.getNextElement();
            }
        }
        else{
            if(here.equals(o)) {
                here = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(E i:collection){
            if(this.contains(i)){
                return true;
            }
        }

        return false;
    }

    public E get(int index){
        if(index < 0 || index > this.size()){
            throw new IndexOutOfBoundsException();
        }
        IContainerElement<E> here = this;
        for(i=0; i<index;i++){
            here = here.getNextElement();
        }
        return here.getData();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {

        for(E i:collection){
            this.add(i);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
       boolean Change = false;
       for (Object temp:c){
           if(this.remove(temp)){
               Change = true;
           }
       }
       return Change;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not supported by Container");
    }

    @Override
    public void clear() {
        this.firstElement = null;
    }
}
