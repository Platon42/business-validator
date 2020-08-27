package org.hash.validator.jpa;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "public", catalog = "postgres")
public class CompanyEntity {
    private int companyId;
    private String companyName;
    private String inn;
    private CompanyFormEntity companyFormByFormId;

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "inn")
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return companyId == that.companyId &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(inn, that.inn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, inn);
    }

    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    public CompanyFormEntity getCompanyFormByFormId() {
        return companyFormByFormId;
    }

    public void setCompanyFormByFormId(CompanyFormEntity companyFormByFormId) {
        this.companyFormByFormId = companyFormByFormId;
    }
}
