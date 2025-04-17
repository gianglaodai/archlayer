package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.model.Model;

/**
 * This interface defines a mapper that can convert between TransferObjects and Models.
 * Implementations of this interface should provide the necessary logic to perform the conversion.
 *
 * @param <T> the type of TransferObject
 * @param <M> the type of Model
 */
public interface TransferObjectMapper<T extends TransferObject, M extends Model> {
  /**
   * Converts a TransferObject into a Model.
   *
   * @param to the TransferObject to convert
   * @return the corresponding Model
   */
  M toModel(T to);

  /**
   * Converts a Model into a TransferObject.
   *
   * @param model the Model to convert
   * @return the corresponding TransferObject
   */
  T toTransferObject(M model);
}
