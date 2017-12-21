package br.com.assertsistemas.practice.deltaspike.jpa;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2950897862514250283L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID" )
    private Long id;

    @Version
    private int version;

    public BaseEntity() {
    }

    public BaseEntity( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals( Object obj ) {
        return this == obj
                || this.id != null
                && obj instanceof BaseEntity
                && obj.getClass().equals( getClass() )
                && this.id.equals( ( ( BaseEntity ) obj ).id );
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode( this.id );
        return hash;
    }

}
