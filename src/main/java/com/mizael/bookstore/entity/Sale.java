package com.mizael.bookstore.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(nullable = false)
	private Double fullValue;
	
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private User user;
	
	@Transient
	@OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
	private List<ItemSale> itensSale;
	
	public Sale() {
	}

	public Sale(Long id, Double fullValue, Date date, User user, List<ItemSale> itensSale) {
		super();
		this.id = id;
		this.fullValue = fullValue;
		this.date = date;
		this.user = user;
		this.itensSale = itensSale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getFullValue() {
		return fullValue;
	}

	public void setFullValue(Double fullValue) {
		this.fullValue = fullValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ItemSale> getItensSale() {
		return itensSale;
	}

	public void setItensSale(List<ItemSale> itensSale) {
		this.itensSale = itensSale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((fullValue == null) ? 0 : fullValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (fullValue == null) {
			if (other.fullValue != null)
				return false;
		} else if (!fullValue.equals(other.fullValue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
