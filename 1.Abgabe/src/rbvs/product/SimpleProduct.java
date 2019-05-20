package rbvs.product;

public class SimpleProduct extends Product{
    public SimpleProduct(String name, float price){
        super(name,price);
    }

    @Override
    public Product deepCopy() {
        //TODO: Methode fertig schreiben (dONE)
        Product temp = this;
        // Bin mir nicht sicher wie es funktioniert

        /*
            Description copied from interface: IDeepCopy
        Creates and returns a copy of this object by either invoking a private copy constructor, or by creating a new object of the same class and setting its values accordingly. The precise meaning of "copy" may depend on the class of the object. The general intent is that, for any object x, the expression:
         x.deepCopy() != x

        will be true, and that the expression:
         x.deepCopy().getClass() == x.getClass()

        will be true, but these are not absolute requirements.
        While it is typically the case that:

         x.deepCopy().equals(x)

        will be true, this is not an absolute requirement.

         */
        return temp;
    }
}
