package com.smartcity.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table( ame="complaints")
public class Complaint {
    @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

 @Column( ullable=false, unique=true)
    private String trackingCode;

 @Column( ullable=false)
    private String citizenName;

 @Column( ullable=false)
    private String email;

 @Column( ullable=false)
    private String category;

 @Column( ullable=false, length=2000)
    private String description;

 @Column( ullable=false)
    private String location;

    private String department;

 @Enumerated(EnumType.STRING)
 @Column( ullable=false)
    private ComplaintStatus status = ComplaintStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void updateTime() {
 updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTrackingCode() { return trackingCode; }
    public void setTrackingCode(String v) { trackingCode = v; }
    public String getCitizenName() { return citizenName; }
    public void setCitizenName(String v) { citizenName = v; }
    public String getEmail() { return email; }
    public void setEmail(String v) { email = v; }
    public String getCategory() { return category; }
    public void setCategory(String v) { category = v; }
    public String getDescription() { return description; }
    public void setDescription(String v) { description = v; }
    public String getLocation() { return location; }
    public void setLocation(String v) { location = v; }
    public String getDepartment() { return department; }
    public void setDepartment(String v) { department = v; }
    public ComplaintStatus getStatus() { return status; }
    public void setStatus(ComplaintStatus v) { status = v; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
