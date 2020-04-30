package wooteco.chess.repository;

import org.springframework.data.repository.CrudRepository;
import wooteco.chess.repository.entity.RoomEntity;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
    @Override
    List<RoomEntity> findAll();
}
