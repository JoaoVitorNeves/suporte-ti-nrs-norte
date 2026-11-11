package br.com.nrsnorte.suporte.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String protocol;

    @NotBlank @Column(nullable = false, length = 30)
    private String category;

    @NotBlank @Column(nullable = false, length = 20)
    private String priority;

    @NotBlank @Size(min = 10, max = 1500)
    @Column(nullable = false, length = 1500)
    private String description;

    @Column(nullable = false, length = 30)
    private String status = "Aberto";

    @Column(nullable = false, length = 100)
    private String requester;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void beforeInsert() {
        createdAt = LocalDateTime.now();
        if (protocol == null) protocol = "CH-" + createdAt.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        if (status == null) status = "Aberto";
    }

    public Long getId() { return id; }
    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRequester() { return requester; }
    public void setRequester(String requester) { this.requester = requester; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
