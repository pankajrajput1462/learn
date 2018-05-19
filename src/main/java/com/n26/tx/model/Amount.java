package com.n26.tx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SINPANK
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amount {

    private String amount;

    private String timestamp;
}
