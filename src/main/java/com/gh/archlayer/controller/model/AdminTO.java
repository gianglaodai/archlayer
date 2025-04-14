package com.gh.archlayer.controller.model;

import com.gh.archlayer.service.model.Identifiable;
import java.time.Instant;

public abstract class AdminTO extends ClientTO implements Identifiable
{
	private long id;

	public AdminTO(final long id, final String uid, final int version, final Instant createdAt, final Instant updatedAt)
	{
		super(uid, version, createdAt, updatedAt);
		this.id = id;
	}

	public AdminTO()
	{
		this(0L, null, 0, null, null);
	}

	@Override
	public long getId()
	{
		return id;
	}

	public void setId(final long id)
	{
		this.id = id;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == null || getClass() != o.getClass()) return false;
		final AdminTO adminTO = (AdminTO) o;
		return id == adminTO.id;
	}

	@Override
	public int hashCode()
	{
		return Long.hashCode(id);
	}
}
