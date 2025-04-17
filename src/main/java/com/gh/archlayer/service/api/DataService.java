package com.gh.archlayer.service.api;

import com.gh.archlayer.service.model.DataModel;

/**
 * This interface defines the contract for a data service, which is responsible for managing data
 * models.
 *
 * @param <T> the type of data model that this service operates on
 */
public interface DataService<T extends DataModel> extends CommandService<T>, QueryService<T> {}
