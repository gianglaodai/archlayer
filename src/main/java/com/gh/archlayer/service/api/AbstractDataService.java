package com.gh.archlayer.service.api;

import com.gh.archlayer.accessor.api.DataAccessor;
import com.gh.archlayer.service.model.DataModel;

/**
 * Abstract base class for data services, providing common functionality for managing data models.
 *
 * @param <T> the type of data model that this service operates on
 */
public abstract class AbstractDataService<T extends DataModel> extends AbstractQueryService<T>
    implements DataService<T> {
  /**
   * Retrieves the data accessor associated with this service.
   *
   * @return An instance of DataAccessor that provides CRUD (Create, Read, Update, Delete)
   *     operations on data models.
   */
  @Override
  public abstract DataAccessor<T> getAccessor();

  /**
   * Hook method called before saving a data model.
   *
   * @param entity the data model to be saved
   */
  protected void beforeSave(final T entity) {}

  /**
   * Hook method called after saving a data model.
   *
   * @param entity the saved data model
   */
  protected void afterSave(final T entity) {}

  /**
   * Hook method called before deleting a data model by its ID.
   *
   * @param id the ID of the data model to be deleted
   */
  protected void beforeDelete(final long id) {}

  /**
   * Hook method called before deleting a data model by its UID.
   *
   * @param uid the UID of the data model to be deleted
   */
  protected void beforeDelete(final String uid) {}

  /**
   * Hook method called after deleting a data model by its ID.
   *
   * @param id the ID of the data model that was deleted
   */
  protected void afterDelete(final long id) {}

  /**
   * Hook method called after deleting a data model by its UID.
   *
   * @param uid the UID of the data model that was deleted
   */
  protected void afterDelete(final String uid) {}

  /**
   * Saves a data model to the data store.
   *
   * <p>This method calls the {@link #beforeSave(T)} hook before saving the data model, and the
   * {@link #afterSave(T)} hook after successfully saving the data model.
   *
   * @param entity the data model to be saved
   * @return the saved data model
   */
  @Override
  public T save(final T entity) {
    beforeSave(entity);
    final T model = getAccessor().save(entity);
    afterSave(model);
    return model;
  }

  /**
   * Deletes a data model identified by its ID.
   *
   * <p>This method calls the {@link #beforeDelete(long)} hook before deleting the data model, and
   * the {@link #afterDelete(long)} hook after successfully deleting the data model.
   *
   * @param id the ID of the data model to be deleted
   */
  @Override
  public void delete(final long id) {
    beforeDelete(id);
    getAccessor().deleteById(id);
    afterDelete(id);
  }

  /**
   * Deletes a data model identified by its UID.
   *
   * <p>This method calls the {@link #beforeDelete(String)} hook before deleting the data model, and
   * the {@link #afterDelete(String)} hook after successfully deleting the data model.
   *
   * @param uid the UID of the data model to be deleted
   */
  @Override
  public void delete(final String uid) {
    beforeDelete(uid);
    getAccessor().deleteByUid(uid);
    afterDelete(uid);
  }
}
