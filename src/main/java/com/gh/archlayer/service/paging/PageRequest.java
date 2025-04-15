package com.gh.archlayer.service.paging;

import java.util.List;

public interface PageRequest {
  int getFirstResult();

  int getMaxResults();

  List<Order> getOrders();
}
