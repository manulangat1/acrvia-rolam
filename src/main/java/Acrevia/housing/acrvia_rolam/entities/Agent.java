package Acrevia.housing.acrvia_rolam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="agents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agent {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column( updatable = false, nullable = false)
    private UUID id;

    @Column( nullable = false )
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false)
    private  String email;

    @CreationTimestamp
    @Column(
            name = "created_at",
            updatable = false, nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(
            name = "updated_at",
            updatable = false,
            nullable = false
    )
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(id, agent.id) && Objects.equals(firstName, agent.firstName) && Objects.equals(lastName, agent.lastName) && Objects.equals(email, agent.email) && Objects.equals(createdAt, agent.createdAt) && Objects.equals(updatedAt, agent.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, createdAt, updatedAt);
    }

    @PrePersist
    protected  void onPersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected  void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
