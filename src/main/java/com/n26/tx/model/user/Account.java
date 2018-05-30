package com.n26.tx.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private int account_no;
    private int account_type;
    private int isAccountActive;
}
