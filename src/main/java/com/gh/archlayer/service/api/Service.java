package com.gh.archlayer.service.api;

import com.gh.archlayer.service.model.Model;

public interface Service<T extends Model> extends CommandService<T>, QueryService<T> {
}
