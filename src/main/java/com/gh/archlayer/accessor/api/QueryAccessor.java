package com.gh.archlayer.accessor.api;

import com.gh.archlayer.service.filter.Filter;
import com.gh.archlayer.service.model.QueryModel;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface QueryAccessor<T extends QueryModel> {
  boolean existsById(long id);

  boolean existsByUid(String uid);

  boolean exists(List<? extends Filter<?>> filters);

  Optional<T> findById(long id);

  Optional<T> findByUid(String uid);

  Collection<T> findMany(PageRequest pageRequest, List<? extends Filter<?>> filters);

  Optional<T> findSingle(List<? extends Filter<?>> filters);

  Collection<T> findByIds(
      Collection<Long> ids, PageRequest pageRequest, List<? extends Filter<?>> filters);

  Collection<T> findByUids(
      Collection<String> uids, PageRequest pageRequest, List<? extends Filter<?>> filters);

  long count(List<? extends Filter<?>> filters);
}
