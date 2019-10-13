package ensa.mobile.ivisitservice.beta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface RepositoryWithSpecification<M , ID> extends JpaRepository<M ,ID> , JpaSpecificationExecutor<M> {
}
