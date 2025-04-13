package com.gh.archlayer.accessor.api.impl;

import com.gh.archlayer.accessor.api.DataAccessor;
import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.Model;

public abstract class AbstractDataAccessor<M extends Model, E extends PersistenceEntity>
		extends AbstractQueryAccessor<M, E>
		implements DataAccessor<M> {

}
