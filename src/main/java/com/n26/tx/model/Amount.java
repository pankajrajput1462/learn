package com.n26.tx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author SINPANK
 */
@Data
@Entity
public class Amount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private double amount;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionTime;

}
