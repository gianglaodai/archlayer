package com.gh.archlayer.accessor.api.impl;

import com.gh.archlayer.accessor.api.EntityMapper;
import com.gh.archlayer.accessor.api.QueryAccessor;
import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.QueryModel;

public abstract class AbstractQueryAccessor<M extends QueryModel, E extends PersistenceEntity>
    implements QueryAccessor<M> {
  public abstract Class<E> getEntityClass();

  public abstract EntityMapper<M, E> getMapper();
}
