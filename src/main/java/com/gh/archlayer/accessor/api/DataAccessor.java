package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.model.Model;

public interface DataAccessor<M extends Model> extends QueryAccessor<M>, CommandAccessor<M> {
}
