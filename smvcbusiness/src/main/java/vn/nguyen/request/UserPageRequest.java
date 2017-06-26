package vn.nguyen.request;

public class UserPageRequest {
    private int id;
    private int pageSize;
    private int pageOffset;
    private String orderBy;
    private boolean isAcsend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isAcsend() {
        return isAcsend;
    }

    public void setAcsend(boolean isAcsend) {
        this.isAcsend = isAcsend;
    }
}
