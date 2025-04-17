package com.gh.archlayer.accessor.api.impl;

import com.gh.archlayer.accessor.api.EntityMapper;
import com.gh.archlayer.accessor.api.QueryAccessor;
import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.QueryModel;

/**
 * Abstract base class for query accessors, providing common functionality for accessing and
 * manipulating query models.
 *
 * @param <M> the type of query model
 * @param <E> the type of persistence entity
 */
public abstract class AbstractQueryAccessor<M extends QueryModel, E extends PersistenceEntity>
    implements QueryAccessor<M> {
  /**
   * Get the class of the entity that is associated with this query accessor.
   *
   * @return The class of the entity that is associated with this query accessor.
   */
  public abstract Class<E> getEntityClass();

  /**
   * Retrieves the entity mapper associated with this query accessor.
   *
   * @return An instance of EntityMapper that facilitates the conversion between models and
   *     persistence entities.
   */
  public abstract EntityMapper<M, E> getMapper();
}
