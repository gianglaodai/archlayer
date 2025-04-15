package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.TransferObject;
import com.gh.archlayer.service.api.QueryService;
import com.gh.archlayer.service.filter.FilterFactory;
import com.gh.archlayer.service.model.Auditable;
import com.gh.archlayer.service.model.Identifiable;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractQueryController<
    T extends TransferObject & Identifiable & Auditable, M extends QueryModel> {
  public abstract QueryService<M> getService();

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
            parsePageRequest(firstResult, maxResults, rawOrders), FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
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
            parsePageRequest(firstResult, maxResults, rawOrders),
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
            parsePageRequest(firstResult, maxResults, rawOrders),
            FilterFactory.parseMany(filters))
        .stream()
        .map(getMapper()::toTransferObject)
        .toList();
  }

  public long count(final List<String> filters) {
    return getService().count(FilterFactory.parseMany(filters));
  }

  public abstract PageRequest parsePageRequest(
      final int firstResult, final int maxResults, final String rawOrders);
}
