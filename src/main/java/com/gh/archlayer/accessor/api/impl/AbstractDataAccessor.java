package com.gh.archlayer.accessor.api.impl;

import com.gh.archlayer.accessor.api.DataAccessor;
import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.DataModel;

public abstract class AbstractDataAccessor<M extends DataModel, E extends PersistenceEntity>
		extends AbstractQueryAccessor<M, E>
		implements DataAccessor<M> {

}
