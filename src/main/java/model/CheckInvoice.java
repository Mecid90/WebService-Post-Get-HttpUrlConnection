package model;

public class CheckInvoice {

    String refNumber;

    public CheckInvoice() {
    }

    public CheckInvoice(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }
}
