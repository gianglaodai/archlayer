package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.api.DataService;
import com.gh.archlayer.service.filter.FilterFactory;
import com.gh.archlayer.service.model.Auditable;
import com.gh.archlayer.service.model.DataModel;
import com.gh.archlayer.service.model.Identifiable;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractController<
    T extends TransferObject & Identifiable & Auditable, M extends DataModel> {
  public abstract DataService<M> getService();

  public abstract TransferObjectMapper<T, M> getMapper();

  public Optional<T> getById(final long id) {
    return getService().findById(id).map(getMapper()::toTransferObject);
  }

  public Optional<T> getByUid(final String uid) {
    return getService().findByUid(uid).map(getMapper()::toTransferObject);
  }

  public List<T> findAll(
      final int firstResult,
      final int maxResults,
      final String rawOrders,
      final List<String> filters) {
    return getService()
        .findAll(
            new PageRequest(firstResult, maxResults, PageRequest.parseOrders(rawOrders)),
            FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  public void delete(final long id) {
    getService().delete(id);
  }

  public void delete(final String uid) {
    getService().delete(uid);
  }

  public List<T> findByIds(
      final Collection<Long> ids,
      final int firstResult,
      final int maxResults,
      final String rawOrders,
      final List<String> filters) {
    return getService()
        .findByIds(
            ids,
            new PageRequest(firstResult, maxResults, PageRequest.parseOrders(rawOrders)),
            FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  public List<T> findByUids(
      final Collection<String> uids,
      final int firstResult,
      final int maxResults,
      final String rawOrders,
      final List<String> filters) {
    return getService()
        .findByUids(
            uids,
            new PageRequest(firstResult, maxResults, PageRequest.parseOrders(rawOrders)),
            FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  public long count(final List<String> filters) {
    return getService().count(FilterFactory.parseMany(filters));
  }
}
