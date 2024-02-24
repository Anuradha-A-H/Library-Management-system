package com.example.librarymanagmentsystem.Repository;

import com.example.librarymanagmentsystem.Entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionsRepository extends JpaRepository<Transactions,String> {
}
