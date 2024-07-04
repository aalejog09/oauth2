package com.api.resources.services.interfaces;


import com.api.resources.dto.pagination.PaginationDTO;


public interface IUserService {

    public PaginationDTO getAllUserListPageables(int page, int elements);
}
