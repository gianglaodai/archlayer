package com.gh.archlayer.controller;

import com.gh.archlayer.controller.model.ClientTO;
import com.gh.archlayer.service.api.DataService;
import com.gh.archlayer.service.exception.ServiceException;
import com.gh.archlayer.service.filter.FilterFactory;
import com.gh.archlayer.service.model.DataModel;
import com.gh.archlayer.service.paging.PageRequest;
import java.util.Collection;
import java.util.List;

public abstract class AbstractController<T extends ClientTO, M extends DataModel>
{
	public abstract DataService<M> getService();

	public abstract TransferObjectMapper<T, M> getMapper();

	public T getByUid(final String uid)
	{
		return getService().findByUid(uid).map(getMapper()::toTransferObject).orElseThrow(() -> ServiceException.newNotFoundException());
	}

	public List<T> findAll(final int firstResult, int maxResults, final String rawOrders, List<String> filters)
	{
		return getService().findAll(new PageRequest(firstResult, maxResults, PageRequest.parseOrders(rawOrders)), FilterFactory.parseMany(filters))
				.stream().map(getMapper()::toTransferObject).toList();
	}

	public void delete(long uid)
	{
		getService().delete(uid);
	}

	public List<T> findByUids(Collection<String> uids, final int firstResult, int maxResults, final String rawOrders, List<String> filters)
	{
		return getService().findByUids(uids, new PageRequest(firstResult, maxResults, PageRequest.parseOrders(rawOrders)),
				FilterFactory.parseMany(filters)).stream().map(getMapper()::toTransferObject).toList();
	}

	public long count(List<String> filters) {
		return getService().count(FilterFactory.parseMany(filters));
	}
}
