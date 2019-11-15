package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Report;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportRepository extends RepositoryWithSpecification<Report , Long> {
    //aniss
    public List<Report> getAllByPostId(Long postId);
}