package com.pcariou.model;

/**
 * FIXMessage
 *
 */
public class FIXMessage
{
    private String broker;
    private String market;
    private String symbol;
    private String side;
    private String quantity;
    private String price;
    private String time;
    private String status;
    private String orderID;
    private String execID;
    private String execType;
    private String leavesQty;
    private String cumQty;
    private String avgPx;
    private String lastShares;
    private String lastPx;
    private String lastMkt;

    public FIXMessage()
    {
    }

    public FIXMessage(String broker, String market, String symbol, String side, String quantity, String price, String time, String status, String orderID, String execID, String execType, String leavesQty, String cumQty, String avgPx, String lastShares, String lastPx, String lastMkt)
    {
        this.broker = broker;
        this.market = market;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.time = time;
        this.status = status;
        this.orderID = orderID;
        this.execID = execID;
        this.execType = execType;
        this.leavesQty = leavesQty;
        this.cumQty = cumQty;
        this.avgPx = avgPx;
        this.lastShares = lastShares;
        this.lastPx = lastPx;
        this.lastMkt = lastMkt;
    }

    public String getBroker()
    {
        return broker;
    }

    public void setBroker(String broker)
    {
        this.broker = broker;
    }

    public String getMarket()
    {
        return market;
    }


}
