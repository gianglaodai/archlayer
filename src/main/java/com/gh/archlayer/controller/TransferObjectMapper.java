package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.model.QueryModel;

public interface TransferObjectMapper<T extends TransferObject, M extends QueryModel> {
  M toModel(T to);

  T toTransferObject(M model);
}
