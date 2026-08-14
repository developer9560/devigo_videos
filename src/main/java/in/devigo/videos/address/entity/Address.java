package in.devigo.videos.address.entity;

import in.devigo.videos.users.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
    nullable = false)
    private User user;

    @Column(name = "address_line",
    nullable = false)
    private String addressLine;

    private String city;
    private String state;
    private String country;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
