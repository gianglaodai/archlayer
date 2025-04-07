package com.gh.archlayer.accessor.api;

import com.gh.archlayer.accessor.model.PersistenceEntity;
import com.gh.archlayer.service.model.QueryModel;

public interface EntityMapper<M extends QueryModel, E extends PersistenceEntity> {
	M toModel(E entity);
	E toEntity(M model);
}
