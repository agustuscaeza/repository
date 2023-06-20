package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP4;

@Repository
public interface Checkpoint4Repository extends JpaRepository<CP4, Long> {
	
	@Query(value="SELECT CpID from CP4 "
			+ " where Cp4ID = :Cp4ID", nativeQuery=true)

	public CP4 findCp4ById (@Param("Cp4ID") int Cp4ID);

}
