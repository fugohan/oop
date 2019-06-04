package container;

public class ContainerElement<E> extends Object implements IContainerElement<E>{
    private E data;
    private IContainerElement<E> nextElement;

    public ContainerElement(E data ){
        this.data  = data;
    }
    public ContainerElement(E data, IContainerElement<E> next){
        this.data = data;
        this.nextElement= next;
    }

    @Override
    public E getData() {
        return this.data;
    }

    public void setNextElement(IContainerElement<E> next){
        this.nextElement = next;
    }

    public  boolean hasNextElement(){
        if(this.nextElement != null){
            return true;
        }
        return false;
    }

    public IContainerElement<E> getNextElement(){
       return this.nextElement.getNextElement();
    }


}
