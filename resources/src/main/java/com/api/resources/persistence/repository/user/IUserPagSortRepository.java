package com.api.resources.persistence.repository.user;

import com.api.resources.persistence.model.User;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface IUserPagSortRepository extends ListPagingAndSortingRepository<User, Integer> {


}
