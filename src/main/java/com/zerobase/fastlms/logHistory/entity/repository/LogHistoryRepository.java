package com.zerobase.fastlms.logHistory.entity.repository;

import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.logHistory.entity.LogHistory;
import com.zerobase.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface LogHistoryRepository extends JpaRepository<LogHistory,String> {

//    List<LogHistory> findAllByLogId(Iterable<String> iterables);

    @Override
   List<LogHistory> findAllById(Iterable<String> iterable);
}
