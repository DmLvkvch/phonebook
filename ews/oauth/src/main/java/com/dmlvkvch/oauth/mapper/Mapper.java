package com.dmlvkvch.oauth.mapper;


import com.dmlvkvch.oauth.domain.AbstractEntity;
import com.dmlvkvch.oauth.dto.AbstractDto;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}