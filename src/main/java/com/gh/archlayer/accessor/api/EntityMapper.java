package com.gh.archlayer.accessor.api;

import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.Model;

/**
 * Maps between a model and a persistence entity.
 *
 * @param <M> the type of model
 * @param <E> the type of persistence entity
 */
public interface EntityMapper<M extends Model, E extends PersistenceEntity> {
  /**
   * Converts a persistence entity into a model.
   *
   * @param entity the persistence entity to convert
   * @return the corresponding model
   */
  M toModel(E entity);

  /**
   * Converts a model into a persistence entity.
   *
   * @param model the model to convert
   * @return the corresponding persistence entity
   */
  E toEntity(M model);
}
