package com.gh.archlayer.accessor.api.impl;

import com.gh.archlayer.accessor.api.DataAccessor;
import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.DataModel;

/**
 * Abstract base class for data accessors, providing common functionality for accessing and
 * manipulating data models.
 *
 * @param <M> the type of data model that this accessor operates on
 * @param <E> the type of persistence entity that this accessor operates on
 */
public abstract class AbstractDataAccessor<M extends DataModel, E extends PersistenceEntity>
    extends AbstractQueryAccessor<M, E> implements DataAccessor<M> {}
