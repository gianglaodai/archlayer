package com.gh.archlayer.controller.model;

import com.gh.archlayer.service.model.Auditable;
import com.gh.archlayer.service.model.UniqueIdentifiable;
import java.time.Instant;
import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class ClientTO implements TransferObject, UniqueIdentifiable, Auditable
{
	private String uid;
	private int version;
	private Instant createdAt;
	private Instant updatedAt;

	public ClientTO(final String uid, final int version, final Instant createdAt, final Instant updatedAt)
	{
		this.uid = uid;
		this.version = version;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public ClientTO()
	{
		this(null, 0, null, null);
	}

	@Override
	public String getUid()
	{
		return uid;
	}

	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	@Override
	public int getVersion()
	{
		return version;
	}

	public void setVersion(final int version)
	{
		this.version = version;
	}

	@Override
	public Instant getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(final Instant createdAt)
	{
		this.createdAt = createdAt;
	}

	@Override
	public Instant getUpdatedAt()
	{
		return updatedAt;
	}

	public void setUpdatedAt(final Instant updatedAt)
	{
		this.updatedAt = updatedAt;
	}

	@Override
	public boolean equals(final Object o)
	{

		if (o == null || getClass() != o.getClass()) return false;
		final ClientTO clientTO = (ClientTO) o;
		return Objects.equals(uid, clientTO.uid);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(uid);
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("uid", uid).toString();
	}
}
