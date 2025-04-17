package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.api.DataService;
import com.gh.archlayer.service.model.Auditable;
import com.gh.archlayer.service.model.DataModel;
import com.gh.archlayer.service.model.Identifiable;
import java.util.function.Function;

/**
 * Abstract base class for data controllers, providing common functionality for managing data
 * models.
 *
 * @param <T> the type of transfer object
 * @param <M> the type of data model
 */
public abstract class AbstractDataController<
        T extends TransferObject & Identifiable & Auditable, M extends DataModel>
    extends AbstractQueryController<T, M> {
  /**
   * Retrieves the data service associated with this controller.
   *
   * @return An instance of DataService that provides CRUD (Create, Read, Update, Delete) operations
   *     on data models.
   */
  @Override
  public abstract DataService<M> getService();

  /**
   * Saves a transfer object to the data store.
   *
   * <p>This method first maps the transfer object to a data model using the {@link #getMapper()
   * mapper} and then saves the data model using the {@link #getService() data service}. Finally,
   * the saved data model is mapped back to a transfer object using the mapper.
   *
   * @param to the transfer object to be saved
   * @return the saved transfer object
   */
  public T save(final T to) {
    return Function.<T>identity()
        .andThen(getMapper()::toModel)
        .andThen(getService()::save)
        .andThen(getMapper()::toTransferObject)
        .apply(to);
  }

  /**
   * Deletes a data model identified by its unique ID.
   *
   * @param id the unique identifier of the data model to be deleted
   */
  public void delete(final long id) {
    getService().delete(id);
  }

  /**
   * Deletes a data model identified by its unique UID.
   *
   * @param uid the unique identifier of the data model to be deleted
   */
  public void delete(final String uid) {
    getService().delete(uid);
  }
}
