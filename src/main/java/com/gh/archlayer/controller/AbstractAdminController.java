package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.api.DataService;
import com.gh.archlayer.service.model.Auditable;
import com.gh.archlayer.service.model.DataModel;
import com.gh.archlayer.service.model.Identifiable;

public abstract class AbstractAdminController<
    T extends TransferObject & Identifiable & Auditable, M extends DataModel> {
  public abstract DataService<M> getService();

  public abstract TransferObjectMapper<T, M> getMapper();
}
