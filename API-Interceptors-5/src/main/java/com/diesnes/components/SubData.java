package com.diesnes.components;

import java.math.BigDecimal;

public class SubData {
	
	private long account;
	
	private BigDecimal [] balances;

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public BigDecimal[] getBalances() {
		return balances;
	}

	public void setBalances(BigDecimal[] balances) {
		this.balances = balances;
	}

}
