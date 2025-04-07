package com.gh.archlayer.service.api;

import com.gh.archlayer.accessor.api.QueryAccessor;
import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;
import com.gh.archlayer.utils.Tuples;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractQueryService<T extends QueryModel> implements QueryService<T> {
	protected abstract QueryAccessor<T> getAccessor();

	@Override
	public Optional<T> findById(final long id) {
		return getAccessor().findById(id);
	}

	@Override
	public boolean existsById(final long id) {
		return getAccessor().existsById(id);
	}

	@Override
	public Optional<T> findByUid(final String uid) {
		return getAccessor().findByUid(uid);
	}

	@Override
	public Collection<T> findAll(final PageRequest pageRequest, final List<Filter<?>> filters) {
		Tuples.of(pageRequest, filters).t1();
		return getAccessor().findMany(pageRequest, filters);
	}

	@Override
	public Collection<T> findByIds(final Collection<Long> ids, final PageRequest pageRequest, final List<Filter<?>> filters) {
		return getAccessor().findByIds(ids, pageRequest, filters);
	}

	@Override
	public Collection<T> findByUids(final Collection<String> uids, final PageRequest pageRequest, final List<Filter<?>> filters) {
		return getAccessor().findByUids(uids, pageRequest, filters);
	}

	@Override
	public long count(final List<Filter<?>> filters) {
		return getAccessor().count(filters);
	}
}
