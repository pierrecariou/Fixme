package com.pcariou.model;

/**
 * Instrument
 *
 */
public class Instrument
{
    private String symbol;
    private String name;
    private String type;
    private String currency;
    private String exchange;
    private String multiplier;
    private String tickSize;
    private String lotSize;
    private String minTick;
    private String minSize;
    private String maxSize;
    private String settlement;
    private String expiry;
    private String strike;
    private String optionType;
    private String underlying;
    private String description;
    private String notes;

    public Instrument()
    {
    }

    public Instrument(String symbol, String name, String type, String currency, String exchange, String multiplier, String tickSize, String lotSize, String minTick, String minSize, String maxSize, String settlement, String expiry, String strike, String optionType, String underlying, String description, String notes)
    {
        this.symbol = symbol;
        this.name = name;
        this.type = type;
        this.currency = currency;
        this.exchange = exchange;
        this.multiplier = multiplier;
        this.tickSize = tickSize;
        this.lotSize = lotSize;
        this.minTick = minTick;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.settlement = settlement;
        this.expiry = expiry;
        this.strike = strike;
        this.optionType = optionType;
        this.underlying = underlying;
        this.description = description;
        this.notes = notes;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getExchange()
    {
        return exchange;
    }

    public void setExchange(String exchange)
    {
        this.exchange = exchange;
    }

    public String getMultiplier()
    {
        return multiplier;
    }

    public void setMultiplier(String multiplier)
    {
        this.multiplier = multiplier;
    }

    public String getTickSize()
    {
        return tickSize;
    }

    public void setTickSize(String tickSize)
    {
        this.tickSize = tickSize;
    }

    public String getLotSize()
    {
        return lotSize;
    }

    public void setLotSize(String lotSize)
    {
        this.lotSize = lotSize;
    }

    public String getMinTick()
    {
        return minTick;
    }

    public void setMinTick(String minTick)
    {
        this.minTick = minTick;
    }

    public String getMinSize()
    {
        return minSize;
    }

    public void setMinSize(String minSize)
    {
        this.minSize = minSize;
    }

    public String getMaxSize()
    {
        return maxSize;
    }

    public void setMaxSize(String maxSize)
    {
        this.maxSize = maxSize;
    }

    public String getSettlement()
    {
        return settlement;
    }

    public void setSettlement(String settlement)
    {
        this.settlement = settlement;
    }

    public String getExpiry()
    {
        return expiry;
    }

    public void setExpiry(String expiry)
    {
        this.expiry = expiry;
    }

    public String getStrike()
    {
        return strike;
    }

    public void setStrike(String strike)
    {
        this.strike = strike;
    }

    public String getOptionType()
    {
        return optionType;
    }

    public void setOptionType(String optionType)
    {
        this.optionType = optionType;
    }

    public String getUnderlying()
    {
        return underlying;
    }

    public void setUnderlying(String underlying)
    {
        this.underlying = underlying;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    @Override
    public String toString()
    {
        return "Instrument [symbol=" + symbol + ", name=" + name + ", type=" + type + ", currency=" + currency + ", exchange=" + exchange + ", multiplier=" + multiplier + ", tickSize=" + tickSize + ", lotSize=" + lotSize + ", minTick=" + minTick + ", minSize=" + minSize + ", maxSize=" + maxSize + ", settlement=" + settlement + ", expiry=" + expiry + ", strike=" + strike + ", optionType=" + optionType + ", underlying=" + underlying + ", description=" + description + ", notes=" + notes + "]";
    }
}
