package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.DataModel;

import java.util.Collection;
import java.util.List;

public interface CommandAccessor<M extends DataModel> {
	M save(M model);
	Collection<M> save(Collection<M> models);
	void deleteById(long id);
	void deleteByUid(String uid);
	void deleteByIds(Collection<Long> ids);
	void deleteByUids(Collection<String> uids);
	void delete(List<? extends Filter<?>> filters);
}
