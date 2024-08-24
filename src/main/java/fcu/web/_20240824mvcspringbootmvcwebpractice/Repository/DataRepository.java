package fcu.web._20240824mvcspringbootmvcwebpractice.Repository;

import fcu.web._20240824mvcspringbootmvcwebpractice.Model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
}