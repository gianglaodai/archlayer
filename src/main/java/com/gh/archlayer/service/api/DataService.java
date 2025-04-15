package com.gh.archlayer.service.api;

import com.gh.archlayer.service.model.DataModel;

public interface DataService<T extends DataModel> extends CommandService<T>, QueryService<T> {}
