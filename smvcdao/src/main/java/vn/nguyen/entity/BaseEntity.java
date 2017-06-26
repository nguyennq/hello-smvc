package vn.nguyen.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 772750961015024981L;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_created")
    private Date date_created = Calendar.getInstance().getTime();

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    private Date date_modified = Calendar.getInstance().getTime();

    @Column(name = "version_no")
    @Version
    private Integer version_no = 0;

    @CreatedBy
    private String created_by;

    @LastModifiedBy
    private String last_modified_by;

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    public Integer getVersion_no() {
        return version_no;
    }

    public void setVersion_no(Integer version_no) {
        this.version_no = version_no;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_modified_by() {
        return last_modified_by;
    }

    public void setLast_modified_by(String last_modified_by) {
        this.last_modified_by = last_modified_by;
    }

}
