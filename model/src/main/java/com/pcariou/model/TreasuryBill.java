package com.pcariou.model;

/**
 * TreasuryBill
 *
 */
public class TreasuryBill extends Instrument
{
    public TreasuryBill()
    {
        super();
    }

    public TreasuryBill(String name, double price, double yield)
    {
        super(name, price, yield);
    }

    @Override
    public String toString()
    {
        return "TreasuryBill [name=" + name + ", price=" + price + ", yield=" + yield + "]";
    }
}
