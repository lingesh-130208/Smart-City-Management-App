package com.smartcity.repository;

import com.smartcity.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ComplaintRepository extends JpaRepository&lt;Complaint, Long&gt; {
 Optional&lt;Complaint&gt; findByTrackingCode(String trackingCode);
 List&lt;Complaint&gt; findAllByOrderByCreatedAtDesc();
}
