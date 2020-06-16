package util.searchable;

public class TextSearchIgnoreCaseFilter extends Object implements ISearchFilter {
    public TextSearchIgnoreCaseFilter(){}

    public boolean searchFilterFunction(Object originalObject, Object compareObject){
        if (originalObject.toString() != null){
            if(compareObject.toString() != null){
                if(originalObject.toString().equals(compareObject.toString())){
                    return true;
                }
            }
        }
        return false;
    }
}
