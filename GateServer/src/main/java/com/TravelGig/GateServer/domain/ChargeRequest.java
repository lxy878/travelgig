package com.TravelGig.GateServer.domain;

public class ChargeRequest {
    public enum Currency {
        EUR, USD;
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
    private BookingDetail bd;
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public String getStripeEmail() {
        return stripeEmail;
    }
    public void setStripeEmail(String stripeEmail) {
        this.stripeEmail = stripeEmail;
    }
    public String getStripeToken() {
        return stripeToken;
    }
    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }
    public BookingDetail getBd() {
        return bd;
    }
    public void setBd(BookingDetail bd) {
        this.bd = bd;
    }
    @Override
    public String toString() {
        return "ChargeRequest [amount=" + amount + ", bd=" + bd + ", currency=" + currency + ", description="
                + description + ", stripeEmail=" + stripeEmail + ", stripeToken=" + stripeToken + "]";
    }
    

}
