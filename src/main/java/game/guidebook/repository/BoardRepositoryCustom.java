package game.guidebook.repository;

import game.guidebook.service.dto.QueryParam;

public interface BoardRepositoryCustom {

    int findCountByCondition(QueryParam query_param);
}
