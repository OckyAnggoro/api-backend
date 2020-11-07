package com.app.repository;

import com.app.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<E extends BaseEntity> extends JpaSpecificationExecutor<E>, JpaRepository<E, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE #{#entityName} e SET e.deletedAt = CURRENT_DATE WHERE e.id IN ?1")
    void softDeleteByIds(List<Integer> ids);


}
