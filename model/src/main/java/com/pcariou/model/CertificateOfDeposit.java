package com.pcariou.model;

/**
 * CertificateOfDeposit
 *
 */
public class CertificateOfDeposit extends Instrument
{
    public CertificateOfDeposit()
    {
        super();
    }

    public CertificateOfDeposit(String name, double price, double yield)
    {
        super(name, price, yield);
    }

    @Override
    public String toString()
    {
        return "CertificateOfDeposit [name=" + name + ", price=" + price + ", yield=" + yield + "]";
    }
}
