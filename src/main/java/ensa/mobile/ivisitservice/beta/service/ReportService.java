package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Report;
import ensa.mobile.ivisitservice.beta.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportService extends AbstractService<Long , ReportRepository, Report> {
    public ReportService(ReportRepository repository) {
        super(repository);
    }
    //aniss
    public List<Report> findReportsByPostId(Long postId){
        return repository.getAllByPostId(postId);
    }
}