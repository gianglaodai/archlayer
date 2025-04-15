package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.api.DataService;
import com.gh.archlayer.service.model.Auditable;
import com.gh.archlayer.service.model.DataModel;
import com.gh.archlayer.service.model.Identifiable;

public abstract class AbstractDataController<
        T extends TransferObject & Identifiable & Auditable, M extends DataModel>
    extends AbstractQueryController<T, M> {
  @Override
  public abstract DataService<M> getService();

  public T save(final T transferObject) {
    return getMapper().toTransferObject(getService().save(getMapper().toModel(transferObject)));
  }

  public void delete(final long id) {
    getService().delete(id);
  }

  public void delete(final String uid) {
    getService().delete(uid);
  }
}
