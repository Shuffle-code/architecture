package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountGameDao extends JpaRepository<CountGame, Long> {
}
