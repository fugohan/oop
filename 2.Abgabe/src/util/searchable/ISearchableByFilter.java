package util.searchable;

import java.util.Collection;

public interface ISearchableByFilter<T>{

    Collection<T> searchByFilter(ISearchableByFilter filter, Object compareObject);
}
