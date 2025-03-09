package com.daviddiazm.housing.category.domain.dtos.requests;

public class PaginationRequest {
    private int page;
    private int size;
    private boolean orderAsc;

    public PaginationRequest(int page, int size, boolean orderAsc) {
        this.page = page;
        this.size = size;
        this.orderAsc = orderAsc;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOrderAsc() {
        return orderAsc;
    }

    public void setOrderAsc(boolean orderAsc) {
        this.orderAsc = orderAsc;
    }
}
