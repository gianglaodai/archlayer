package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.model.DataModel;

public interface DataAccessor<M extends DataModel> extends QueryAccessor<M>, CommandAccessor<M> {
}
