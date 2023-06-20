package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP3;

public interface Checkpoint3Repository extends JpaRepository<CP3, Long> {
	
	@Query(value="SELECT CpID from CP3 "
			+ " where Cp3ID = :Cp3ID", nativeQuery=true)

	public CP3 findCp3ById (@Param("Cp3ID") int Cp3ID);

}
