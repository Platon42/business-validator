package org.hash.validator.jpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "company_form", schema = "public", catalog = "postgres")
public class CompanyFormEntity {
    private int formId;
    private String formName;
    private Collection<CompanyEntity> companiesByFormId;

    @Id
    @Column(name = "form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    @Basic
    @Column(name = "form_name")
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyFormEntity that = (CompanyFormEntity) o;
        return formId == that.formId &&
                Objects.equals(formName, that.formName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId, formName);
    }

    @OneToMany(mappedBy = "companyFormByFormId")
    public Collection<CompanyEntity> getCompaniesByFormId() {
        return companiesByFormId;
    }

    public void setCompaniesByFormId(Collection<CompanyEntity> companiesByFormId) {
        this.companiesByFormId = companiesByFormId;
    }
}
