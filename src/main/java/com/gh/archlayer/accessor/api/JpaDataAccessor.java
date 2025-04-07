package com.gh.archlayer.accessor.api;

import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.Model;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public interface JpaDataAccessor<M extends Model, E extends PersistenceEntity> extends DataAccessor<M>, JpaQueryAccessor<M, E> {
	void delete(CriteriaQuery<E> cq, List<Filter<?>> filters);
	void delete(CriteriaQuery<E> cq);
}
