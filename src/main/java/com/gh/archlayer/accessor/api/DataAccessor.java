package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.Model;

import java.util.Collection;
import java.util.List;

public interface DataAccessor<M extends Model> extends QueryAccessor<M> {
	enum PersistenceControl {
		NONE,
		FLUSH,
		FLUSH_AND_CLEAR
	}
	M save(M model);
	M save(M model, PersistenceControl persistenceControl);
	Collection<M> save(Collection<M> models);
	Collection<M> save(Collection<M> models, PersistenceControl persistenceControl);
	void deleteById(long id);
	void deleteById(long id, PersistenceControl persistenceControl);
	void deleteByIds(Collection<Long> ids);
	void deleteByIds(Collection<Long> ids, PersistenceControl persistenceControl);
	void deleteByUids(Collection<String> uids);
	void deleteByUids(Collection<String> uids, PersistenceControl persistenceControl);
	void deleteById(List<Filter<?>> filters);
}
