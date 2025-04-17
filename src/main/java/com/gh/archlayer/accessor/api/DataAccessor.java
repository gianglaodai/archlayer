package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.model.DataModel;

/**
 * This interface defines the contract for a data accessor, which is responsible for accessing and
 * manipulating data models.
 *
 * @param <M> the type of data model that this accessor operates on
 */
public interface DataAccessor<M extends DataModel> extends QueryAccessor<M>, CommandAccessor<M> {}
