package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.Model;

import java.util.Collection;
import java.util.List;

public interface CommandAccessor<M extends Model> {
	M save(M model);
	Collection<M> save(Collection<M> models);
	void deleteById(long id);
	void deleteByIds(Collection<Long> ids);
	void deleteByUids(Collection<String> uids);
	void deleteById(List<Filter<?>> filters);
}
