package com.innopolis.repository;

import com.innopolis.entity.DomainObject;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */
interface UserRepository <V extends DomainObject> {

    void addUser(V user);
}
