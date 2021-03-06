package com.n26.tx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * It will contain all details related to transaction happened with in 60 sec time span.
 *
 * @author SINPANK
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountDetails {

    private double sum;

    private double avg;

    private double max;

    private double min;

    private long count;
}
