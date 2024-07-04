package com.api.resources.services;

import com.api.resources.dto.pagination.PaginationDTO;
import com.api.resources.persistence.mapper.UserMapper;
import com.api.resources.persistence.model.User;
import com.api.resources.persistence.repository.user.IUserPagSortRepository;
import com.api.resources.persistence.repository.user.IUserRepository;
import com.api.resources.services.interfaces.IUserService;
import com.api.resources.util.exceptions.APIError;
import com.api.resources.util.exceptions.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserPagSortRepository userPagSortRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PaginationService paginationService;




    @Override
    public PaginationDTO getAllUserListPageables(int page, int elements) {
        page--;
        if (elements <= 0 || page < 0) {
            throw new APIException(APIError.VALIDATION_ERROR);
        }
        Page<User> userPageable = getAllPageable(page, elements);
        return getUserListPaginated(userPageable, userMapper.mapUserDTOList(userPageable.getContent()));
    }

    public PaginationDTO getUserListPaginated(Page<?> userPageable, List<?> data){
        return paginationService.getDatapageable(userPageable, data);
    }


    public Page<User> getAllPageable(int page, int elements) throws APIException {
        Pageable pageRequest = PageRequest.of(page, elements);
        Page<User> userPageable = null;
        try {
            userPageable = userPagSortRepository.findAll(pageRequest);
        } catch (Exception e) {
            throw new APIException(APIError.VALIDATION_ERROR);
        }
        return userPageable;
    }




}
