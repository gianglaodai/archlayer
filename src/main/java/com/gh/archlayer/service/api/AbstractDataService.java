package com.gh.archlayer.service.api;

import com.gh.archlayer.accessor.api.DataAccessor;
import com.gh.archlayer.service.model.Model;

import java.util.Objects;

public abstract class AbstractDataService<T extends Model> extends AbstractQueryService<T> implements DataService<T> {
	@Override
	public abstract DataAccessor<T> getAccessor();
	public T create(final T entity) {
		return getAccessor().save(entity);
	}

	public T update(final T entity) {
		return getAccessor().save(entity);
	}

	@Override
	public T save(final T entity) {
		if(Objects.isNull(entity.getId())) {
			return create(entity);
		}
		if(!getAccessor().existsById(entity.getId())){
			throw new RuntimeException("No entity found with id: " + entity.getId());
		}
		return update(entity);
	}

	@Override
	public void delete(final long id) {
		getAccessor().deleteById(id);
	}

}
