package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP1;

public interface Checkpoint1Repository extends JpaRepository<CP1, Long> {
	
	@Query(value="SELECT CpID from CP1 "
			+ " where Cp1ID = :Cp1ID", nativeQuery=true)

	public CP1 findCp1ById (@Param("Cp1ID") int Cp1ID);

}
