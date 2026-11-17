package com.smartcity.service;

import com.smartcity.model.*;
import com.smartcity.repository.ComplaintRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ComplaintService {
    private final ComplaintRepository repo;

    public ComplaintService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public Complaint submit(Complaint c) {
        c.setTrackingCode("SC-" + UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase());
        c.setStatus(ComplaintStatus.PENDING);
        return repo.save(c);
    }

    public Complaint track(String code) {
        return repo.findByTrackingCode(code.trim().toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Tracking code not found."));
    }

    public List&lt;Complaint&gt; all() {
        return repo.findAllByOrderByCreatedAtDesc();
    }

    public Complaint update(Long id, String dept, ComplaintStatus status) {
        Complaint c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Complaint not found."));
        c.setDepartment(dept);
        c.setStatus(status);
        return repo.save(c);
    }
}
